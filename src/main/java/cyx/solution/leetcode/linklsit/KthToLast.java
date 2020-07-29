package cyx.solution.leetcode.linklsit;

import cyx.solution.leetcode.common.ListNode;

/**
 * 返回倒数第 k 个节点
 * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 *
 * 注意：本题相对原题稍作改动
 *
 * 示例：
 *
 * 输入： 1->2->3->4->5 和 k = 2
 * 输出： 4
 * 说明：
 *
 * 给定的 k 保证是有效的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-node-from-end-of-list-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class KthToLast {
    /**
     * 快慢指针得到倒数第K个节点
     * @param head
     * @param k
     * @return
     */
    public int kthToLastByDoublePointer(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        // 先定位快指针的起始位置
        while (k > 0) {
            fast = fast.next;
            k--;
        }
        // 当快指针为空时，表示慢指针到达倒数第k个位置
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow.val;
    }

    /**
     * 先得到链表长度，然后循环l - k + 1次可以得到倒数第K个节点
     * @param head
     * @param k
     * @return
     */
    public int kthToLast(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int length = 0;
        ListNode cursor = head;
        while (cursor != null) {
            length++;
            cursor = cursor.next;
        }
        ListNode res = dummy;
        for (int i = 0; i < length - k + 1; i++) {
            res = res.next;
        }
        return res.val;
    }
}
