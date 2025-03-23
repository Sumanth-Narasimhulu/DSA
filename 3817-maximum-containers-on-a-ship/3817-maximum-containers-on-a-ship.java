class Solution {
    public int maxContainers(int n, int w, int maxWeight) {
        int cells = n*n;
        int c =0;
        int totalWeight=0;
        while(totalWeight<=maxWeight && c<=cells){
            totalWeight+=w;
            c++;

        }
        return --c;
        
    }
}