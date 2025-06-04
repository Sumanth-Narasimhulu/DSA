// User function Template for Java

class Solution {
    // Function to count inversions in the array.
    static int cnt;
    static void sort(int[]nums,int low,int high){
        if(low>=high)return;
        int mid = (low+high)/2;
        sort(nums,low,mid);
        sort(nums,mid+1,high);
        merge(nums,low,mid,high);
    }
    static void merge(int[]nums,int low,int mid,int high){
        int start = low;
        int end = mid+1;
        List<Integer>temp = new ArrayList<>();
        while(start<=mid && end<=high){
            if(nums[start]<=nums[end]){
                temp.add(nums[start]);
                start++;
            }else{
                cnt+=(mid-start+1);
                temp.add(nums[end]);
                end++;
            }
        }
        while(start<=mid){
             temp.add(nums[start]);
             start++;
        }
        while(end<=high){
            temp.add(nums[end]);
            end++;
        }
        for(int i=low;i<=high;i++){
            nums[i]=temp.get(i-low);
        }
        
    }
    static int inversionCount(int arr[]) {
        // Your Code Here
        cnt=0;
        sort(arr,0,arr.length-1);
        return cnt;
        
    }
}