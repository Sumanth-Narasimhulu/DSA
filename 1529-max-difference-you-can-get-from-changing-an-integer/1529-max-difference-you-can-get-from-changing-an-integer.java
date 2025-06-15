class Solution {
    public int maxDiff(int num) {
        String n = String.valueOf(num);
        char[]nums = n.toCharArray();
        int len = nums.length;
        char[]temp = new char[len];
        for(var i=0;i<len;i++){
            temp[i]=nums[i];
        }
        int max = Integer.MAX_VALUE;
        for(var i=0;i<len;i++){
            
                if(nums[i]!='9'){
                    replace(nums,nums[i],'9');
                    break;
                }
            
        }
        max = Integer.parseInt(String.valueOf(nums));
        //  for(var i=0;i<len;i++){
        //     nums[i]=temp[i];
        // }
        int min = Integer.MIN_VALUE;
        for(var i=0;i<len;i++){
            if(i==0){
                if(temp[i]!='1'){
                    replace(temp,temp[i],'1');
                    break;
                }
            }else{
                if(temp[i]!='0' && temp[i]!=temp[0]){
                    replace(temp,temp[i],'0');
                    break;
                }
            }
        }
        min = Integer.parseInt(String.valueOf(temp));
        return max-min;
        
    }
    public void replace(char[] nums,char i1,char j){
        var n = nums.length;
        for(var i=0;i<n;i++){
            if(nums[i]==i1){
                nums[i]=j;
            }
        }
    }
}