package cyx.solution.leetcode.tree;

import cyx.solution.leetcode.common.TreeNode;

/**
 * @description: 相同的树
 * @author: cyx
 * @create: 2020/08/07
 *
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * 示例 1:
 *
 * 输入:       1         1
 *           / \       / \
 *          2   3     2   3
 *
 *         [1,2,3],   [1,2,3]
 *
 * 输出: true
 * 示例 2:
 *
 * 输入:      1          1
 *           /           \
 *          2             2
 *
 *         [1,2],     [1,null,2]
 *
 * 输出: false
 * 示例 3:
 *
 * 输入:       1         1
 *           / \       / \
 *          2   1     1   2
 *
 *         [1,2,1],   [1,1,2]
 *
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/same-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 相同的树 {
    /**
     * @Author: cyx
     * @Description: 先序遍历两颗树，判断是否是相同的树
     * @Date: 2020-08-07
     * @param: p
     * @param: q
     * @return: boolean
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 如果叶子节点都是空，则相同
        if (p == null && q == null) return true;
        // 一边为空一边不为空
        if (p == null || q == null) return false;
        // 值不一致
        if (p.val != q.val) return false;
        // 得左右子树都相同才是相同的树
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
