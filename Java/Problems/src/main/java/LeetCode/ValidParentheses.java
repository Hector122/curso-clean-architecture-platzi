package LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//https://leetcode.com/problems/valid-parentheses/
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> mapClose = new HashMap<>();
        mapClose.put(')', '(');
        mapClose.put('}', '{');
        mapClose.put(']', '[');

        // loop through the string
        for (char c : s.toCharArray()) {
            // it's a closed key
            if (mapClose.containsKey(c)) {
                //validate is the last element of the stack is open element.
                if (!stack.isEmpty() && stack.peek() == mapClose.get(c)) {
                    //remove from stack
                    stack.pop();
                } else return false;

            } else {
                stack.push(c);
            }
        }
        // is empty true is valid string.
        return stack.isEmpty();
    }
}
