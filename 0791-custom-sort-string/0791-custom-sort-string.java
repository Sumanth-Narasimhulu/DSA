class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character,Integer>map = new HashMap<>();
        char[]nums  = s.toCharArray();
        for(char c:nums){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<order.length();i++){
            char curr = order.charAt(i);
            if(map.containsKey(curr)){
                int freq = map.get(curr);
                for(int j=0;j<freq;j++){
                    sb.append(curr);
                }
                map.remove(curr);
            }
        }
        for(Map.Entry<Character,Integer>m:map.entrySet()){
            int freq = m.getValue();
            for(int i=0;i<freq;i++){
                sb.append(m.getKey());
            }
        }
        return sb.toString();
    }
}