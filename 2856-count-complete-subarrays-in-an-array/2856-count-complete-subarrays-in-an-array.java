class Solution {
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer>set = new HashSet<>();
        for(int ele:nums)set.add(ele);
        var n = set.size();
        return f(nums,n)-f(nums,n-1);
        
    }
    public int f(int[]nums,int k){
        HashMap<Integer,Integer>map = new HashMap<>();
        var cnt=0;
        var j=0;
        for(var i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            while(map.size()>k && j<=i){
                var freq = map.get(nums[j]);
                if(freq==1)map.remove(nums[j]);
                else map.put(nums[j],freq-1);
                j++;
            }
            cnt+=i-j+1;

        }
        return cnt;
    }
}