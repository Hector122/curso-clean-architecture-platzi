package LeetCode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;


class LongestSubstringTest {
    LongestSubstring longestSubstring;

    @BeforeEach
    void setUp() {
        longestSubstring = new LongestSubstring();
    }

    @Test
    void given_abcabcbb_expect_3() {
        //Given
        String given = "abcabcbb";

        // then
        //Explanation: The answer is "b", with the length of 1.
        int actual = longestSubstring.lengthOfLongestSubstring(given);
        assertEquals(3, actual);
    }

    @Test
    void given_bbbbb_expect_1() {
        //Given
        String given = "bbbbb";

        // then
        //Explanation: The answer is "abc", with the length of 3.
        int actual = longestSubstring.lengthOfLongestSubstring(given);
        assertEquals(1, actual);
    }
    @Test
    void given_pwwkew_expect_3() {
        //Given
        String given = "pwwkew";

        // then
        //Explanation: The answer is "wke", with the length of 3.
        //Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
        int actual = longestSubstring.lengthOfLongestSubstring(given);
        assertEquals(3, actual);
    }
}