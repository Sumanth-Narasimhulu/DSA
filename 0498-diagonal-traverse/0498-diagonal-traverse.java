class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        TreeMap<Integer,List<Integer>>map = new TreeMap<>();
        int n = mat.length;
        int m = mat[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(map.containsKey(i+j)){
                    List<Integer>ds = map.get(i+j);
                    ds.add(mat[i][j]);
                    map.put(i+j,ds);
                }else{
                    List<Integer>ds = new ArrayList<>();
                    ds.add(mat[i][j]);
                    map.put(i+j,ds);
                }
            }
        }
        int[]res = new int[n*m];
        int i=0;
        for(Map.Entry<Integer,List<Integer>>m1:map.entrySet()){
            int k = m1.getKey();
            List<Integer>ds = m1.getValue();
            if(k%2==0
            )Collections.reverse(ds);
            for(int e:ds){
                res[i++]=e;
            }
        }
        return res;
    }
}