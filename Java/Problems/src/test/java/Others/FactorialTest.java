package Others;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


class FactorialTest {

    Factorial factorial = new Factorial();

    @Test
    void check_factorial_8_is_40320(){
        int given = 8;

        long resultOne = factorial.FirstFactorialIterative(given);
        long resultTwo = factorial.FirstFactorialRecursive(given);

        assertEquals(40320, resultOne);
        assertEquals(40320, resultTwo);

    }

    @Test
    void check_factorial_5_is_120(){
        int given = 5;

        long resultOne = factorial.FirstFactorialIterative(given);
        long resultTwo = factorial.FirstFactorialRecursive(given);

        assertEquals(120, resultOne);
        assertEquals(120, resultTwo);
    }
}