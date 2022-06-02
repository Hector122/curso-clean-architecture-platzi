package LeetCode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

class ContainsDuplicateTest {

    ContainsDuplicate containsDuplicate;

    @BeforeEach
    void setUp(){
        containsDuplicate = new ContainsDuplicate();
    }

    @Test
    @DisplayName("Input: nums = [1,2,3,1]")
    void number_one_is_duplicate_return_true(){

        //given
        int [] given = new int[]{1,2,3,1};
        //then
        boolean result = containsDuplicate.containsDuplicate(given);

        //check
        assertTrue(result);
    }

    @Test
    @DisplayName("nums = [1,2,3,4]")
    void number_no_duplicate_return_false(){

        //given
        int [] given = new int[]{1,2,3,4};
        //then
        boolean result = containsDuplicate.containsDuplicate(given);

        //check
        assertFalse(result);
    }

    @Test
    @DisplayName("Input: nums = [1,1,1,3,3,4,3,2,4,2]")
    void number_has_duplicate_return_true(){

        //given
        int [] given = new int[]{1,1,1,3,3,4,3,2,4,2};
        //then
        boolean result = containsDuplicate.containsDuplicate(given);

        //check
        assertTrue(result);
    }

}