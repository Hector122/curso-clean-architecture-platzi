package LeetCode.LinkedList;

import java.util.HashMap;
import java.util.HashSet;

//https://leetcode.com/problems/linked-list-cycle/
public class LinkedListCycle {
    /**
     * Fast and slow pointer
     */
    public boolean hasCycleWithFastAndSlowPointer(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(fast == slow) return true;
        }

        return false;
    }

    /**
     * With hash set
     */
    public boolean hasCycle(ListNode head) {
        HashSet<Object> hashSet = new HashSet<>();

        while (head != null) {
            if (hashSet.contains(head)) return true;

            hashSet.add(head);
            head = head.next;
        }
        return false;
    }
}
