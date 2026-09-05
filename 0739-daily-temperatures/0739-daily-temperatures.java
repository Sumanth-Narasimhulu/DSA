class Solution {
    public int[]NGR(int[]nums){
        int n  = nums.length;
        int[]res = new int[n];
        Stack<Integer>stack = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && nums[stack.peek()]<=nums[i])
             stack.pop();
            if(!stack.isEmpty())
            res[i]=stack.peek()-i;
            else res[i]=0;
            
            stack.push(i);
        }
        return res;

    }
    public int[] dailyTemperatures(int[] temperatures) {
        return NGR(temperatures);
        
    }
}