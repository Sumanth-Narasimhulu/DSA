class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        HashMap<Character,Integer>map = new HashMap<>();
        char[]nums = s.toCharArray();
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],i);
            }
        }
        int max = -1;

        for(int i=1;i<n;i++){
            if(map.containsKey(nums[i])){
                
                int len = i - map.get(nums[i])+1;
                max = Math.max(max,len-2);
                

            }
        }
        return max;

    }
}