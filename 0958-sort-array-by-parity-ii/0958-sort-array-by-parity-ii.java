class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int n = nums.length;
        int[]odd = new int[n/2];
        int[]even = new int[n/2];
        int evenInd=0;
        int oddInd=0;
        for(int ele:nums){
            if(ele%2==0){
                even[evenInd]=ele;
                evenInd++;
            }else{
                odd[oddInd]=ele;
                oddInd++;
            }
        }
         evenInd=0;
         oddInd=1;
         int[]res = new int[n];
         for(int o:odd){
            // if(oddInd<n/2)
            res[oddInd]=o;
            oddInd+=2;

         }
         for(int e:even){
            
                res[evenInd]=e;
            
            evenInd+=2;
         }
         return res;

        
    }
}