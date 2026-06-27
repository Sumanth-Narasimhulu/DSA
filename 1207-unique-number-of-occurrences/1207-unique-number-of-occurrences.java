class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int ele:arr)map.put(ele,map.getOrDefault(ele,0)+1);
        Set<Integer>set = new HashSet<>();
        for(int e:map.values()){
            set.add(e);
        }
        return set.size()==map.size();
    }
}