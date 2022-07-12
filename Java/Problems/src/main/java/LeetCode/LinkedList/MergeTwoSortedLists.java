package LeetCode.LinkedList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

//https://leetcode.com/problems/merge-two-sorted-lists/
public class MergeTwoSortedLists {
    //iterative
    public ListNode mergeTwoListsIterative(ListNode list1, ListNode list2) {
        final ListNode temp = new ListNode();
        ListNode tail = temp;
        while (list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        // if one list have more element than the other.
        tail.next = list1 != null? list1 : list2;

        return temp.next;
    }

    // Solution using Recursion
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);

        if (list1 == null && list2 == null) return null;
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if(list1.val > list2.val) {
            head = list2;
            list2 = list2.next;
        } else {
            head = list1;
            list1 = list1.next;
        }

        head.next = mergeTwoLists(list1, list2);
        return head;
    }
}
