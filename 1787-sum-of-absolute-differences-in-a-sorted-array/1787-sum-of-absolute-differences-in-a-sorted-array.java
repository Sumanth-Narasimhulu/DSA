class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[]prefix = new int[n];
        prefix[0]=nums[0];
        for(int i=1;i<n;i++){
            prefix[i]=prefix[i-1]+nums[i];
        }
        int[]ans = new int[n];
        for(int i=0;i<n;i++){
            var leftSum = prefix[i]-nums[i];
            int rightSum = prefix[n-1]-prefix[i];
            
            var noOfRight = n-i-1;
            int lTotal =Math.abs( leftSum-(i*nums[i]));
            var rTotal = Math.abs(rightSum-(noOfRight*nums[i]));
            ans[i]=lTotal+rTotal;

        }
        return ans;

        
    }
}