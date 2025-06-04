class Solution {
    int[][][] dp;

    int f(String s1, String s2, String s3, int i, int j, int k) {
        if (i < 0 || j < 0 || k < 0) return 0;

        if (dp[i][j][k] != -1) return dp[i][j][k];

        if (s1.charAt(i) == s2.charAt(j) && s2.charAt(j) == s3.charAt(k)) {
            return dp[i][j][k] = 1 + f(s1, s2, s3, i - 1, j - 1, k - 1);
        }

        int p = f(s1, s2, s3, i - 1, j, k);
        int q = f(s1, s2, s3, i, j - 1, k);
        int r = f(s1, s2, s3, i, j, k - 1);

        return dp[i][j][k] = Math.max(p, Math.max(q, r));
    }

    int lcsOf3(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        int l = s3.length();

        dp = new int[n][m][l];

        for (int[][] layer : dp)
            for (int[] row : layer)
                Arrays.fill(row, -1);

        return f(s1, s2, s3, n - 1, m - 1, l - 1);
    }
}
