class Solution {
    public List<String> removeAnagrams(String[] words) {
        String prev=words[0];
        for(int i=1;i<words.length;i++){
            if(isAnagram(prev,words[i])){
                words[i]="";
            }else{
                prev = words[i];
            }
        }
        List<String>res = new ArrayList<>();
        for(String word:words){
            if(!word.isEmpty())res.add(word);
        }
        return res;
        
    }
    public boolean isAnagram(String s, String t) {
        char[]a = s.toCharArray();
        char[]b = t.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        if(Arrays.equals(a,b))return true;
        return false;
        
    }
}