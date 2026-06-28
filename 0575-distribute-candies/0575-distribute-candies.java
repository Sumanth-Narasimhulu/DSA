class Solution {
    public int distributeCandies(int[] candyType) {
        Set<Integer>set = new HashSet<>();
        int n = candyType.length;
        for(int ele:candyType)set.add(ele);
        if(set.size()<=(n/2))return set.size();
        return n/2;
    }
}