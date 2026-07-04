class Solution {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        TreeMap<Integer,Set<String>>map = new TreeMap<>();
        for( int i=0;i<favoriteCompanies.size();i++){
            Set<String>set = new HashSet<>();
            set.addAll(favoriteCompanies.get(i));
            map.put(i,set);
        }
        List<Integer>res = new ArrayList<>();


        for(Map.Entry<Integer,Set<String>>m:map.entrySet()){
            int ind = m.getKey();
            Set<String>set = m.getValue();
            boolean flag = true;
            for(Map.Entry<Integer,Set<String>>n:map.entrySet()){
                int ind2 = n.getKey();
                Set<String>s2 = n.getValue();
                if(ind2!=ind && s2.containsAll(set)){
                    flag = false;
                    break;
                    

                }
            }
            if(flag)res.add(ind);
        }
        return res;
        
    }
}