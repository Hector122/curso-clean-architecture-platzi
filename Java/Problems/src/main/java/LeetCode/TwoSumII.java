package LeetCode;

//https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
//Two Sum II - Input Array Is Sorted
public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        int[] result = new int[2];

        // since num is already sorted
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                //result[0] = left + 1;
                //result[1] = right + 1;
                return new int[]{left + 1, right + 1};
            } else if (sum > target) {
                right -= 1;
            } else {
                left += 1;
            }
        }
        return result;
    }
}
