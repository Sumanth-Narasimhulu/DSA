class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer>stack = new Stack<>();
        char[]nums = s.toCharArray();
        Set<Integer>invalidIndices = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]=='('){
                stack.push(i);
            }else if(nums[i]==')'){
                if(stack.isEmpty()){
                    invalidIndices.add(i);
                }else{
                    stack.pop();
                }
                
            }
        }
        while(!stack.isEmpty()){
            invalidIndices.add(stack.pop());
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<nums.length;i++){
            if(invalidIndices.contains(i))continue;
            sb.append(nums[i]);
        }
        return sb.toString();
    }
}