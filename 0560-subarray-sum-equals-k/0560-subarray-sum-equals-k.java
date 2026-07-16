class Solution {
    public int subarraySum(int[] nums, int k) {
        
        int cnt=0;
        HashMap<Integer,Integer>map = new HashMap<>();
        int sum=0;
        map.put(sum,1);
        for(int ele:nums ){
             sum+=ele;
            int needToRemove = sum-k;
            if(map.containsKey(needToRemove)){
                cnt+=map.get(needToRemove);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return cnt;
    }
}