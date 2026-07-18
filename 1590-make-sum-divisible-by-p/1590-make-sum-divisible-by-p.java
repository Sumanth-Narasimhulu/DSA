class Solution {
    public int minSubarray(int[] nums, int p) {
        long sum=0;
        for(int ele:nums){
            sum+=(long)ele;
        }
        long target = sum%p;
        if(target == 0) return 0;

        HashMap<Long,Integer>map = new HashMap<>();
        long cs = 0L;
        map.put(cs,-1);
        int n = nums.length;
        int ans = n;
        for(int j=0;j<n;j++){
            cs+=nums[j];
            long needed = (cs-target + p)%p;
            if(map.containsKey(needed)){
                int i = map.get(needed);
                
                if(j-i<ans){
                    ans = j-i;
                    map.put(needed,j);
                }
            }
            map.put((cs%p+p)%p,j);
            
        }
        return ans==n?-1:ans;
    }
}