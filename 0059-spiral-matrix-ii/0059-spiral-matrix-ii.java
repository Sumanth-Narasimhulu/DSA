class Solution {
    public int[][] generateMatrix(int n) {

        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = n - 1;

        int cnt = 1;

        int[][] res = new int[n][n];

        while (left <= right && top <= bottom) {

            // top row
            for (int i = left; i <= right; i++) {
                res[top][i] = cnt++;
            }
            top++;

            // right column
            for (int i = top; i <= bottom; i++) {
                res[i][right] = cnt++;
            }
            right--;

            // bottom row
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    res[bottom][i] = cnt++;
                }
                bottom--;
            }

            // left column
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    res[i][left] = cnt++;
                }
                left++;
            }
        }

        return res;
    }
}