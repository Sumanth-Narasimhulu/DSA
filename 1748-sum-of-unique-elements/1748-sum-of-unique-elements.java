class Solution {
    public int sumOfUnique(int[] nums) {
       Map<Integer,Integer>map = new HashMap<>();
       for(int ele:nums){
        map.put(ele,map.getOrDefault(ele,0)+1);
       }
       int sum=0;
       for(Map.Entry<Integer,Integer>m:map.entrySet()){
        if(m.getValue()==1)sum+=m.getKey();
       }
       return sum;
    }
}