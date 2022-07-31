package LeetCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ContainerWithMostWaterTest {

    /**
     * Input: height = [1,8,6,2,5,4,8,3,7]
     * Output: 49
     * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
     * In this case, the max area of water (blue section) the container can contain is 49.
     */
    @Test
    @DisplayName("Input: height = [1,8,6,2,5,4,8,3,7]")
    void test_00(){
        //given
        int [] height = new int[]{1,8,6,2,5,4,8,3,7};
        //then
        int result = new ContainerWithMostWater().maxArea(height);

        assertEquals(49, result);
    }

}