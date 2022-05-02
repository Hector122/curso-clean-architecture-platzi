package LeetCode;

import java.util.HashMap;

//https://leetcode.com/problems/two-sum/
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int [2];
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for(int i=0; i< nums.length; i++){
            int difference = target - nums[i];
            if(hashMap.containsKey(difference)){
                result[0] = i;
                result[1] = hashMap.get(difference);
                return result;
            }

            hashMap.put(nums[i], i);
        }

        return result;
    }
}
