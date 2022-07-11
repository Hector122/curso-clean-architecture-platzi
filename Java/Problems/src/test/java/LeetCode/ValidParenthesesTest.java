package LeetCode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidParenthesesTest {
    ValidParentheses validParentheses = new ValidParentheses();

    @BeforeEach
   public void setUp(){
        validParentheses = new ValidParentheses();
    }

    @Test
    public void valid_example_one(){
        String given = "()";
        boolean result = validParentheses.isValid(given);
        Assertions.assertTrue(result);
    }

    @Test
   public void valid_example_two(){
        String given = "()[]{}";
        boolean result = validParentheses.isValid(given);
        Assertions.assertTrue(result);
    }
    @Test
   public void valid_example_three(){
        String given =  "(]";
        boolean result = validParentheses.isValid(given);
        Assertions.assertFalse(result);
    }
}