package leetcode.easy.array_all;

/****
 *卖股票，找到收益最大的价格
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class BestTimeSellStock {
    public int maxProfit(int[] prices) {
        int ans=0;
        if(prices.length==0){
            return  ans;
        }
        int bougt=prices[0];
        for (int i = 1; i <prices.length ; i++) {

            if(prices[i]>bougt){
               ans=Math.max(ans,prices[i]-bougt);
            }else {
                bougt=prices[i];
            }
        }


    return ans;
    }

    public static void main(String[] args) {

    }
}
