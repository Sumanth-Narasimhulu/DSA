
class Solution {

    public int leftCandle(int l, int r, int[] c, char[] nums) {

        int low = l;
        int high = r;
        int res = -1;

        int before = (l == 0) ? 0 : c[l - 1];

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int currentCandles = c[mid] - before;

            if (currentCandles >= 1) {

                if (nums[mid] == '|') {
                    res = mid;
                }

                high = mid - 1;

            } else {

                low = mid + 1;
            }
        }

        return res;
    }


    public int rightCandle(int l, int r, int[] c, char[] nums) {

        int low = l;
        int high = r;
        int res = -1;

        int before = (l == 0) ? 0 : c[l - 1];
        int target = c[r] - before;

        if (target == 0) {
            return -1;
        }

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int current = c[mid] - before;

            if (current < target) {

                low = mid + 1;

            } else {


                if (nums[mid] == '|') {
                    res = mid;

                    low = mid + 1;

                } else {

                    high = mid - 1;
                }
            }
        }

        return res;
    }


    public int[] platesBetweenCandles(String s, int[][] queries) {

        int n = s.length();

        char[] nums = s.toCharArray();

        int[] p = new int[n]; // Prefix count of plates
        int[] c = new int[n]; // Prefix count of candles

        if (nums[0] == '*') {
            p[0] = 1;
        } else {
            c[0] = 1;
        }

        for (int i = 1; i < n; i++) {

            if (nums[i] == '*') {
                p[i] = p[i - 1] + 1;
                c[i] = c[i - 1];

            } else {
                c[i] = c[i - 1] + 1;
                p[i] = p[i - 1];
            }
        }

        int[] res = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int left = queries[i][0];
            int right = queries[i][1];

            int leftCandleIndex =
                leftCandle(left, right, c, nums);

            if (leftCandleIndex == -1) {
                res[i] = 0;
                continue;
            }

            int rightCandleIndex =
                rightCandle(leftCandleIndex + 1, right, c, nums);

            if (rightCandleIndex == -1) {
                res[i] = 0;
                continue;
            }

            res[i] = p[rightCandleIndex - 1]
                   - p[leftCandleIndex];
        }

        return res;
    }
}
