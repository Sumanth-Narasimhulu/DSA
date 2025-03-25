class Solution {
    static class Pair implements Comparable<Pair>{
        int start;
        int end;
        public Pair(int start,int end){
            this.start = start;
            this.end = end;
        }
        public int compareTo(Pair o){
            if(this.start!=o.start)return this.start-o.start;
            return this.end - o.end;
        }
        
    }
    public boolean mergeIntervals(int[][]intervals){
        int n = intervals.length;
        Pair[]p = new Pair[n];
        int ind=0;
        for(int[]edge:intervals){
            p[ind++]=new Pair(edge[0],edge[1]);
        }
        Arrays.sort(p);
        List<int[]>res = new ArrayList<>();
        res.add(new int[]{p[0].start,p[0].end});
        for(int i=1;i<n;i++){
            if(res.get(res.size()-1)[1]>p[i].start){
                res.get(res.size()-1)[1]=Math.max(p[i].end,res.get(res.size()-1)[1]);

            }else
            res.add(new int[]{p[i].start,p[i].end});

        }
        return res.size()>=3;
    }
    public boolean checkValidCuts(int n, int[][] rectangles) {
        int k = rectangles.length;
        int[][] x = new int[k][2];
        int[][] y = new int[k][2];
        int ind=0;
        for(int[]edge:rectangles){
            x[ind][0]=edge[0];
            x[ind][1]=edge[2];
            y[ind][0]=edge[1];
            y[ind][1]=edge[3];
            ind++;

        }
        boolean h = mergeIntervals(x);
        if(h)return true;
        boolean v = mergeIntervals(y);
        return v;
        
    }
}