package cyx.solution.leetcode.common;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        ListNode cursor = this;
        StringBuilder sb = new StringBuilder();
        while (cursor != null) {
            sb.append(cursor.val).append("->");
            cursor = cursor.next;
        }
        return sb.substring(0, sb.length() - 2);
    }
}
