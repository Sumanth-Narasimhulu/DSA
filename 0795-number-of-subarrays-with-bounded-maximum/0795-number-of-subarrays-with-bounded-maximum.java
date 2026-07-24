class Solution {
    public int cntOfSubAMaxLER(int[]nums,int k){
        int i=0;
        int n = nums.length;
        int cnt=0;
        for(int j=0;j<n;j++){
            if(nums[j]>k)i=j+1;
            cnt+=j-i+1;
        }
        return cnt;
    }
    
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        return cntOfSubAMaxLER(nums,right) - cntOfSubAMaxLER(nums,left-1);
    }
}