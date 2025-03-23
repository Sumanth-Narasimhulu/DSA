class Solution {
     public int MOD = (int)(1e9 +7);
    static class Pair implements Comparable<Pair>{
        int node;
        long dist;
        public Pair(int node,long dist){
            this.node = node;
            this.dist = dist;
        }
        public int compareTo(Pair o){
            return Long.compare(this.dist,o.dist);
        }
    }
    static class Tuple{
        int v;
        long dist;
        public Tuple(int v,long dist){
            this.v = v;
            this.dist = dist;
        }
    }
    public int countPaths(int n, int[][] roads) {
        // if(n==200)return 1;
        List<List<Tuple>>adj = new ArrayList<>();
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());
        for(int[]edge:roads){
            adj.get(edge[0]).add(new Tuple(edge[1],(long)(edge[2])));
            adj.get(edge[1]).add(new Tuple(edge[0],(long)(edge[2])));
        }
        long[]dist = new long[n];
        Arrays.fill(dist,Long.MAX_VALUE/2);
        dist[0]=0;
        PriorityQueue<Pair>pq = new PriorityQueue<>();
        pq.offer(new Pair(0,0));
        int[]ways = new int[n];
        ways[0]=1;
        while(!pq.isEmpty()){
            Pair top = pq.poll();
            int node = top.node;
            long d = top.dist;
            for(Tuple tuple:adj.get(node)){
                int adjNode = tuple.v;
                long newDist = tuple.dist;
                if(d+newDist<dist[adjNode]){
                    ways[adjNode]=ways[node];
                    dist[adjNode]=d+newDist;
                    pq.offer(new Pair(adjNode,d+newDist));
                }else if(d+newDist == dist[adjNode]){
                    ways[adjNode]=(ways[node]+ways[adjNode])%MOD;
                }
            }
        }
        return ways[n-1]%MOD;
        
    }
}