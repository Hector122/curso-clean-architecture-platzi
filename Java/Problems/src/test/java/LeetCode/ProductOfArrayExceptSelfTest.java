package LeetCode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductOfArrayExceptSelfTest {

    @Test
    void first_test() {
        int [] given = {1,2,3,4};
        int [] result = {24,12,8,6};

        ProductOfArrayExceptSelf product = new ProductOfArrayExceptSelf();
        assertArrayEquals(result, product.productExceptSelf(given));
    }

    @Test
    void second_test() {
        int [] given = {-1,1,0,-3,3};
        int [] result = {0,0,9,0,0};

        ProductOfArrayExceptSelf product = new ProductOfArrayExceptSelf();
        assertArrayEquals(result, product.productExceptSelf(given));
    }
}