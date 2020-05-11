package cyx.solution.leetcode.linklsit;

import cyx.solution.leetcode.common.ListNode;
public class MergeKLists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(11);
        ListNode l2 = new ListNode(5);
        ListNode l3 = new ListNode(-1);
        l3.next = l2;
        l2.next = l1;
        ListNode ll1 = new ListNode(4);
        ListNode ll2 = new ListNode(3);
        ListNode ll3 = new ListNode(1);
        ll3.next = ll2;
        ll2.next = ll1;
        System.out.println(l3);
        System.out.println(ll3);
        ListNode lll1 = new ListNode(10);
        ListNode lll2 = new ListNode(6);
        lll2.next = lll1;
        ListNode[] lists = new ListNode[4];
        lists[0] = null;
        lists[1] = l3;
        lists[2] = null;
        lists[3] = lll2;
        MergeKLists mergeKLists = new MergeKLists();
        ListNode merge = mergeKLists.mergeKLists(lists);
        System.out.println(merge);
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return merge(lists, 0, lists.length - 1);
    }
    private ListNode merge(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        int mid = start + ((end - start) >> 1);
        ListNode l1 = merge(lists, start, mid);
        ListNode l2 = merge(lists, mid + 1, end);
        return merge(l1, l2);

    }
    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == l2) {
            return l1;
        }
        ListNode result = new ListNode(0);
        ListNode head = result;
        ListNode l1Cursor = l1;
        ListNode l2Cursor = l2;
        while (l1Cursor != null && l2Cursor != null) {
            if (l1Cursor.val < l2Cursor.val) {
                result.next = l1Cursor;
                l1Cursor = l1Cursor.next;
            } else {
                result.next = l2Cursor;
                l2Cursor = l2Cursor.next;
            }
            result = result.next;
        }
        if (l1Cursor != null) {
            result.next = l1Cursor;
        }
        if (l2Cursor != null) {
            result.next = l2Cursor;
        }
        return head.next;
    }
}
