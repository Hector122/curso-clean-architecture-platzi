package LeetCode;

import javax.swing.plaf.IconUIResource;

//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/solution/
public class FindMinimumRotatedSortedArray {
    public int findMin(int[] nums) {
        int result = nums[0];
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            // if sorted, Hence the smallest element is first element.
            if (nums[left] < nums[right]) {
               return nums[left];
            }
            //4,5,6,7,0,1,2
            //      |
            int mid = (left + right) / 2;
            result = Math.min(result, nums[mid]);

            if (nums[left] <= nums[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return result;
    }
}
