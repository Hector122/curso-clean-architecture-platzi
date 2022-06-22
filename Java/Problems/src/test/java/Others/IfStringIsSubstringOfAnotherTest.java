package Others;

import org.hamcrest.core.Is;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IfStringIsSubstringOfAnotherTest {

    private IfStringIsSubstringOfAnother sisoa;

    @BeforeEach
    void setUp(){
        sisoa = new IfStringIsSubstringOfAnother();
    }

    @Test
    void if_Hi_isIn_HiHelloWorld(){
        boolean value = sisoa.isSubstring("Hi", "Hi hello world");
        assertTrue(value);
    }
    @Test
    void if_for_isIn_geeksForGeeks(){
        boolean value = sisoa.isSubstring("for", "geeks for geeks");
        assertTrue(value);
    }
    @Test
    void if_say_isIn_HiHelloWorld(){
        boolean value = sisoa.isSubstring("say", "Hi hello world");
        assertFalse(value);
    }
}