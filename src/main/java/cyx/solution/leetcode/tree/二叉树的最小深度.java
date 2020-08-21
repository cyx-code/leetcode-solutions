package cyx.solution.leetcode.tree;

import cyx.solution.leetcode.common.TreeNode;

/**
 * @description: 二叉树的最小深度
 * @author: cyx
 * @create: 2020/08/21
 */
public class 二叉树的最小深度 {

    /**
     * 二叉树的最小深度，采用先序遍历的方式获取叶子结点的深度
     * 通过比较得到结果
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        // 根节点为空时，直接返回0
        if (root == null) {
            return 0;
        }
        // 当右叶子节点为空，左叶子结点不为空时，需得到左叶子结点的深度
        if (root.left != null && root.right == null) {
            return 1 + minDepth(root.left);
        }
        // 当左叶子结点为空，右叶子结点不为空时，需得到右叶子结点的深度
        if (root.right != null && root.left == null) {
            return 1 + minDepth(root.right);
        }
        // 左右叶子都不为空，返回较小的深度
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
