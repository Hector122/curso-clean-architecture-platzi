package LeetCode.LinkedList;

import java.util.HashSet;

/**
 * https://leetcode.com/problems/longest-consecutive-sequence/
 */
public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        //put the numbers in a hast set
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int max_sequence = 0;
        // main look
        for (int num : nums) {
            int current_max = 1; //current counter

            if (!set.contains(num - 1)) {  // if there is not any smaller number than continue.
                while (set.contains(num + 1)) {
                    num = num + 1; //4
                    current_max++; //3
                }

                max_sequence = Math.max(max_sequence, current_max);
            }
        }

        return max_sequence;
    }
}
