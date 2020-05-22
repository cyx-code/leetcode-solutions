package cyx.solution.leetcode.tree;

import cyx.solution.leetcode.common.TreeNode;

import java.util.Arrays;

public class BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length < 1) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 0; i < preorder.length; i++) {
            if (preorder[0] == inorder[i]) {
                root.left = buildTree( Arrays.copyOfRange(preorder, 1, i + 1), Arrays.copyOfRange(inorder, 0, i));
                root.right = buildTree( Arrays.copyOfRange(preorder, i + 1, preorder.length), Arrays.copyOfRange(inorder, i + 1, inorder.length));

            }
        }
        return root;
    }

}
