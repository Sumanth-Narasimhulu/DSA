class Solution {
    public int numberOfBeams(String[] bank) {
        
        Integer prev = null;
        int sum=0;

        int i=0;
        int n = bank.length;
        while(i<n){
            int ones = cntones(bank[i]);
            if(ones>0){
                prev=ones;
                break;
            }
            i++;
        }
        i++;
        while(i<n){
            int ones = cntones(bank[i]);
            if(ones>0){
                sum+=(prev*ones);
                prev=ones;
            }
            i++;
        }
        return sum;
    }
    public int cntones(String s){
        int o=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1')o++;
        }
        return o;
    }
}