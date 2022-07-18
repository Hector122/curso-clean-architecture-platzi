package LeetCode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchInRotatedSortedArrayTest {

    SearchInRotatedSortedArray solution;

    @BeforeEach
    void setUp(){
        solution = new SearchInRotatedSortedArray();
    }

    /**
     * Input: nums = [4,5,6,7,0,1,2], target = 0
     * Output: 4
     */
    @Test
    void search_t00() {
        int[] nums = {4,5,6,7,0,1,2};
        int expect = 4, target = 0;

        int result = solution.search(nums, target);
        assertEquals(expect, result);
    }

    /**
     * Input: nums = [4,5,6,7,0,1,2], target = 3
     * Output: -1
     */
    @Test
    void search_t02() {
        int[] nums = {4,5,6,7,0,1,2};
        int expect = -1, target = 3;

        int result = solution.search(nums, target);
        assertEquals(expect, result);
    }

    /**
     * Input: nums = [1], target = 0
     * Output: -1
     */
    @Test
    void search_t03() {
        int[] nums = {1};
        int expect = -1, target = 0;

        int result = solution.search(nums, target);
        assertEquals(expect, result);
    }
}