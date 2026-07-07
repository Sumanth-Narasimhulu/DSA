class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int ele : nums)
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        int maxRows = 1;
        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            maxRows = Math.max(maxRows, m.getValue());
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < maxRows; i++) {
            List<Integer> ds = new ArrayList<>();
            Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();

            while (it.hasNext()) {
                Map.Entry<Integer, Integer> m = it.next();

                int key = m.getKey();
                int freq = m.getValue();

                ds.add(key);

                if (freq == 1) {
                    it.remove(); 
                } else {
                    m.setValue(freq - 1); 
                }
            }
            res.add(ds);
        }
        return res;
    }
}