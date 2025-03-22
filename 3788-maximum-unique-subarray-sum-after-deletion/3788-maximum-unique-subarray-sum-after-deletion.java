class Solution {
    public int maxSum(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int ele:nums)max = Math.max(max,ele);
        if(max<0)return max;
        Set<Integer>set = new HashSet<>();
        var sum=0;
        for(int ele:nums)
        {
            if(!set.contains(ele)&& ele>0){
            sum+=ele;
            set.add(ele);
            }
        }
        return sum;
        
    }
}