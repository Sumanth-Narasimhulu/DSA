class Solution {
    public void dfs(int node,List<List<Integer>>adj,boolean[]vis,int[] vertices,int[] edges){
        vis[node]=true;
        vertices[0]++;
        edges[0]+=adj.get(node).size();
        for(int adjNode:adj.get(node)){
            if(!vis[adjNode])dfs(adjNode,adj,vis,vertices,edges);
        }
    }

    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>>adj = new ArrayList<>();
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());
        for(int[]edge:edges){

            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int cnt=0;
        boolean[]vis = new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                int[]vertices = new int[1];
                int[]edge = new int[1];
                dfs(i,adj,vis,vertices,edge);
                edge[0] = edge[0]/2;
                if((vertices[0]*(vertices[0]-1))/2==edge[0])cnt++;
            }
        }
        return cnt;
        
    }
}
/*
0->{1,2}
1->{0,2}
2->{0,1}
3->{4}
4->{3}
5


 */