class Solution {
    public int tupleSameProduct(int[] nums) {
        HashMap<Integer,Integer>map = new HashMap<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int prod = nums[i]*nums[j];
                map.put(prod,map.getOrDefault(prod,0)+1);
            }
        }
        int cnt=0;
        for(Map.Entry<Integer,Integer>m:map.entrySet()){
            if(m.getValue()==1)continue;
            int freq = m.getValue();
            cnt+=(freq*(freq-1)/2);

        }
        return cnt*8;
    }
}