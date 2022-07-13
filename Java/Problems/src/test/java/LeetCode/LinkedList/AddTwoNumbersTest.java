package LeetCode.LinkedList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddTwoNumbersTest {

    /*** Your input
        [2,4,3]
        [5,6,4]
     Output
        [7,0,8]
     Expected
        [7,0,8]
     */
    @Test
    void test_out_solution() {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();

        // Giving
        ListNode l1a = new ListNode(2);
        ListNode l1b = new ListNode(4);
        ListNode l1c = new ListNode(3, null);
        l1a.next = l1b;
        l1b.next = l1c;

        ListNode l2c = new ListNode(4, null);
        ListNode l2b = new ListNode(6, l2c);
        ListNode l2a = new ListNode(5, l2b);
        
        //Then
        AddTwoNumbers solution = new AddTwoNumbers();
        ListNode response = solution.addTwoNumbers(l1a, l2a);

        //equal
        assertArrayEquals(new int[]{7, 0, 8}, new LinkedListValues().iterative(response));
    }
}