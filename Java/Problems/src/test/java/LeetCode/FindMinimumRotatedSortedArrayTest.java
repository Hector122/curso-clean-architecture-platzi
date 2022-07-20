package LeetCode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindMinimumRotatedSortedArrayTest {

    FindMinimumRotatedSortedArray findMinimum ;

    @BeforeEach
    void setUp(){
        findMinimum = new FindMinimumRotatedSortedArray();
    }

    /**
     * Input: nums = [3,4,5,1,2]
     * Output: 1
     * Explanation: The original array was [1,2,3,4,5] rotated 3 times.
     */
    @Test
    @DisplayName("nums = [3,4,5,1,2], output: 1")
    void test_00(){
        int [] nums = {3,4,5,1,2};
        int expected = 1;

        assertEquals(expected, findMinimum.findMin(nums));
    }

    /**
     * Input: nums = [4,5,6,7,0,1,2]
     * Output: 0
     * Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.
     */
    @Test
    @DisplayName("nums = [4,5,6,7,0,1,2], output: 0")
    void test_02(){
        int [] nums = {4,5,6,7,0,1,2};
        int expected = 0;

        assertEquals(expected, findMinimum.findMin(nums));
    }

    /**
     * Input: nums = [11,13,15,17]
     * Output: 11
     * Explanation: The original array was [11,13,15,17] and it was rotated 4 times.
     */
    @Test
    @DisplayName("nums = [3,4,5,1,2], output: 1")
    void test_03(){
        int [] nums = {11,13,15,17};
        int expected = 11;

        assertEquals(expected, findMinimum.findMin(nums));
    }

    /**
     * Input: nums = [2,1]
     * Output: 1
     * Explanation: The original array was [1,2] and it was rotated 1 time.
     */
    @Test
    @DisplayName("nums = [2,1], output: 1")
    void test_04(){
        int [] nums = {2,1};
        int expected = 1;

        assertEquals(expected, findMinimum.findMin(nums));
    }
}