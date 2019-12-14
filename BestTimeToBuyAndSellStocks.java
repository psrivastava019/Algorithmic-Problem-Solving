/** 
 * Author: Priyanshu Srivastava
 * Source:https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
 */
public class BestTimeToBuyAndSellStocks {
    public int maxProfit(int k, int[] prices) {
        int n= prices.length;
        if(k==0 || n==0){
            return 0;
        }
        if(k >= n/2)    
            return maxProfit(prices);
        int[] prev=new int[n];
        int[] curr=new int[n];
          for(int i = 1; i <= k; i++){
            int maxDiff = -prices[0];
            for(int j = 1; j < n; j++){
                curr[j] = Math.max(curr[j-1], prices[j] + maxDiff);
                maxDiff = Math.max(maxDiff, prev[j] - prices[j]);
            }
            prev = curr;
        }
        return curr[n-1];
    }
    
    public int maxProfit(int[] prices){
        int profit=0;
        for(int i=1;i<prices.length;i++){
            profit += prices[i] > prices[i-1] ? prices[i] - prices[i-1] : 0;
        }
        return profit;
    }
}