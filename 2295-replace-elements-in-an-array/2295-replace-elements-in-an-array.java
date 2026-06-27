class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);

        }
        for(int[]e:operations){
            if(map.containsKey(e[0])){
                int ind = map.get(e[0]);
                map.remove(e[0]);
                map.put(e[1],ind);
            }
        }
        for(Map.Entry<Integer,Integer>m:map.entrySet()){
            nums[m.getValue()]=m.getKey();
        }
        return nums;
        
    }
}