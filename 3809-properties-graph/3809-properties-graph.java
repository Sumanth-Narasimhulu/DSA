class Solution {

    public boolean intersect(int[]a,int[]b,int k){
        Set<Integer>seta = new HashSet<>();
        for(int ele:a){
            seta.add(ele);
        }
        Set<Integer>setb = new HashSet<>();
        int cnt=0;
        for(int ele:b)setb.add(ele);
        for(int ele:seta){
            if(setb.contains(ele)){
                cnt++;
                if(cnt>=k)return true;
            }
        }
        return false;
    }
    public int numberOfComponents(int[][] properties, int k) {
        List<List<Integer>>adj = new ArrayList<>();
        int n = properties.length;
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());
        for(int i=0;i<n;i++){
            // int j=0;

            for( int j=0;j<n;j++){
              if(i==j)continue;
                if(intersect(properties[i],properties[j],k)){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }



            }
        }
        boolean[]vis = new boolean[n];
        int cnt=0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                cnt++;
                dfs(i,adj,vis);
            }

        }
        return cnt;
        
    }
    public void dfs(int node,List<List<Integer>>adj,boolean[]vis){
        vis[node]=true;
        for(int adjNode:adj.get(node)){
            if(!vis[adjNode]){
                dfs(adjNode,adj,vis);
            }
        }
    }
}