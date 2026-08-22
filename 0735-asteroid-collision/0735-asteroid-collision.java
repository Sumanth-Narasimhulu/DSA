class Solution {
    public int[] asteroidCollision(int[] nums) {
        Stack<Integer>stack = new Stack<>();
        for(int ele:nums){
            boolean flag = false;

            while(!stack.isEmpty() && stack.peek()>0 && ele<0){
                int top = stack.peek();
                if(top<-ele){
                    stack.pop();
                }
                else if(top == -ele){
                    stack.pop();
                    flag = true;
                    break;
                }else{
                    flag = true;
                    break;
                }
            }
            if(!flag)stack.push(ele);
            
        }
        if(stack.isEmpty())return new int[]{};
        int[]ans = new int[stack.size()];
        int ind = ans.length-1;
        while(!stack.isEmpty()){
            ans[ind--]=stack.pop();
        }
        return ans;
    }
}