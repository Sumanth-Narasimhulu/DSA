class Solution {
    public int maximumLength(int[] nums) {
        
        HashMap<Long,Integer>map = new HashMap<>();

        for(int ele:nums)map.put((long)ele,map.getOrDefault((long)ele,0)+1);
        int max=1;
        if(map.containsKey(1L)){
            int freq = map.get(1L);
            if(freq%2==0)freq--;
            max = Math.max(max,freq);
        }
        for(long x:map.keySet()){
            if(x==1L)continue;
            long curr = x;
            int len = 0;
            while(true){
            int cf = map.getOrDefault(curr,0);
            if(cf>=2){
                len+=2;
            }else if(cf==1){
                len+=1;
                break;
            }else{
                len-=1;
                break;
            }
            curr = curr*curr;
        }
            max = Math.max(max,len);
        }
        return max;
    }
}