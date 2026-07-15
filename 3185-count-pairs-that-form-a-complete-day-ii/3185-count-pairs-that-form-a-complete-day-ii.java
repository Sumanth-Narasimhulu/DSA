class Solution {
    public long countCompleteDayPairs(int[] arr) {
        HashMap<Integer,Integer>map = new HashMap<>();
        int n = arr.length;
        long cnt=0;
        for(int ele:arr){
            int needed = (24-ele%24)%24;
            if(map.containsKey(needed)){
                cnt+=map.get(needed);
                
            }
                map.put(
                    (ele % 24) ,map.getOrDefault((ele % 24),0)+1
                    );
            
        }
        return cnt;
    }
}