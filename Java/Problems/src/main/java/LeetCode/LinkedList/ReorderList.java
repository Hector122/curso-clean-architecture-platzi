package LeetCode.LinkedList;

//https://leetcode.com/problems/reorder-list/
public class ReorderList {
    public void reorderList(ListNode head) {
        //find the middle
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHead = slow.next;
        ListNode prev = null;
        slow.next = null;

        //reverse the second list
        while (secondHead != null) {
            ListNode temp = secondHead.next;
            secondHead.next = prev;
            prev = secondHead;
            secondHead = temp;
        }

        ListNode fistHead = head;
        secondHead = prev;

        //merge two list
        while (secondHead != null) {
            // 1 -> 2 -> 3 -> 4
            // 5 -> 6 -> 7
            ListNode temp1 = fistHead.next; //2
            ListNode temp2 = secondHead.next; //6

            fistHead.next = secondHead;
            secondHead.next = temp1;

            fistHead = temp1;
            secondHead = temp2;
        }
    }
}
