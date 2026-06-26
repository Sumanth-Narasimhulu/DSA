class Solution {
    public int maxSum(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;

        int[][]pref = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int top = (i>0)?pref[i-1][j]:0;
                int left = (j>0)?pref[i][j-1]:0;
                int diag = (i>0&&j>0)?pref[i-1][j-1]:0;
                pref[i][j] = top+left-diag+grid[i][j];
            }
        }

        int max = 0;

        for(int i=0;i<=n-3;i++){
            for(int j=0;j<=m-3;j++){
                int r1 = i;
                int c1 = j;
                int r2 = r1+2;
                int c2 = c1+2;
                // if(r2>n-1 || c2>m-1)return max;
                int sum=pref[r2][c2];
                int top = (r1>0)?pref[r1-1][c2]:0;
                int left = (c1>0)?pref[r2][c1-1]:0;
                int diag = (r1>0 && c1>0)?pref[r1-1][c1-1]:0;

                int a = grid[r2-1][c1]+grid[r2-1][c2];

                sum=sum-top-left-a+diag;
                max = Math.max(max,sum);


            }
        }
        return max;
    }
}