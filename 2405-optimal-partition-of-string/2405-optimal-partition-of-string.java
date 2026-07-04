class Solution {
    public int partitionString(String s) {
        Set<Character>set = new HashSet<>();
        int cnt=0;
        for(int i=0;i<s.length();i++){
            if(set.contains(s.charAt(i))){
                cnt++;
                set.clear();
            }
            set.add(s.charAt(i));
        }
        return cnt+1;
        
    }
}