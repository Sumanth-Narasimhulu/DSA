class Solution {
    public int f(int target,int nums[]){
        int low = 0;
        int high = nums.length-1;
        int res=-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]<=target){
                res = mid;
                low = mid+1;
            }else high = mid-1;
        }
        return res;
    }
    public int[] answerQueries(int[] nums, int[] queries) {
        
        int n = nums.length;
        int[]pref = new int[n];
        Arrays.sort(nums);
        pref[0]=nums[0];
        for(int i=1;i<n;i++){
            pref[i]=pref[i-1]+nums[i];
        }

        int[]res = new int[queries.length];
        int i=0;
        for(int ele:queries){
            res[i++]=f(ele,pref)+1;
        }
        return res;

    }
}