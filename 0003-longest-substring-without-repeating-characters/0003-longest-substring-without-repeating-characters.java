class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        HashMap<Character,Integer>map = new HashMap<>();
        int i=0;
        int max=0;
        char[]nums = s.toCharArray();
        for(int j=0;j<s.length();j++){
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            if(j-i+1 == map.size()){
                max = Math.max(max,j-i+1);
            }
            if(j-i+1>map.size()){
                while(i<j && j-i+1 !=map.size()){
                    int freq = map.get(nums[i]);
                    if(freq==1)map.remove(nums[i]);
                    else map.put(nums[i],freq-1);
                    i++;
                }
            }
        }
        return max;
    }
}