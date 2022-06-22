package LeetCode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidPalindromeTest {
    ValidPalindrome validPalindrome;

    @BeforeEach
    void setUp() {
        validPalindrome = new ValidPalindrome();
    }

    @Test
    @DisplayName("A man, a plan, a canal: Panama")
    void isPalindrome() {
        //given
        String str = "A man, a plan, a canal: Panama";
        //then
        boolean result = validPalindrome.isPalindrome(str);
        boolean resultTwo= validPalindrome.isPalindromeSolution2(str);
        //result
        assertTrue(result);
        assertTrue(resultTwo);
    }

    @Test
    @DisplayName("race a car")
    void isPalindrome_race_a_car() {
        //given
        String str = "race a car";
        //then
        boolean result = validPalindrome.isPalindrome(str);
        boolean result2 = validPalindrome.isPalindromeSolution2(str);
        //result
        assertFalse(result);
        assertFalse(result2);
    }

    @Test
    @DisplayName(" ")
    void isPalindrome_space() {
        //given
        String str = " ";
        //then
        boolean result = validPalindrome.isPalindrome(str);
        boolean result2 = validPalindrome.isPalindromeSolution2(str);
        //result
        assertTrue(result);
        assertTrue(result2);

    }
}