class Solution {
    public int f(int[]nums,int k){
        int i=0;
        int sum=0;
        int n =nums.length;
        int max = -1;
        for(int j=0;j<n;j++){
            sum+=nums[j];
            while(sum>k && i<=j){
                sum-=nums[i];
                i++;
            }
            if(sum==k){
                max = Math.max(max,j-i+1);
            }
        }
        return max;
    }
    public int minOperations(int[] nums, int x) {
        int n =nums.length;
        int sum=0;
        for(int ele:nums)sum+=ele;
        int l = f(nums,sum-x);
        return l==-1?-1:n-l;
    }
}