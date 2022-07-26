package LeetCode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TwoSumIITest {

    TwoSumII solution;

    @BeforeEach
    void setUp() {
        solution = new TwoSumII();
    }

    /**
     * Input: numbers = [2,7,11,15], target = 9
     * Output: [1,2]
     * Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
     */
    @Test
    @DisplayName("Two Sum")
    void test_00() {
        // given
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        //then
        int[] result = solution.twoSum(nums, target);
        int[] expected = new int[]{1, 2};
        //result
        assertArrayEquals(expected, result);
    }

    /**
     * Input: numbers = [2,3,4], target = 6
     * Output: [1,3]
     * Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].
     */
    @Test
    @DisplayName("Two Sum")
    void test_01() {
        // given
        int[] nums = new int[]{2, 3, 4};
        int target = 6;
        //then
        int[] result = solution.twoSum(nums, target);
        int[] expected = new int[]{1, 3};
        //result
        assertArrayEquals(expected, result);
    }

    /**
     * Input: numbers = [-1,0], target = -1
     * Output: [1,2]
     * Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].
     */
    @Test
    @DisplayName("Two Sum")
    void test_02() {
        // given
        int[] nums = new int[]{-1,0};
        int target = -1;
        //then
        int[] result = solution.twoSum(nums, target);
        int[] expected = new int[]{1, 2};
        //result
        assertArrayEquals(expected, result);
    }
}