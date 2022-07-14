package LeetCode.LinkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeTwoSortedListsTest {
    private MergeTwoSortedLists solution;

    @BeforeEach
    void setUp(){
        solution = new MergeTwoSortedLists();
    }

    /***
     * Input: list1 = [1,2,4], list2 = [1,3,4]
     * Output: [1,1,2,3,4,4]
     */
    @Test
    void test_00(){
        ListNode l1c = new ListNode(4, null);
        ListNode l1b = new ListNode(2, l1c);
        ListNode l1a = new ListNode(1, l1b);

        ListNode l2c = new ListNode(4, null);
        ListNode l2b = new ListNode(3, l2c);
        ListNode l2a = new ListNode(1, l2b);

        //Then
        ListNode response = solution.mergeTwoLists(l1a, l2a);
        //ListNode response = solution.mergeTwoListsIterative(l1a, l2a);

        //equal
        assertArrayEquals(new int[]{1,1,2,3,4,4}, new LinkedListValues().getArrayIterative(response));
    }

    /**
     * Input: list1 = [], list2 = []
     * Output: []
     */
    @Test
    void test_01(){
        ListNode l1 = new ListNode();
        ListNode l2 = new ListNode();

        //Then
        ListNode response = solution.mergeTwoLists(l1, l2);
        //ListNode response = solution.mergeTwoListsIterative(l1a, l2a);

        //equal
        assertArrayEquals(new int[]{}, new LinkedListValues().getArrayIterative(response));
    }


    /**
     * Input: list1 = [], list2 = [0]
     * Output: [0]
     */
    @Test
    void test_02(){
        ListNode l1 = new ListNode();
        ListNode l2 = new ListNode(0, null);

        //Then
        ListNode response = solution.mergeTwoLists(l1, l2);
        //ListNode response = solution.mergeTwoListsIterative(l1a, l2a);

        //equal
        assertArrayEquals(new int[]{0}, new LinkedListValues().getArrayIterative(response));
    }
}