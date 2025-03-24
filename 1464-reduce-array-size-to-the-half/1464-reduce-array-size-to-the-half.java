class Solution {
    public int minSetSize(int[] arr) {
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int ele:arr)map.put(ele,map.getOrDefault(ele,0)+1);
        int n = arr.length;
        Pair[]nums = new Pair[map.size()];
        int ind=0;
        // int totalSize=0;
        for(Map.Entry<Integer,Integer>m:map.entrySet()){
            // totalSize+=m.getValue();
            nums[ind++]=new Pair(m.getKey(),m.getValue());


        }
        Arrays.sort(nums);
        int removed=0;
        int cnt=0;
        for(Pair p:nums){
            if(removed>=(n/2))return cnt;
            removed+=p.freq;
            cnt++;
            
        }
        return cnt;

        
    }
    static class Pair implements Comparable<Pair>{
        int ele;
        int freq;
        public Pair(int ele,int freq){
            this.ele = ele;
            this.freq = freq;
        }
        public int compareTo(Pair o){
            return o.freq-this.freq;
        }
    }
}