class Solution {
    public int minOperations(int[][] grid, int x) {
        List<Integer>nums = new ArrayList<>();
        for(int[]ele:grid){
            for(int e:ele){
                nums.add(e);
            }
        }
        Collections.sort(nums);
        int mid = nums.get(nums.size()/2);
        int ans=0;
        for(int e:nums){
            int diff = Math.abs(e-mid);
            if(diff%x!=0)return -1;
            ans+=(diff/x);
        }
        return ans;
    }
}