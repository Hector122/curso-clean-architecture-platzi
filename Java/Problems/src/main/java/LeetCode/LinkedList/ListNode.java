package LeetCode.LinkedList;

public class ListNode {
    int val;
    ListNode next;

    public ListNode() {
        next = null;
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
