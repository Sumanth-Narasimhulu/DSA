class Solution {
    public int minMaxDifference(int num) {
        String n = String.valueOf(num);
        char[]nums = n.toCharArray();
        char[]temp = new char[nums.length];
        for(var i=0;i<nums.length;i++){
            temp[i]=nums[i];
        }
        // System.out.println(String.valueOf(temp));
        Set<Character>set = new HashSet<>();
        for(char c:nums)set.add(c);
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(char c:set){

            for(var i=0;i<nums.length;i++){
                if(nums[i]==c && c!='9'){
                    nums[i]='9';
                    
                }

            }
            String number = String.valueOf(nums);
            max = Math.max(max,Integer.parseInt(number));
           for(var i=0;i<nums.length;i++){
                nums[i]=temp[i];
            }

        }

        for(char c:set){
            for(var i=0;i<nums.length;i++){
                if(nums[i]!='0' && c==nums[i]){
                    nums[i]='0';
                }
            }
            String number = String.valueOf(nums);
            min = Math.min(min,Integer.parseInt(number));
            for(var i=0;i<nums.length;i++){
                nums[i]=temp[i];
            }
        }
        return max-min;
        
    }
}