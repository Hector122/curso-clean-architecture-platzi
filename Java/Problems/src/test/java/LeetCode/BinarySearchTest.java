package LeetCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    BinarySearch binarySearch;

    @BeforeEach
    void setUp(){
        binarySearch = new BinarySearch();
    }

    @Test
    @DisplayName("nums = [-1,0,3,5,9,12], target = 9")
    void test_target_9(){
        int [] nums = {-1,0,3,5,9,12};
        int target = 9;

        assertEquals(4, binarySearch.search(nums, target));
    }

    @Test
    @DisplayName("nums = [-1,0,3,5,9,12], target = 2")
    void target_2(){
        int [] nums = {-1,0,3,5,9,12};
        int target = 2;

        assertEquals(-1, binarySearch.search(nums, target));
    }
}