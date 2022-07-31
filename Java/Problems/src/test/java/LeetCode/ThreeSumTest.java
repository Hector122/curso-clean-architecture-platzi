package LeetCode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

class ThreeSumTest {
    ThreeSum solution;

    @BeforeEach
    void setUp() {
        solution = new ThreeSum();
    }


    /**
     * Input: nums = [-1,0,1,2,-1,-4]
     * Output: [[-1,-1,2],[-1,0,1]]
     * Explanation:
     * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
     * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
     * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
     * The distinct triplets are [-1,0,1] and [-1,-1,2].
     * Notice that the order of the output and the order of the triplets does not matter.
     */
    @Test
    @DisplayName("Input: nums = [-1,0,1,2,-1,-4]")
    void solution_00() {
        //given
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        //expect
        List<Integer> l1 = new ArrayList<>();
        l1.add(-1);
        l1.add(-1);
        l1.add(2);

        List<Integer> l2 = new ArrayList<>();
        l2.add(-1);
        l2.add(0);
        l2.add(1);

        List<List<Integer>> output = new LinkedList<>();
        output.add(l1);
        output.add(l2);

        List<List<Integer>> result = solution.threeSum(nums);

        assertEquals(output, result);
    }


    /**
     * Input: nums = [0,1,1]
     * Output: []
     * Explanation: The only possible triplet does not sum up to 0.
     */
    @Test
    @DisplayName("Input: nums = [0,1,1]")
    void solution_02() {
        //given
        int[] nums = new int[]{0,1,1};
        //expect
        List<List<Integer>> output = new LinkedList<>();

        List<List<Integer>> result = solution.threeSum(nums);

        assertEquals(output, result);
    }
    /**
     Input: nums = [0,0,0]
     Output: [[0,0,0]]
     Explanation: The only possible triplet sums up to 0.
     */
    @Test
    @DisplayName("Input: nums = [0,0,0]")
    void solution_03() {
        //given
        int[] nums = new int[]{0,0,0};
        //expect
        List<List<Integer>> output = new LinkedList<>();
        List<Integer> l1 = new ArrayList<>();
        l1.add(0);
        l1.add(0);
        l1.add(0);

        output.add(l1);
        List<List<Integer>> result = solution.threeSum(nums);

        assertEquals(output, result);
    }
}