package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/3sum/
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        LinkedList<List<Integer>> result = new LinkedList<>();

        //sort the array
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            //  if not the first loop and the num are the same value
            if (i > 0 && nums[i] == nums[i - 1]) continue; //continue repeat values

            // Now is a two pointer problem
            // num[i] + num[j] + num[k] = 0
            // num[j] + num[k] = 0 - num[i]
            int target = 0 - nums[i];
            int left = i + 1, right = nums.length - 1;

            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum > target) right--;
                else if (sum < target) left++;
                else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);

                    result.add(list);

                    //skip duplicate
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    //increment to look for more solution.
                    left++;
                    right --;
                }
            }
        }
        return result;
    }

    //brute force O(n^3)
    public List<List<Integer>> threeSumBruteForce(int[] nums) {
        LinkedList<List<Integer>> result = new LinkedList<>();

        //sort the array
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length; j++) {

                if (j > i + 1 && nums[i] == nums[i - 1]) continue;
                for (int k = j + 1; k < nums.length; k++) {

                    if (k > j + 1 && nums[i] == nums[i - 1]) continue;
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);

                        result.add(list);
                    }
                }
            }
        }
        return result;
    }
}
