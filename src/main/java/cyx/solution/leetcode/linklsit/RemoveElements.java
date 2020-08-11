package cyx.solution.leetcode.linklsit;

import cyx.solution.leetcode.common.ListNode;

/**
 * @description: 移除链表元素
 * @author: cyx
 * @create: 2020/08/11
 *
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 *
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
public class RemoveElements {
    /**
     * @Author: cyx
     * @Description: 遍历链表，遇到要删除的节点，只需将其指向下一个节点就行
     * @Date: 2020-08-11
     * @param: head
     * @param: val
     * @return: cyx.solution.leetcode.common.ListNode
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cursor = dummy;
        while (cursor.next != null) {
            if (cursor.next.val == val) {
                cursor.next = cursor.next.next;
            } else {
                cursor = cursor.next;
            }
        }
        return dummy.next;
    }
}
