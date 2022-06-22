package LeetCode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TopKFrequentElementsTest {

    @Test
    void topKFrequent_1_2() {
        int [] nums = {1,1,1,2,2,3};
        int k = 2;
        int [] result = {1,2};

        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
        assertArrayEquals(result, topKFrequentElements.topKFrequent(nums, k));
    }

    @Test
    void topKFrequent_1() {
        int [] nums = {1};
        int k = 1;
        int [] result = {1};

        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
        assertArrayEquals(result, topKFrequentElements.topKFrequent(nums, k));
    }

    @Test
    void topKFrequent_minus_1_and_2() {
        int [] nums = {4,1,-1,2,-1,2,3};
        int k = 2;
        int [] result = {-1,2};

        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
        assertArrayEquals(result, topKFrequentElements.topKFrequent(nums, k));
    }
}