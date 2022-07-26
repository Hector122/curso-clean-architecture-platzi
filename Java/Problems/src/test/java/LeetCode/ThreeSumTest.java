package LeetCode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

class ThreeSumTest {
    ThreeSum solution;

    @BeforeEach
    void setUp(){
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
    @DisplayName("3 Sum")
    void solution_() {

        //given
        int [] nums = new int []{-1,0,1,2,-1,-4};
        //expect
        int[][] output = new int[][]{{-1,-1,2},{-1,0,1}};

        List<List<Integer>> result = solution.threeSum(nums);
        int[][]k = result.toArray(new int[0][0]);

        Assertions.assertArrayEquals(output, k);
    }

}