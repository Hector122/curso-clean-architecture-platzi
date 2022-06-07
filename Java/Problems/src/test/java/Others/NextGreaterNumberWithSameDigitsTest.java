package Others;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;


class NextGreaterNumberWithSameDigitsTest {
    NextGreaterNumberWithSameDigits nextGreaterNumberWithSameDigits;

    @BeforeEach
     void setUp() {
        nextGreaterNumberWithSameDigits = new NextGreaterNumberWithSameDigits();
    }

    @Test
    @DisplayName("Input = 218765 / Output:251678")
    void solution_input_218765_output_251678() {
        int given = 218765;

        int result = nextGreaterNumberWithSameDigits.solution(given);

      assertEquals(251678, result);
    }


    @Test
    @DisplayName("Input = 1234 / Output:1243")
    void solution_input_1234_output_1243() {
        int given = 1234;

        int result = nextGreaterNumberWithSameDigits.solution(given);

        assertEquals(result,1243);
    }
    @Test
    @DisplayName("Input=4321 / Output:Not Possible")
    void solution_input_4321_output_noPossible() {
        int given = 4321;

        int result = nextGreaterNumberWithSameDigits.solution(given);

        assertEquals(result,-1);
    }
    @Test
    @DisplayName("Input:534976 / Output:536479")
    void solution_input_534976_output_536479() {
        int given = 534976;

        int result = nextGreaterNumberWithSameDigits.solution(given);

        assertEquals(536479, result );
    }
}