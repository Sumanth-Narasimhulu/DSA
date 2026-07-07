class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int n = logs.length;
        HashMap<Integer,Set<Integer>>map = new HashMap<>();
        for(int[]log:logs){
            int id = log[0];
            int time = log[1];
            if(map.containsKey(id)){
                Set<Integer>set = map.get(id);
                set.add(time);
                map.put(id,set);
            }else{
                Set<Integer>set = new HashSet<>();
                set.add(time);
                map.put(id,set);
            }
        }
        HashMap<Integer,Integer>source = new HashMap<>();
        for(Map.Entry<Integer,Set<Integer>>m:map.entrySet()){
            int size = m.getValue().size();
            source.put(size,source.getOrDefault(size,0)+1);
        }

        int[]res = new int[k];
        for(int i=1;i<=k;i++){
            if(source.containsKey(i)){
                int freq = source.get(i);
                res[i-1]=freq;
            }
        }
        return res;

    }
}