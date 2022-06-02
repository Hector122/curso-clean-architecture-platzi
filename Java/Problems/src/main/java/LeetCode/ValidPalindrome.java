package LeetCode;

//https://leetcode.com/problems/valid-palindrome/
public class ValidPalindrome {

    // solution #1
    public boolean isPalindrome(String str) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetterOrDigit(str.charAt(i))) {
                stringBuilder.append(str.charAt(i));
            }
        }

        //remove space and upper case
        stringBuilder = new StringBuilder(stringBuilder.toString()
                .replace(" ", "")
                .toLowerCase());

        String value = stringBuilder.toString();
        return value.equals(stringBuilder.reverse().toString());
    }

    // solution #2 two pointers
    public boolean isPalindromeSolution2(String s) {
        if(s.equals(" ")) return true;

        String regex = "[^A-Za-z0-9]+";
        s = s.toLowerCase().replaceAll(regex, "");

        for(int i = 0, j = s.length() -1; i != j; i++, j-- ){
            if(s.charAt(i) != s.charAt(j)) return false;
        }

        return true;
    }
}
