package LeetCode.LinkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListCycleTest {
    private LinkedListCycle solution;

    @BeforeEach
    void setUp(){
        solution = new LinkedListCycle();
    }

    /**
     * Input: head = [3,2,0,-4], pos = 1
     * Output: true
     * Explanation: There is a cycle in the linked list,
     * where the tail connects to the 1st node (0-indexed).
     */
    @Test
    void test_00(){
        ListNode la = new ListNode(3);
        ListNode lb = new ListNode(3);
        ListNode lc = new ListNode(0);
        ListNode ld = new ListNode(-4);

        la.next = lb;
        lb.next = lc;
        lc.next = ld;
        ld.next = lb; //make cycle true | c-> b

        boolean response = solution.hasCycleWithFastAndSlowPointer(la);

        assertTrue(response);
    }

    /**
     * Input: head = [1,2], pos = 0
     * Output: true
     * Explanation: There is a cycle in the linked list,
     * where the tail connects to the 0th node.
     */
    @Test
    void test_01(){
        ListNode la = new ListNode(1);
        ListNode lb = new ListNode(2);

        la.next = lb;
        lb.next = la; //make cycle true

        boolean response = solution.hasCycleWithFastAndSlowPointer(la);

        assertTrue(response);
    }

    /**
     * Input: head = [1], pos = -1
     * Output: false
     * Explanation: There is no cycle in the linked list.
     */
    @Test
    void test_03(){
        ListNode la = new ListNode(1);
        boolean response = solution.hasCycle(la);

        assertFalse(response);
    }
}