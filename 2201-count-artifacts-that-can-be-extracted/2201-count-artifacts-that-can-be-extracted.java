class Solution {
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        
        Set<String>set = new HashSet<>();
        for(int[]d:dig){
            int r = d[0];
            int c = d[1];
            StringBuilder sb = new StringBuilder();
            sb.append(r).append(",").append(c);
            set.add(sb.toString());
        }
        int cnt=0;
        for(int[]a:artifacts){
            int r1 = a[0];
            int c1 = a[1];
            int r2 = a[2];
            int c2 = a[3];
            boolean flag = true;
            for(int i=r1;i<=r2;i++){
                for(int j=c1;j<=c2;j++){
                    StringBuilder sb = new StringBuilder();
                    sb.append(i).append(",").append(j);
                    if(!set.contains(sb.toString())){
                        flag = false;
                        break;
                    }
                }
                if(!flag)break;
            }
            if(flag)cnt++;
        }
        return cnt;
    }
}