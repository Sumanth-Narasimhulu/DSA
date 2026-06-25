class Solution {
    public int equalPairs(int[][] grid) {
        HashMap<String,Integer>map = new HashMap<>();
        int n = grid.length;
        int m = grid[0].length;

        for(int i=0;i<n;i++){
            StringBuilder s = new StringBuilder();
            for(int e: grid[i]){
                s.append(e);
                s.append(",");
            }
            map.put(s.toString(),map.getOrDefault(s.toString(),0)+1);
        }
        int cnt=0;
        for(int j=0;j<m;j++){
            StringBuilder s = new StringBuilder();
            for(int i=0;i<n;i++){
                s.append(grid[i][j]);
                s.append(",");
            }
            if(map.containsKey(s.toString())){
                cnt+=map.get(s.toString());
                // cnt++;
            }
        }
        return cnt;
    }
}