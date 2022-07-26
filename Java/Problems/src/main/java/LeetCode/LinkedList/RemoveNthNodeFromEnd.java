package LeetCode.LinkedList;

//https://leetcode.com/problems/remove-nth-node-from-end-of-list/
public class RemoveNthNodeFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = new ListNode(-1, head);
        ListNode left = temp, right = temp;

        while (n > 0){
            right = right.next;
            n--;
        }

        while (right.next != null){
            right = right.next;
            left = left.next;
        }

        left.next = left.next.next;

        return temp.next;
    }
}
