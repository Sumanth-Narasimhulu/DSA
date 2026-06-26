class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        
        int n = mat.length;
        int m = mat[0].length;
        int[][]pref = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int top = (i>0)?pref[i-1][j]:0;
                int left = (j>0)?pref[i][j-1]:0;
                int diag = ((i>0)&&(j>0))?pref[i-1][j-1]:0;
                pref[i][j] = top+left-diag+mat[i][j];
            }
        }


        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int r1 = Math.max(0,i-k);
                int c1 = Math.max(0,j-k);
                int r2 = Math.min(n-1,i+k);
                int c2 = Math.min(m-1,j+k);

                int sum = pref[r2][c2];

                int top = (r1)>0?pref[r1-1][c2]:0;
                int left = (c1)>0?pref[r2][c1-1]:0;
                int diag = ((r1>0) && (c1>0))?pref[r1-1][c1-1]:0;

                sum= sum-top-left+diag;
                mat[i][j]=sum;
            }
        }
        return mat;

    }
}