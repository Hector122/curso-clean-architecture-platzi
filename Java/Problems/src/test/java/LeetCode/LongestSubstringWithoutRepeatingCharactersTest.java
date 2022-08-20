package LeetCode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestSubstringWithoutRepeatingCharactersTest {

    LongestSubstringWithoutRepeatingCharacters solution;

    @BeforeEach
    void setUp() {
        solution = new LongestSubstringWithoutRepeatingCharacters();
    }

    /**
     * Input: s = "abcabcbb"
     * Output: 3
     * Explanation: The answer is "abc", with the length of 3.
     */
    @Test
    @DisplayName("s = abcabcbb, out: 3")
    void test_00(){
        String given = "abcabcbb";
        int actual = solution.lengthOfLongestSubstring(given);
        assertEquals(3, actual);
    }
    /**
     * Input: s = "bbbbb"
     * Output: 1
     * Explanation: The answer is "b", with the length of 1.
     */
    @Test
    @DisplayName("s = bbbbb, out: 1")
    void test_01(){
        String given = "bbbbb";
        int actual = solution.lengthOfLongestSubstring(given);
        assertEquals(1, actual);
    }
    /**
     * Input: s = "pwwkew"
     * Output: 3
     * Explanation: The answer is "wke", with the length of 3.
     * Notice that the answer must be a substring,
     * "pwke" is a subsequence and not a substring.
     */
    @Test
    @DisplayName("s = pwwkew, out: 3")
    void test_03(){
        String given = "pwwkew";
        int actual = solution.lengthOfLongestSubstring(given);
        assertEquals(3, actual);
    }

}