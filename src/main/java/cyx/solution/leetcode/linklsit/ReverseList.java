package cyx.solution.leetcode.linklsit;

import cyx.solution.leetcode.common.ListNode;

/**
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseList {
    // 迭代解法
    /*public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }*/

    // 递归解法
    public ListNode reverseList(ListNode head) {
        // 递归终止条件
        if (head == null || head.next == null) {
            return head;
        }
        // 递归找到链表尾
        ListNode cur = reverseList(head.next);
        // 以cur指向5时为例，此时head为4，则head.next.next = head 为5->4
        head.next.next = head;
        // 防止循环指向
        head.next = null;
        return cur;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode cursor = head;
        for (int i = 1; i < 6; i++) {
            cursor.next = new ListNode(i);
            cursor = cursor.next;
        }
        System.out.println(head);
        System.out.println(new ReverseList().reverseList(head));
    }
}
