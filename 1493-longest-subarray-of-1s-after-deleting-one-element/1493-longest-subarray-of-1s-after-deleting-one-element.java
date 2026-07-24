class Solution {
    public int longestSubarray(int[] nums) {
        int z=0;
        int i=0;
        int n = nums.length;
        int max =0;
        for(int j=0;j<n;j++){
            if(nums[j]==0)z++;
            while(z>1 && i<j){
                if(nums[i]==0)z--;
                i++;
            }
            max = Math.max(j-i,max);
        }
        return max;
    }
}