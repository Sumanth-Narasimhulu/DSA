class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String>res = new ArrayList<>();
        int[]w2Freq = new int[26];
        for(String word:words2){
            int[]temp = new int[26];
            for(int i=0;i<word.length();i++){
                char c = word.charAt(i);
                temp[c-'a']++;
                w2Freq[c-'a'] = Math.max(w2Freq[c-'a'],temp[c-'a']);
            }
        }

        for(String word:words1){
            int[]w1Freq = new int[26];
            for(int i=0;i<word.length();i++){
                char c = word.charAt(i);
                w1Freq[c-'a']++;
            }
                if(isSubset(w2Freq,w1Freq))res.add(word);
        }
        return res;
        
    }
    boolean isSubset(int[]w2freq,int[]w1Freq){
        for(int i=0;i<26;i++){
            if(w1Freq[i]<w2freq[i])return false;
        }
        return true;
    }
}