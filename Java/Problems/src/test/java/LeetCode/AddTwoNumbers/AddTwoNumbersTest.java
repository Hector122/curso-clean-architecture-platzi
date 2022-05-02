package LeetCode.AddTwoNumbers;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class AddTwoNumbersTest {
    /* Your input
        [2,4,3]
        [5,6,4]
     Output
        [7,0,8]
    Expected
        [7,0,8]
     */

    @Test
    void test_out_solution(){
     AddTwoNumbers addTwoNumbers = new AddTwoNumbers();

     // Giving
     ListNode l1 = new ListNode();
     ListNode l2 = new ListNode();

     //Then
     AddTwoNumbers solution = new AddTwoNumbers();
     ListNode response = solution.addTwoNumbers(l1, l2);

     //equal
        //assertArrayEquals("[7,0,8]", Arrays.toString());

    }
}