package LeetCode.LinkedList;

public class TraversalLinkedList {

    public void iterative(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public ListNode recursive(ListNode head) {
        if (head == null) return null;
        System.out.println(head.val);
        return recursive(head.next);
    }
}
