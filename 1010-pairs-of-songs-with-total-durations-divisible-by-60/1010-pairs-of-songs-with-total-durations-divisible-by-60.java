class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        HashMap<Integer,Integer>map = new HashMap<>();
        int n = time.length;
        int cnt=0;
        for(int i=0;i<n;i++){
            int needed = (60 - time[i]%60)%60;
            if(map.containsKey(needed))cnt+=map.get(needed);
            map.put(time[i]%60,map.getOrDefault(time[i]%60,0)+1);
        }
        return cnt;

    }
}