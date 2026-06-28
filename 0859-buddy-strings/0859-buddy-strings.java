class Solution {
    public boolean buddyStrings(String s, String goal) {
        if(s.length()!=goal.length())return false;
        char[]nums = s.toCharArray();
        if(s.equals(goal)){
            int[]freq = new int[26];
            for(int i=0;i<s.length();i++){
                freq[nums[i]-'a']++;
                if(freq[nums[i]-'a']>1)return true;
            }
            return false;
        }
        int n = nums.length;
        List<Integer>missingInd = new ArrayList<>();
        char[]nums2 = goal.toCharArray();
        for(int i=0;i<n;i++){
            if(nums[i]!=nums2[i])missingInd.add(i);
        }
        if(missingInd.size()!=2)return false;
        int i = missingInd.get(0);
        int j = missingInd.get(1);

        return (nums[i]==nums2[j] && nums[j] == nums2[i]);


    }
}