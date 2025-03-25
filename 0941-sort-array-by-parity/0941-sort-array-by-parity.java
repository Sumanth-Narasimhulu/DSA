class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int j=-1;
        int n= nums.length;
        while(j<n){
            if(j!=-1)
            if(nums[j]%2==1)break;
            j++;
        }
        if(j==-1)return nums;
        for(int i=j+1;i<n;i++){
            if(nums[i]%2==0){
                int temp = nums[j];
                nums[j]=nums[i];
                nums[i]=temp;
                j++;
            }

        }
        return nums;
        
    }
}