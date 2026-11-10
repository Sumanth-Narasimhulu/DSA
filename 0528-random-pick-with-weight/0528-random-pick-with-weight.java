class Solution {

    int[] prefixSum;
    int totalSum;
    Random random = new Random();

    public Solution(int[] w) {

        prefixSum = new int[w.length];

        totalSum = 0;

        for (int i = 0; i < w.length; i++) {
            totalSum += w[i];
            prefixSum[i] = totalSum;
        }
    }

    public int pickIndex() {

        int target = random.nextInt(totalSum) + 1;

        int low = 0;
        int high = prefixSum.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (prefixSum[mid] >= target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */