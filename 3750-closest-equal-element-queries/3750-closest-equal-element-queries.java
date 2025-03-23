class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        
        List<Integer> res = new ArrayList<>();
        for (int q : queries) {
            int ele = nums[q];
            List<Integer> indices = map.get(ele);
            
            if (indices.size() == 1) {
                res.add(-1);
                continue;
            }
            
            
            int pos = Collections.binarySearch(indices, q);
            int leftNeighbor = indices.get((pos - 1 + indices.size()) % indices.size());
            int rightNeighbor = indices.get((pos + 1) % indices.size());
            
            int d1 = Math.abs(q - leftNeighbor);
            int d2 = Math.abs(q - rightNeighbor);
            int dist1 = Math.min(d1, n - d1);
            int dist2 = Math.min(d2, n - d2);
            res.add(Math.min(dist1, dist2));
        }
        return res;
    }
}
