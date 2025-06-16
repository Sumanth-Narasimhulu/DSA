class Solution {
    public int minCost(int[] heights, int[] cost) {
        // code here
        var low = 0;
        var high = 0;
        for(var ele:heights){
            low = Math.min(low,ele);
            high = Math.max(high,ele);
        }
        var ans = Integer.MAX_VALUE;
        
        while(low<=high){
            int mid = (low+high)/2;
            int temp1 = f(heights,cost,mid);
            int temp2 = f(heights,cost,mid+1);
            ans = Math.min(ans,Math.min(temp1,temp2));
            if(temp1<temp2){
                
                high = mid-1;
            }else{
                low = mid+1;
            }
            
        }
        return ans;
        
    }
    public int f(int[]heights,int[]cost,int mid){
        int sum=0;
        for(var i=0;i<heights.length;i++){
            int d = Math.abs(heights[i]-mid);
            sum+=(cost[i]*d);
        }
        return sum;
    }
}
