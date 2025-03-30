class Solution {
    public List<Integer> partitionLabels(String s) {
        int[]lastInd = new int[26];
        for(int i=0;i<s.length();i++){
            lastInd[s.charAt(i)-'a']=i;
        }
        int i=0;
        int n = s.length();
        List<Integer>res = new ArrayList<>();
        while(i<n){
            int end = lastInd[s.charAt(i)-'a'];
            int j=i;
            while(j<end){
                end = Math.max(end,lastInd[s.charAt(j)-'a']);
                j++;
            }
            res.add(j-i+1);
            i = j+1;
            
        }
        return res;
        
    }
}