class Solution {
    public int f(int i,int j,int[]nums,Integer[][]dp){
        // if(i>=nums.length || j<0) return 0;
        if(i>j) return 0;
        if(i==j) return nums[i];
        if(dp[i][j]!=null) return dp[i][j];
        int takeI = nums[i]+Math.min(f(i+2,j,nums,dp),f(i+1,j-1,nums,dp));
        int takeJ = nums[j]+Math.min(f(i,j-2,nums,dp),f(i+1,j-1,nums,dp));
        return dp[i][j]=Math.max(takeI,takeJ);
    }
    public boolean predictTheWinner(int[] nums) {
        int sum =0;
        Integer[][]dp = new Integer[nums.length+1][nums.length+1];
        for(int ele:nums){
            sum+=ele;
        }
        int p1Score = f(0,nums.length-1,nums,dp);
        int p2Score = sum-p1Score;
        if(p1Score>=p2Score) return true;
        return false;
        
    }
}