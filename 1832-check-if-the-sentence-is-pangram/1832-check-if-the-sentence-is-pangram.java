class Solution {
    public boolean checkIfPangram(String s) {
        char[]map = new char[26];
        char[]nums = s.toCharArray();
        for(int i=0;i<nums.length;i++){
            map[nums[i]-'a']++;
        }

        for(int i=0;i<26;i++){
            if(map[i]<=0)return false;
        }
        return true;
    }
}