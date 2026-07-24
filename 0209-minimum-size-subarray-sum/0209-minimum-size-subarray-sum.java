class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int i=0;
        int sum=0;
        int min =Integer.MAX_VALUE;
        for(int j=0;j<nums.length;j++){
            sum+=nums[j];
            if(sum<target){
                continue;
            }
            while(sum>=target && i<=j){
                min = Math.min(min,j-i+1);
                sum-=nums[i];
                i++;
            }
        }
        return min==Integer.MAX_VALUE?0:min;
    }
}