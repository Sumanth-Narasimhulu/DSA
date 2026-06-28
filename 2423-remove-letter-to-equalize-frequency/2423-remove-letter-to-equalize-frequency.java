class Solution {
    public boolean equalFrequency(String word) {
        int[]freq = new int[26];
        char[]nums = word.toCharArray();
        for(int i=0;i<nums.length;i++){
            freq[nums[i]-'a']++;
        }
        for(int i=0;i<nums.length;i++){
            freq[nums[i]-'a']--;
            if(ok(freq)){
                return true;
            }
            freq[nums[i]-'a']++;
        }
        return false;
    }
    public boolean ok(int[] freq) {

    Integer prev = null;

    for(int i = 0; i < 26; i++) {

        if(freq[i] == 0) continue;

        if(prev == null) {
            prev = freq[i];
        } else if(prev != freq[i]) {
            return false;
        }
    }

    return true;
}
}