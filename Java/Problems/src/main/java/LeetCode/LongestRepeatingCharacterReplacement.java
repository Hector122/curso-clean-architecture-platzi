package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int result = 0;
        int r = 0, l = 0;

        while (r < s.length() && l < s.length()) {
            if (hashMap.containsKey(s.charAt(r))) {
                hashMap.merge(s.charAt(r), 1, Integer::sum);
            }


            result = Math.max(result, r - l + 1);
        }


        return result;
    }
}
