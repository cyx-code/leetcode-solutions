package cyx.solution.leetcode.tree;

import cyx.solution.leetcode.common.TreeNode;

import java.util.HashMap;

/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    /**
     *
     * @param nums
     * @param l
     * @param r
     * @return
     */
    private TreeNode sortedArrayToBST(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        // 由于数组有序，先将中间值至为根结点
        int mid = r + ((l - r) >> 1);
        TreeNode root = new TreeNode(nums[mid]);
        // 递归构建左右子树
        root.left = sortedArrayToBST(nums, l, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, r);
        return root;
    }
    public static void main(String[] args) {
        int r = 3; int l = 5;
        int mid = r + ((l - r) >> 1);

        System.out.println(mid);
    }
}
