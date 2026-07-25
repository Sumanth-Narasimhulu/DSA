class Solution {
    public int minimumCardPickup(int[] nums) {
        
        int min = Integer.MAX_VALUE;
        int n = nums.length;
        int i=0;
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int j=0;j<n;j++){
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            while(map.size()<j-i+1 && i<j){
                min = Math.min(min,j-i+1);
                int freq = map.get(nums[i]);
                if(freq==1)map.remove(nums[i]);
                else map.put(nums[i],freq-1);
                i++;
            }
        }
        return min==Integer.MAX_VALUE?-1:min;
    }
}