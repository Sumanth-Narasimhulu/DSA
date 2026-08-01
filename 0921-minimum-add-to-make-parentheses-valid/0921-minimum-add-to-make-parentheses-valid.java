class Solution {
    public int minAddToMakeValid(String s) {
        
        Stack<Character>stack = new Stack<>();
        char[]nums = s.toCharArray();
        for(int i=0;i<nums.length;i++){
            char curr = nums[i];
            if(!stack.isEmpty() && (stack.peek()=='(' && curr==')')){
                stack.pop();
            }else{
                stack.push(curr);
            }
        }
        return stack.size();
    }
}