class Solution {
    static class Pair implements Comparable<Pair>{
        int start;
        int end;
        public Pair(int start,int end){
            this.start = start;
            this.end = end;
        }
        public int compareTo(Pair o){
            if(this.start!=o.start)return this.start - o.start;
            return this.end - o.end;
        }
    }
    public int countDays(int days, int[][] meetings) {
        List<Pair>ds = new ArrayList<>();
        for(int []meeting:meetings){
            ds.add(new Pair(meeting[0],meeting[1]));
        }
        Collections.sort(ds);
        if(ds.size()==0)return days;
        if(ds.size()==1){
            int cnt=0;
            cnt+=(ds.get(0).start)-1;
            cnt+=(days-ds.get(0).end);
            return cnt;
        }
        
        Pair p = ds.get(0);
        int cnt=0;
        cnt+=(p.start)-1;
        int endTime = p.end;
        
        for(int i=1;i<ds.size();i++){
            Pair curr = ds.get(i);
            if(curr.start<=endTime){
                endTime = Math.max(endTime,curr.end);
            }else{
            cnt+=(curr.start-endTime)-1;
            endTime = curr.end;
            }

        }
        
        cnt+=(days-endTime);
        return cnt;

        
    }
}