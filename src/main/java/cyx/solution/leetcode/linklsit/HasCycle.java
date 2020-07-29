package cyx.solution.leetcode.linklsit;

import cyx.solution.leetcode.common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 141. 环形链表
 * 给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 *
 *
 * 示例 1：
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 *
 * 示例 2：
 *
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 *
 * 示例 3：
 *
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 *
 *
 *
 *
 * 进阶：
 *
 * 你能用 O(1)（即，常量）内存解决此问题吗？
 */
public class HasCycle {
    /**
     * Hash表存储求解
     * 内存O(n)
     * @param head
     * @return
     */
    public boolean hasCycleByHashSet(ListNode head) {
        // 将出现过的节点存储
        Set<ListNode> set = new HashSet<ListNode>();
        ListNode cursor = head;
        // 遍历链表
        while (cursor != null) {
            if (set.contains(cursor.next)) {
                return true;
            }
            set.add(cursor);
            cursor = cursor.next;
        }
        return false;
    }

    /**
     * 双指针判断链表是否存在环，
     * 思路：快慢指针，如果存在环，则指针一定会相遇
     * 内存O(1)
     * @param head
     * @return
     */
    public boolean hasCycleByDoublePointer(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        // 快指针，一次走过两个节点
        ListNode fast = head.next;
        // 慢指针，一次走过一个节点
        ListNode slow = head;
        // 当快慢指针相同时，表示有环
        while (fast != slow) {
            // 当快指针为null或下一个节点为null时，表示快指针到达终点，链表不存在环
            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }

}
