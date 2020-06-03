package cyx.solution.leetcode.common;

public class TreeUtil {
    public static void pre(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        pre(root.left);
        pre(root.right);
    }
}
