class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        List<Integer>lesser = new ArrayList<>();
        List<Integer>greater = new ArrayList<>();
        int cnt=0;
        for(int ele:nums){
            if(ele<pivot){
                lesser.add(ele);
            }else if(ele>pivot){
                greater.add(ele);
            }else{
                cnt++;
            }
        }
        int[]res = new int[n];
        int ind=0;
        for(int k=0;k<lesser.size();k++){
            res[ind++]=lesser.get(k);
        }
        while(cnt>0){
            res[ind++]=pivot;
            cnt--;
        }
        for(int k=0;k<greater.size();k++){
            res[ind++]=greater.get(k);
        }
        return res;

        
    }
}