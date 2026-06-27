class Solution {
    public int[][] resultGrid(int[][] image, int threshold) {
        int n = image.length;
        int m = image[0].length;
        int[][] pref = new int[n][m];
        int[][] sum = new int[n][m];
        int[][] cnt = new int[n][m];
        int[][] res = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                int top = i > 0 ? pref[i - 1][j] : 0;
                int left = j > 0 ? pref[i][j - 1] : 0;
                int diag = (i > 0 && j > 0) ? pref[i - 1][j - 1] : 0;

                pref[i][j] = top + left + image[i][j] - diag;
            }
        }

        helper(pref, sum, cnt, n, m, threshold, image);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (cnt[i][j] == 0) {
                    res[i][j] = image[i][j];
                } else {
                    res[i][j] = sum[i][j] / cnt[i][j];
                }
            }
        }
        return res;

    }

    public void helper(int[][] pref, int[][] sum, int[][] cnt, int n, int m, int threshold, int[][] image) {

        for (int i = 0; i <= n - 3; i++) {
            for (int j = 0; j <= m - 3; j++) {

                int r1 = i;
                int c1 = j;
                int r2 = i + 2;
                int c2 = j + 2;

                if (isValid(r1, c1, r2, c2, threshold, image)) {
                    int prefSum = pref[r2][c2];

                    int top = (r1 > 0) ? pref[r1 - 1][c2] : 0;
                    int left = (c1 > 0) ? pref[r2][c1 - 1] : 0;
                    int diag = (r1 > 0 && c1 > 0) ? pref[r1 - 1][c1 - 1] : 0;

                    prefSum = prefSum - top - left + diag;

                    for (int k = r1; k <= r2; k++) {
                        for (int l = c1; l <= c2; l++) {
                            sum[k][l] += (prefSum / 9);
                            cnt[k][l]++;
                        }
                    }
                }
            }
        }
    }

    public boolean isValid(int r1, int c1, int r2, int c2,
            int threshold, int[][] image) {

        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {

                if (j < c2 &&
                        Math.abs(image[i][j] - image[i][j + 1]) > threshold)
                    return false;

                if (i < r2 &&
                        Math.abs(image[i][j] - image[i + 1][j]) > threshold)
                    return false;
            }
        }

        return true;
    }

}
