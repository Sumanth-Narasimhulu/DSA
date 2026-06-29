class Solution {
    public int missingInteger(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for(int num : nums){
            set.add(num);
        }

        int end = 0;
        int sum = nums[0];

        while(end + 1 < nums.length &&
              nums[end + 1] == nums[end] + 1){
            end++;
            sum += nums[end];
        }

        while(set.contains(sum)){
            sum++;
        }

        return sum;
    }
}