class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int i = 0, j = 0;
        int n = str1.length(), m = str2.length();
        
        
        while(i < n && j < m){
            char orig = str1.charAt(i);
            char shifted = (char) ('a' + (orig - 'a' + 1) % 26);
           
            if(orig == str2.charAt(j) || shifted == str2.charAt(j)){
                j++;
            }
            i++;
        }
        return j == m;
    }
}
