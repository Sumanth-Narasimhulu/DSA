class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int maxOnes=-1;
        int row=-1;
        int n = mat.length;
        for(int i=0;i<n;i++){
            int ones = ones(mat[i]);
            if(ones>maxOnes){
                maxOnes=ones;
                row=i;
            }
        }
        return new int[]{row,maxOnes};
    }
    public int ones(int[]r){
        int cnt=0;
        for(int e:r){
            if (e==1)cnt++;
        }
        return cnt;
    }
}