package cyx.solution.leetcode.tree;

import cyx.solution.leetcode.common.TreeNode;
import javafx.util.Pair;

import java.util.LinkedList;

/**
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxDepth {
    /**
     * 递归查找树的最大深度
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 根的最大深度等于左子树的最大深度与右子树的最大深度的最大值 再加上1（根到子节点的距离）。
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    /**
     * leetcode官方DFS题解
     * @param root
     * @return
     */
    public int maxDepthByDFS(TreeNode root) {
        // Pair是键值对对象，可以在key和value都是描述信息时使用
        // Java官方不推荐使用Stack，可以使用Deque双端队列或LinkedList双向链表代替
        LinkedList<Pair<TreeNode, Integer>> stack = new LinkedList<>();
        if (root != null) {
            stack.add(new Pair<>(root, 1));
        }
        int maxDepth = 0;
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> curr = stack.poll();
            TreeNode currentNode = curr.getKey();
            Integer currentDepth = curr.getValue();
            if (currentNode != null) {
                // 得到当前最大深度
                maxDepth = Math.max(maxDepth, currentDepth);
                // 将节点加入stack
                stack.add(new Pair<>(currentNode.left, currentDepth + 1));
                stack.add(new Pair<>(currentNode.right, currentDepth + 1));
            }
        }
        return maxDepth;
    }




    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        MaxDepth maxDepth = new MaxDepth();
        System.out.println(maxDepth.maxDepthByDFS(root));
    }
}
