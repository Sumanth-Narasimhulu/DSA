class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]>res = new ArrayList<>();
        for(int[]interval:intervals){
            if(res.isEmpty() || res.get(res.size()-1)[1]<interval[0]){
                res.add(interval);
            }else{
                res.get(res.size()-1)[1] = Math.max(res.get(res.size()-1)[1],interval[1]);
            }

        }
        int[][]ans = new int[res.size()][2];
        for(int i=0;i<ans.length;i++){
            ans[i]=res.get(i);
        }
        return ans;
    }
}