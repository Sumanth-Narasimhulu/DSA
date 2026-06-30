class Solution {
    public boolean makeEqual(String[] words) {
        HashMap<Character,Integer>map = new HashMap<>();
        if(words.length==1)return true;
        for(String s:words){
            for(int i=0;i<s.length();i++){
                map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
            }
        }

        for(Map.Entry<Character,Integer>m:map.entrySet()){
            if(m.getValue()%words.length!=0)return false;
        }
        return true;
    }
}