package LeetCode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class TwoSumTest {

    TwoSum twoSum;

    @BeforeEach
     void setUp(){
        twoSum = new TwoSum();
    }

    @Test
    @DisplayName("Two Sum")
    void solution_to_problem() {

        int [] nums = new int []{2,7,11,15};
        int target = 9;
        int[] result = twoSum.twoSum(nums, target);
        assertEquals("[1, 0]", Arrays.toString(result));
    }
}