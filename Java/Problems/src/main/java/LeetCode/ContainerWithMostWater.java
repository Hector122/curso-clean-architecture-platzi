package LeetCode;

//https://leetcode.com/problems/container-with-most-water/
public class ContainerWithMostWater {
    //Two pointers
    public int maxArea(int[] height) {
        int result = 0;
        int left = 0, right = height.length - 1;

        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            result = Math.max(area, result);

            if(height[left] < height[right]){
                left++;
            } else {
                right--;
            }
        }
        return result;
    }

    // O(n^2)
    public int maxAreaBruteForce(int[] height) {
        int result = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = (j - i) * Math.min(height[j], height[i]);
                result = Math.max(area, result);
            }
        }
        return result;
    }
}
