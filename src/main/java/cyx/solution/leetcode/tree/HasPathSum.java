package cyx.solution.leetcode.tree;

import cyx.solution.leetcode.common.TreeNode;

/**
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例: 
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class HasPathSum {

    /**
     * 递归求解
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        // 如果根节点为null返回false
        if (root == null) return false;
        // 如果已经到了叶子节点，判断是否满足条件
        if (root.left == null && root.right == null) {
            return (sum ^ root.val) == 0;
        }
        // 先序遍历左节点和右节点得到结果
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }


    public static void main(String[] args) {

    }
}
