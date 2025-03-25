class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        TreeMap<Integer,Integer>set = new TreeMap<>();
        for(int[]nums:nums1){
            set.put(nums[0],nums[1]);
        }
        for(int[]nums:nums2){
            set.put(nums[0],set.getOrDefault(nums[0],0)+nums[1]);
        }
        int[][]res = new int[set.size()][2];
        int ind=0;
        for(Map.Entry<Integer,Integer>m:set.entrySet()){
            res[ind][0]=m.getKey();
            res[ind][1]=m.getValue();
            ind++;
        }
        return res;
        

        
    }
}