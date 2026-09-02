class Solution {
    public int calculate(String s) {
        char[]nums = s.toCharArray();
        int num = 0;
        int res =0;
        int sign =1;
        Stack<Integer>stack = new Stack<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]==' ')continue;

            if(nums[i]=='('){
                stack.push(res);
                stack.push(sign);
                res=0;
                sign=1;
            }else if(Character.isDigit(nums[i])){
                num = num*10+Character.getNumericValue(nums[i]);
                
            }else if(nums[i]=='+' || nums[i] =='-'){
                res+=num*sign;
                if(nums[i]=='+')sign=1;
                else sign=-1;
                num=0;
            }else if(nums[i]==')'){
                res += num * sign;
                int topSign = stack.pop();
                int val = stack.pop();
                if(topSign==-1)
                res = val - res;
                else res = val + res;
                num=0;
                sign=1;
            }
        }
        return res+num*sign;
    }
}