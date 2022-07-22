package LeetCode.LinkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoveNthNodeFromEndTest {

    private RemoveNthNodeFromEnd solution;

    @BeforeEach
    void setUp(){
        solution = new RemoveNthNodeFromEnd();
    }

    /**
     * Input: head = [1,2,3,4,5], n = 2
     * Output: [1,2,3,5]
     */
    @Test
    void test_00(){
        ListNode le = new ListNode(5, null);
        ListNode ld = new ListNode(4, le);
        ListNode lc = new ListNode(3, ld);
        ListNode lb = new ListNode(2, lc);
        ListNode la = new ListNode(1, lb);

        //Then
        ListNode response = solution.removeNthFromEnd(la, 2);

        //equal
        assertArrayEquals(new int[]{1,2,3,5}, new LinkedListValues().getArrayIterative(response));
    }
    /**
     * Input: head = [1], n = 1
     * Output: []
     */
    @Test
    void test_01(){
        ListNode la = new ListNode(1, null);
        //Then
        ListNode response = solution.removeNthFromEnd(la, 1);

        //equal
        assertArrayEquals(new int[]{}, new LinkedListValues().getArrayIterative(response));
    }

    /**
     * Input: head = [1,2], n = 1
     * Output: [1]
     */
    @Test
    void test_02(){
        ListNode lb = new ListNode(2, null);
        ListNode la = new ListNode(1, lb);

        //Then
        ListNode response = solution.removeNthFromEnd(la, 1);

        //equal
        assertArrayEquals(new int[]{1}, new LinkedListValues().getArrayIterative(response));
    }
}