import LeetCode.LinkedList.ListNode;
import LeetCode.LinkedList.TraversalLinkedList;
import LeetCode.TwoSum;

import java.util.Arrays;

public class Main {
    public static void main(String arg[]){
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(6);

        a.setNext(b);
        b.setNext(c);
        c.setNext(d);

        TraversalLinkedList list = new TraversalLinkedList();
        list.iterative(a);
    }
}
