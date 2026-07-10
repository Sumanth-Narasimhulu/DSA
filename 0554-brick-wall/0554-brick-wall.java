class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer,Integer>map = new HashMap<>();
        int n = wall.size();

        //int oneSize = 0;
       // boolean flag = false;
        for(List<Integer>ds:wall){
            if(ds.size()==1){
                continue;
            }
            int sum = ds.get(0);
            map.put(sum,map.getOrDefault(sum,0)+1);
            for(int i=1;i<ds.size()-1;i++){
                sum+=ds.get(i);
                map.put(sum,map.getOrDefault(sum,0)+1);
            }
        }
        int max = 0;
        for(Map.Entry<Integer,Integer>m:map.entrySet()){
            max = Math.max(max,m.getValue());
        }
        // if(flag){
        //     return map.get(oneSize);
        // }
        return n - max;
    }
}