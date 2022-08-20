package LeetCode;

import java.util.HashSet;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int result = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {

            char a = s.charAt(right);
            char b = s.charAt(left);

            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));//remove the char from the set
                left++; //move the pointer to the right
            }

            set.add(s.charAt(right));
            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}
