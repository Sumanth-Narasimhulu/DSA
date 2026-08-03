class Solution {
    public String reverseParentheses(String s) {
        
        Stack<Integer>stack = new Stack<>();
        char[]nums = s.toCharArray();
        for(int i=0;i<nums.length;i++){
            if(nums[i]=='('){
                stack.push(i);
            }else if(nums[i]==')'){
                if(!stack.isEmpty()){
                reverse(nums,stack.peek()+1,i-1);
                stack.pop();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char c:nums){
            if(c!='(' && c!=')'){
                sb.append(c);
            }
        }
        return sb.toString();
    }
    public void reverse(char[]nums,int i,int j){
        while(i<j){
            char temp = nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            i++;
            j--;
        }
    }
}