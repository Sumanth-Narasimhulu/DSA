class Solution {
    public int maximumWealth(int[][] accounts) {
        
        int max = -1;
        
        for(int[]r:accounts){
            int sum=0;
            for(int e:r){
                sum+=e;
            }
            if(sum>max)max=sum;
        }
        return max;
    }
}