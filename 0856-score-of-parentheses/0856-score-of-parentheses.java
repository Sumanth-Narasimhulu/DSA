class Solution {
    public int scoreOfParentheses(String s) {
       
       Stack<Object>stack = new Stack<>();
       char[]nums = s.toCharArray();
       for(int i=0;i<nums.length;i++){
        if(nums[i]=='(')stack.push('(');
        else{
            Integer sum=0;
            while(!stack.isEmpty() && stack.peek() instanceof Integer){
                sum+=(Integer)(stack.pop());

            }
            stack.pop();
            if(sum==0){
                stack.push(1);
            }else{
                stack.push(2*sum);
            }
        }
       }
       int res=0;
       while(!stack.isEmpty()){
        res+=(Integer)stack.pop();
       }
       return res;
    }
}
