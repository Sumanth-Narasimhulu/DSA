class Solution {
    public int maximumDifference(int[] prices) {
        int maxProfit = -1;
        int min = prices[0];
        
        for(int i=1;i<prices.length;i++){
            
            int profit = prices[i]-min;
            if(min<prices[i])
            maxProfit = Math.max(maxProfit,profit);
            min = Math.min(min,prices[i]);
            

        }
        return maxProfit;
    }
}