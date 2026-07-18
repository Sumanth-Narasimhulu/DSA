class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        
        int cnt=0;
        int sum=0;
        HashMap<Integer,Integer>map = new HashMap<>();
        map.put(sum,1);
        for(int ele:nums){
            sum+=ele;
            int rem = (sum%k + k)%k;
            if(map.containsKey(rem)){
                cnt+=map.get(rem);
            }
            map.put(rem,map.getOrDefault(rem,0)+1);

        }
        return cnt;
    }
}