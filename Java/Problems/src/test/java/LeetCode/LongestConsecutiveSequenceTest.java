package LeetCode;

import LeetCode.LinkedList.LongestConsecutiveSequence;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestConsecutiveSequenceTest {

    /**
     * Input: nums = [100,4,200,1,3,2]
     * Output: 4
     * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
     */
    @Test
    void longestConsecutive_t00() {
        int[] nums = {100, 4, 200, 1, 3, 2};
        int expected = 4;

        int actual = new LongestConsecutiveSequence().longestConsecutive(nums);
        assertEquals(expected, actual);
    }

    /**
     * Input: nums = [0,3,7,2,5,8,4,6,0,1]
     * Output: 9
     */
    @Test
    void longestConsecutive_t01() {
        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        int expected = 9;

        int actual = new LongestConsecutiveSequence().longestConsecutive(nums);
        assertEquals(expected, actual);
    }
}