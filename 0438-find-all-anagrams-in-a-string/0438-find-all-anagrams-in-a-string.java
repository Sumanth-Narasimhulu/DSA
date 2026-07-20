class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        HashMap<Character,Integer>map = new HashMap<>();
        char[]pc = p.toCharArray();
        for(int i=0;i<pc.length;i++){
            map.put(pc[i],map.getOrDefault(pc[i],0)+1);
        }
        int n = p.length();
        List<Integer>res = new ArrayList<>();   

        int i=0;
        char[]nums = s.toCharArray();
        for(int j=0;j<s.length();j++){
            char c = nums[j];
            if(map.containsKey(c)){
              int freq = map.get(c);
              map.put(c,freq-1);
            }
            if(j-i+1<p.length()){
                
                continue;
            }
            if(j-i+1 == p.length()){
                boolean flag = checkEmpty(map);
                if(flag){
                    res.add(i);
                }
                char c1 = nums[i];
                if(map.containsKey(c1)){
                    int freq = map.get(c1);
                    map.put(c1,freq+1);
                }
                i++;
            }
        }
        return res;

    }
    public boolean checkEmpty(HashMap<Character,Integer>map){
        for(int ele:map.values()){
            if(ele!=0)return false;
        }
        return true;
    }
}