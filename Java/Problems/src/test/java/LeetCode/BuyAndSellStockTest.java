package LeetCode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class BuyAndSellStockTest {

    BuyAndSellStock buyAndSellStock;

    @BeforeEach
    public void setUp(){
         buyAndSellStock = new BuyAndSellStock();
    }

    @Test
    @DisplayName("Given prices = [7,1,5,3,6,4]")
    public void given_715364_print_5(){

        //given
        int[]given = new int[]{7,1,5,3,6,4};
        // then
        int result = buyAndSellStock.bestTimeToBuyAndSellStock(given);
        //check
        assertEquals(5, result);
    }

    @Test
    @DisplayName("Given prices = [7,6,4,3,1]")
    public void given_76431_print_0(){
        //given
        int[]given = new int[]{7,6,4,3,1};
        //then
        int result = buyAndSellStock.bestTimeToBuyAndSellStock(given);
        //check
        assertEquals(0, result);
    }
}