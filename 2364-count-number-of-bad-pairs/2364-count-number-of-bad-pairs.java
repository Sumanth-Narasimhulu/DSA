class Solution {
    public long countBadPairs(int[] nums) {
        
        HashMap<Integer,Integer>map = new HashMap<>();
        long cnt=0;
        int n  = nums.length;
        long total = ((long)n*((long)n-1))/2;

        for(int i=0;i<n;i++){
            int needed = i-nums[i];
            if(map.containsKey(needed)){
                cnt+=map.get(needed);
                
            }
                map.put(needed,map.getOrDefault(needed,0)+1);
            
        }
        return total - cnt;
    }
}