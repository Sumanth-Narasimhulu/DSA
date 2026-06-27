class Solution {
    public int countCharacters(String[] words, String chars) {
        
        HashMap<Character,Integer>charsFreq = new HashMap<>();
        for(int i=0;i<chars.length();i++){
            charsFreq.put(chars.charAt(i),charsFreq.getOrDefault(chars.charAt(i),0)+1);
        }
        int sum=0;
        for(String s:words){
            HashMap<Character,Integer>sFreq = new HashMap<>();
            for(int i=0;i<s.length();i++){
                sFreq.put(s.charAt(i),sFreq.getOrDefault(s.charAt(i),0)+1);
            }
            if(avunu(charsFreq,sFreq)){
                sum+=s.length();
            }
        }
        return sum;
    }
    public boolean avunu(HashMap<Character,Integer>charsFreq,HashMap<Character,Integer>sFreq){
        for(Map.Entry<Character,Integer>m:sFreq.entrySet()){
            char curr = m.getKey();
            if(!charsFreq.containsKey(curr))return false;
            int cfreq = charsFreq.get(curr);
            int currentFreq = m.getValue();
            if(cfreq<currentFreq)return false;
        }
        return true;
    }
}