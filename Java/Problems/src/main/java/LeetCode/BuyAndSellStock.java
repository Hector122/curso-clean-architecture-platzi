package LeetCode;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class BuyAndSellStock {

    public int bestTimeToBuyAndSellStock(int[] input_arr) {
        // your code goes here
        int sell = 0, buy = Integer.MAX_VALUE;

        for(int price: input_arr){
            if(price < buy){
                buy = price;
            } else {
                sell = Math.max(sell, price - buy);
            }
        }
        return sell;
    }
}
