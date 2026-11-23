class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long cnt=0;
        int n = nums.length;
        for(int i=0;i<nums.length;i++){
            int x = lower -nums[i];
            int y = upper - nums[i];
            // if( nums[i] > upper)continue;

            int a = firstIndGX(nums,i+1,n,x);
            int b = lastIndLY(nums,i+1,n,y);
            if(a==-1 || b==-1)continue;
            cnt+=(b-a+1);

        }
        return cnt;
    }
    public int firstIndGX(int[]nums,int start,int end,int x){
        int low = start;
        int high = end-1;
        int res=-1;
        while(low<=high){
            int mid = (low+(high-low)/2);
            if(nums[mid]>=x){
                res = mid;
                high = mid-1;
            }else low = mid+1;
        }
        return res;
    }
    public  int lastIndLY(int[]nums,int start,int end,int y){
        int low = start;
        int high = end-1;
        int res= -1;
        while(low<=high){
            int mid = (low+(high-low)/2);
            if(nums[mid]<=y){
                res=mid;
                low = mid+1;
            }else high = mid-1;
        }
        return res;
    }
}