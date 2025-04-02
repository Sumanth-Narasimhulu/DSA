class Solution {
    public int minOperations(int[] nums, int k) {
        Set<Integer>set = new HashSet<>();
        for(int ele:nums){
            if(ele<k)return -1;
            else if(ele>k) set.add(ele);
        }
        return set.size();
        
    }
}