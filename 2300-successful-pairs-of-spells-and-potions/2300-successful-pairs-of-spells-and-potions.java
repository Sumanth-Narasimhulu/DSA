class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int pl = potions.length;
        Arrays.sort(potions);
        int[]res = new int[spells.length];
        for(int i=0;i<spells.length;i++){
            int lowerBoundary = f(spells[i],potions,success);
            if(lowerBoundary==-1){
                res[i]=0;
                continue;
            }
            res[i]= pl-lowerBoundary;

        }
        return res;
    }
    public int f(int s,int[]potions,long num){
        int res=-1;
        int low = 0;
        int high = potions.length-1;
        while(low<=high){
            int mid = (low+(high-low)/2);
            long product = (long)(s)*(long)(potions[mid]);
            if(product>=num){
                res=mid;
                high = mid-1;
            }else low = mid+1;
        }
        return res;
    }
}