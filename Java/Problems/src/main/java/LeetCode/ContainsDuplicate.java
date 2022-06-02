package LeetCode;

import java.util.HashMap;

//https://leetcode.com/problems/contains-duplicate/
public class ContainsDuplicate {
    public Boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            if (map.containsKey(value)) {
                return true;
            }
            map.put(value, i);
        }

        //don't found duplicates.
        return false;
    }
}
