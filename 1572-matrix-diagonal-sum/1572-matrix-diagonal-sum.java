class Solution {
    public int diagonalSum(int[][] mat) {
        
        int n = mat.length;

        int sum=0;
        int row =0;
        int col =0;
        while(row<n && col<n){
            sum+=(mat[row][col]);
            row++;
            col++;
        }
        row =0;
        col = n-1;
        while(row<n && col>=0){
            sum+=(mat[row][col]);
            row++;
            col--;
        }
        if(n%2==1){
            int mid = n/2;
            sum-=(mat[mid][mid]);
        }
        return sum;
    }
}