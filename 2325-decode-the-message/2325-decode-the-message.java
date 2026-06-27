class Solution {
    public String decodeMessage(String key, String message) {
        char c ='a';

        char[]nums = key.toCharArray();

        Set<Character>set = new HashSet<>();
        HashMap<Character,Character>map = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            if(nums[i]==' ' || set.contains(nums[i]))continue;
            map.put(nums[i],c);
            c++;
            set.add(nums[i]);
        }

        StringBuilder res = new StringBuilder();

        char[]m = message.toCharArray();
        for(int i=0;i<m.length;i++){
            if(m[i]==' '){
                res.append(" ");
                continue;
            }
            res.append(map.get(m[i]));
        }
        return res.toString();
    }
}