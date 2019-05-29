package leetcode.easy.array_all;
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
public class BestTimeSellStockII {

    public static int maxProfit(int[] prices) {
        int profit=0;
        for (int i = 1; i <prices.length ; i++) {
            profit+=Math.max(0,prices[i]-prices[i-1]) ;
        }
       return profit;
    }

    public static int maxProfit2(int[] prices) {
        if(prices.length==0){return 0;}
        int prev=prices[0];//保留上一次的变量
        int profit=0;
        for(int price : prices){
           int diff=price-prev;

            if(diff>0){
                profit+=diff;
            }
            prev=price;

        }
        return profit;
    }



    public static void main(String[] args) {
        int []arr={7,1,5,3,6,4};
        System.out.println(maxProfit(arr));
    }

}
