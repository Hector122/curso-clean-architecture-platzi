package LeetCode;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/
//Longest substring without repeating characters
public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0;
        int max = 0;

        Set<Character> set = new HashSet<>();

        while (j < s.length()){
            if(set.contains(s.charAt(j))){
                set.remove(s.charAt(i));
                i++;
            } else {
                set.add(s.charAt(j));
                j++;
                // find max
                max = Math.max(set.size(), max);
            }
        }
        return max;
    }
}
