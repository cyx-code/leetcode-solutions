package cyx.solution.leetcode.linklsit;

import cyx.solution.leetcode.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class IsPalindrome {
    /**
     * 利用了额外的存储空间来判断是不是回文链表
     * @param head
     * @return
     */
    public boolean isPalindromeByList(ListNode head) {
        List<Integer> nodes = new ArrayList<>();
        ListNode cur = head;
        // 将节点中的值添加到集合中
        while (cur != null) {
            nodes.add(cur.val);
            cur = cur.next;
        }
        int left = 0;
        int right = nodes.size() - 1;
        // 从两端判断是否是回文链表
        while (left < right) {
            if (nodes.get(left).equals(nodes.get(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * 根据快慢指针求解
     * @param head
     */
    public boolean isPalindromeByDoublePointer(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        /**
         * 先利用快慢指针找到链表中间节点
         */
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode temp = slow.next;
        // 将原链表切割
        slow.next = null;
        // 翻转原链表后半段
        ListNode other = reverse(temp);
        // 比较前后端链表
        while (other != null && head != null) {
            if (other.val != head.val) {
                return false;
            }
            other = other.next;
            head = head.next;
        }
        return true;
    }

    /**
     * 翻转链表
     * @param head
     * @return
     */
    private ListNode reverse(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        new IsPalindrome().isPalindromeByDoublePointer(head);
    }
}
