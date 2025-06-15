class Solution {
    int smallestDivisor(int[] arr, int k) {
        // Code here
        int low=0;
        int high = 0;
        for(var ele:arr){
            high = Math.max(high,ele);
            
        }
        int ans = high;
        while(low<=high){
            int mid = (low+high)/2;
            if(isOk(arr,mid,k)){
                ans = Math.min(ans,mid);
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
    public boolean isOk(int[]arr,int mid,int k){
        int sum=0;
        int n = arr.length;
        for(int i=0;i<n;i++){
            sum+=(Math.ceil(
                (double)(arr[i])/(double)(mid)
                ));
        }
        return sum<=k;
    }
}