package LeetCode.LinkedList;

/**
 * https://leetcode.com/problems/reverse-linked-list/
 */
public class ReverseList {
    //Use three pointers and so you can change the next of the mid to the first one without losing
    // the track of the original left.

    //Iterative version
    public ListNode reverseList(ListNode head) {
        ListNode prevNode = null;
        ListNode nextNode = null;
        ListNode currentNode = head;

        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
        }

        return prevNode;
    }

    //Recursive version
    public ListNode reverseListRecursive(ListNode head) {
        return reverse(head, null);
    }

    public ListNode reverse(ListNode node, ListNode prev){
        // head = null then whe finish
        if(node == null)
            return prev;

        ListNode temp = node.next;
        node.next = prev;

        return reverse(temp, node);
    }
}
