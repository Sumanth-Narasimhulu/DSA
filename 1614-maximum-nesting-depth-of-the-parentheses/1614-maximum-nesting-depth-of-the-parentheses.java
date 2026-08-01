class Solution {
    public int maxDepth(String s) {
        
        int max=0;
        int cnt=0;
        char[]nums = s.toCharArray();
        for(int i=0;i<nums.length;i++){
            if(nums[i]=='('){
                cnt++;
               max= Math.max(max,cnt);
            }else if(nums[i]==')'){
                cnt--;
            }
        }
        return max;
    }
}