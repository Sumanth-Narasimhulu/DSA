class Solution {
    public int maxResult(int[] nums, int k) {
        Deque<Integer>dq = new ArrayDeque<>();
        int n = nums.length;
        int[]res = new int[n];
        res[n-1]=nums[n-1];
        dq.offerLast(n-1);
        for(int i=n-2;i>=0;i--){
            if(dq.peek()-i>k)dq.pollFirst();
            res[i] = nums[i]+res[dq.peek()];
            while(!dq.isEmpty() && res[dq.peekLast()]<res[i])dq.pollLast();
            dq.offerLast(i);
        }
        return res[0];
    }
}