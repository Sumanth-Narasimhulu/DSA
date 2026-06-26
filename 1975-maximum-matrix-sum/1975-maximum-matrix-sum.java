class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        long sum=0;
        int min = Integer.MAX_VALUE;
        int negCnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]<0)negCnt++;
               
                   min=Math.min(min,Math.abs(matrix[i][j]));
                
                sum+=Math.abs(matrix[i][j]);
            }
        }
        // System.out.println(min);
        if(negCnt%2==1)sum-=(2*Math.abs(min));
        return sum;

    }
}