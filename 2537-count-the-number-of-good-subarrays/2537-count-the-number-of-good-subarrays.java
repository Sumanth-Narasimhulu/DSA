class Solution {
    public long countGood(int[] nums, int k) {
        
        long cnt=0;
        int i=0;
        HashMap<Integer,Integer>map = new HashMap<>();
        int n = nums.length;
        int pairs=0;
        for(int j=0;j<n;j++){
            int c = nums[j];
            pairs+=map.getOrDefault(nums[j],0);
            map.put(c,map.getOrDefault(nums[j],0)+1);
            while(pairs>=k && i<j){
                cnt+=(n-j);
                int freq = map.get(nums[i]);
                if(freq==1)map.remove(nums[i]);
                else map.put(nums[i],freq-1);
                if(map.containsKey(nums[i]))pairs-=freq-1;
                i++;
            }
        }
        return cnt;
    }
}