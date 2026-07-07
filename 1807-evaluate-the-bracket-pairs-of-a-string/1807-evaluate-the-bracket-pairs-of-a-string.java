class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String,String>map = new HashMap<>();
        for(List<String>ds:knowledge){
            map.put(ds.get(0),ds.get(1));
        }
        // System.out.println(map);
        char[]nums = s.toCharArray();

        StringBuilder res = new StringBuilder();

        int i=0;
        while(i<nums.length){
            if(nums[i]=='('){
                StringBuilder key = new StringBuilder();
                i++;
                while(nums[i]!=')' && i<nums.length){
                    key.append(nums[i]);
                    i++;
                }
                i++;
                if(map.containsKey(key.toString())){
                    res.append(map.get(key.toString()));
                }else{
                    res.append("?");
                }
                // System.out.println(key);
            }else{
                res.append(nums[i]);
                i++;
            }
        }
        return res.toString();
        
    }
}