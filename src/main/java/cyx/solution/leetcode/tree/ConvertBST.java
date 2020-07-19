package cyx.solution.leetcode.tree;

import cyx.solution.leetcode.common.TreeNode;

/**
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 *
 *  
 *
 * 例如：
 *
 * 输入: 原始二叉搜索树:
 *               5
 *             /   \
 *            2     13
 *
 * 输出: 转换为累加树:
 *              18
 *             /   \
 *           20     13
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-bst-to-greater-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ConvertBST {
    /**
     * 二叉搜索树的中序遍历结果是一个递增的有序序列
     * 所以反向中序遍历，并将每个节点的值加上上一个遍历的节点的值就可得到二叉累加树
     */
    int sum = 0;

    /**
     * 右根左的遍历顺序
     * @param root
     * @return
     */
    public TreeNode convertBST(TreeNode root) {
        if (root != null)  {
            // 先遍历右节点
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            // 遍历左节点
            convertBST(root.left);
        }
        return root;
    }

    public static void main(String[] args) {

    }
}
