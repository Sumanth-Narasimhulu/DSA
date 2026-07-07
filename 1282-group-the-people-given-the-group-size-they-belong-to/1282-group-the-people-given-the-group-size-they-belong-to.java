class Solution {
    public List<List<Integer>> groupThePeople(int[] nums) {
        int n = nums.length;
        List<List<Integer>>res = new ArrayList<>();
        HashMap<Integer,List<Integer>>map = new HashMap<>();
        for(int i=0;i<n;i++){
            int key = nums[i];
            List<Integer> ds = map.getOrDefault(key,new ArrayList<>());
            ds.add(i);
            if(key == ds.size()){
                res.add(ds);
                map.remove(key);
            }else{
                // ds.add(i);
                map.put(key,ds);
            }

        }
        
        return res;
    }
}