package Others;

import java.util.Arrays;

/**
 * Have the function MathChallenge(num) take the num parameter being passed and return the next number greater
 * than num using the same digits. For example: if num is 123 return 132, if it's 12453 return 12534.
 * If a number has no greater permutations, return -1 (ie. 999).
 * <p>
 * Examples
 * Input: 11121
 * Output: 11211
 * Input: 41352
 * Output: 41523
 */
public class NextGreaterNumberWithSameDigits {

    public int solution(int num) {
        char[] nums = convertIntToCharArray(num);
        int length = nums.length;

        int i;
        // start from right
        for(i = length - 1; i > 0; i--){
            if(nums[i] > nums[i-1]){
                break;
            }
        }
        // number has no greater permutations
        if(i == 0) return -1;

        // for the smallest digit greater than i -1
        int x = nums[i-1];
        int minimum = i;

        //Find the smallest digit on right
        //side of (i-1)'th digit that is greater
        //  than number[i-1]
        for(int j = i + 1; j < length; j++){
            if(nums[j] > x && nums[j] < nums[minimum]){
                minimum = j;
            }
        }

        // Swap the above found two digits
        swap(nums, i - 1, minimum);

        // Now sort all digits from position next to ‘i’ to the end of number.
        Arrays.sort(nums, i, length);

        num = Integer.parseInt(String.valueOf(nums));
        return num;
    }


    public char[] convertIntToCharArray(int num) {
        //convert to string
        String srt = Integer.toString(num);
        char[] result = new char[srt.length()];

        for (int i = 0; i < srt.length(); i++) {
            result[i] = srt.charAt(i);
        }
        return  result;
    }

    //swap two digit
    public void swap(char[] chars, int positionA, int positionB){
        char temp = chars[positionA];
        chars[positionA] = chars[positionB];
        chars[positionB] = temp;
    }

}
