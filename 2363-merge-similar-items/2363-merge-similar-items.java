class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        TreeMap<Integer,Integer>map = new TreeMap<>();
        for(int[]ele:items1){
            map.put(ele[0],ele[1]);
        }

        for(int[]ele:items2){
            int key = ele[0];
            int val = ele[1];
            if(map.containsKey(key)){
                int v = map.get(key);
                map.put(key,v+val);
            }else{
                map.put(key,val);
            }
        }
        List<List<Integer>>res = new ArrayList<>();

        for(Map.Entry<Integer,Integer>m:map.entrySet()){
            List<Integer>ds = new ArrayList<>();
            ds.add(m.getKey());
            ds.add(m.getValue());
            res.add(ds);
        }
        return res;
    }
}