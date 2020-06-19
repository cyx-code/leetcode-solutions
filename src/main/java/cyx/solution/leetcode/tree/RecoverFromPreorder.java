package cyx.solution.leetcode.tree;

import cyx.solution.leetcode.common.TreeNode;
import javafx.util.Pair;

import java.util.LinkedList;

/**
 * 我们从二叉树的根节点 root 开始进行深度优先搜索。
 *
 * 在遍历中的每个节点处，我们输出 D 条短划线（其中 D 是该节点的深度），然后输出该节点的值。（如果节点的深度为 D，则其直接子节点的深度为 D + 1。根节点的深度为 0）。
 *
 * 如果节点只有一个子节点，那么保证该子节点为左子节点。
 *
 * 给出遍历输出 S，还原树并返回其根节点 root。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入："1-2--3--4-5--6--7"
 * 输出：[1,2,5,3,4,6,7]
 * 示例 2：
 *
 *
 *
 * 输入："1-2--3---4-5--6---7"
 * 输出：[1,2,5,3,null,6,null,4,null,7]
 * 示例 3：
 *
 *
 *
 * 输入："1-401--349---90--88"
 * 输出：[1,401,null,349,88,90]
 *  
 *
 * 提示：
 *
 * 原始树中的节点数介于 1 和 1000 之间。
 * 每个节点的值介于 1 和 10 ^ 9 之间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/recover-a-tree-from-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RecoverFromPreorder {
    public TreeNode recoverFromPreorder(String S) {
        LinkedList<TreeNode> list = new LinkedList<>();
        int i = 0;
        while (i < S.length()) {
            int level = 0;
            // 得到当前节点在树中的深度
            while (S.charAt(i) == '-') {
                level++;
                i++;
            }
            int value = 0;
            // 得到当前节点中的值
            while (i < S.length() && Character.isDigit(S.charAt(i))) {
                value = value * 10 + (S.charAt(i) - '0');
                i++;
            }
            TreeNode node = new TreeNode(value);
            // 如果当前节点的深度和队列大小相等
            if (level == list.size()) {
                // 空则为root节点
                if (!list.isEmpty()) {
                    // 由于是先序遍历，该节点就是队尾节点的左子节点
                    list.peekLast().left = node;
                }
            } else {
                // 如果队列大小大于当前节点深度，则表示该节点的父节点已经入队
                while (list.size() != level) {
                    // 队列大小等于当前节点深度相同时，相当于找到了当前节点的父节点
                    list.pollLast();
                }
                // 这儿开始是右孩子节点
                list.peekLast().right = node;
            }
            // 将节点入队，因为可能作为别的节点的父节点
            list.offer(node);
        }
        // 返回队首元素
        return list.peek();
    }

    public static void main(String[] args) {
        RecoverFromPreorder preorder = new RecoverFromPreorder();
        TreeNode res = preorder.recoverFromPreorder("1-401--349---90--88");
        System.out.println();
    }
}
