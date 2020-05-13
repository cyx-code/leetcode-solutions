package cyx.solution.leetcode.tree;

import cyx.solution.leetcode.common.TreeNode;

import java.util.*;

/**
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 *  
 *
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LevelOrder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right =new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        LevelOrder levelOrder = new LevelOrder();
        List<List<Integer>> lists = levelOrder.levelOrder(root);
        lists.forEach( list -> {
            list.forEach(l -> {
                System.out.print(l);
            });
            System.out.println();
        });
    }
    // 广度优先遍历的思想去解题
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result =  new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        first.add(root.val);
        result.add(first);
        // 使用队列而不是栈，因为会导致后续遍历会从右节点开始，导致顺序不对
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            // 本来用的是集合去装一层的节点，但是超出了内存
//            List<TreeNode> nodes = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            while(size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    list.add(node.left.val);
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    list.add(node.right.val);
                    queue.offer(node.right);
                }
                size--;
            }
            if (!list.isEmpty()) {
                result.add(list);
            }
        }
        return result;
    }
}
