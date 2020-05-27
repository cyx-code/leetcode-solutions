package cyx.solution.leetcode.tree;

import cyx.solution.leetcode.common.TreeNode;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 *  
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *  
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *  
 *
 * 进阶：
 *
 * 你可以运用递归和迭代两种方法解决这个问题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/symmetric-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    /**
     * 树是否对称，只需判断左子树和右子树是否对称，
     * 左子树与右子树是否对称，只需看左孩子树和右孩子树是否对称
     * ...对于叶子节点，只需左子树的左叶子和右子树的右叶子相等且左子树的右叶子和右子树的左叶子相等（有点绕，哈哈）
     * @param left
     * @param right
     * @return
     */
    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            // 左右子树都为空。对称
            return true;
        } else if (left == null || right == null) {
            // 其中一个为空。不对称
            return false;
        } else if (left.val != right.val){
            // 左、右节点不同，不对称
            return false;
        } else {
            // 判断左树的左子树和右树的右子树是否相等且左树的右子树和右树的左子树是否相等
            return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
        }
    }

    public static void main(String[] args) {

    }
}
