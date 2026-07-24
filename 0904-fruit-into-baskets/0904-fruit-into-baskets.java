class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer>map = new HashMap<>();
        int i=0;
        int n = fruits.length;
        int max=0;
        for(int j=0;j<n;j++){
            map.put(fruits[j],map.getOrDefault(fruits[j],0)+1);
            while(map.size()>2 && i<j){
                int freq = map.get(fruits[i]);
                if(freq==1)map.remove(fruits[i]);
                else map.put(fruits[i],freq-1);
                i++;
            }
            max = Math.max(max,j-i+1);
        }
        return max;
    }
}