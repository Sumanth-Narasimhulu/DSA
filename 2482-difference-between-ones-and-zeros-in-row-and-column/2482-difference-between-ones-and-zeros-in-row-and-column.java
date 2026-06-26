class Solution {
    int n;
    int m;
    public int[][] onesMinusZeros(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int[]onesRow = new int[n];
        int[]onesCol = new int[m];
        int[]zerosRow = new int[n];
        int[]zerosCol = new int[m];
        row(grid,onesRow,zerosRow);
        col(grid,onesCol,zerosCol);
        int[][]diff = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                diff[i][j] = onesRow[i]+onesCol[j]-zerosRow[i]-zerosCol[j];
            }
        }
        return diff;


    }
    public void row(int[][]grid,int[]onesRow,int[]zerosRow){
        for(int i=0;i<n;i++){
            int oCnt=0;
            int zCnt=0;
            for(int j=0;j<m;j++){
                if(grid[i][j]==1)oCnt++;
                else zCnt++;
            }
            onesRow[i]=oCnt;
            zerosRow[i]=zCnt;
        }
    }

    public void col(int[][]grid,int[]onesCol,int[]zerosCol){
        for(int j=0;j<m;j++){
            int oCnt=0;
            int zCnt=0;
            for(int i=0;i<n;i++){
                if(grid[i][j]==0)zCnt++;
                else oCnt++;
            }
            onesCol[j]= oCnt;
            zerosCol[j] = zCnt;
        }
    }
}