class Solution {
    public int countGoodSubstrings(String s) {

        int n = s.length();
        int i = 0;
        int count = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        for (int j = 0; j < n; j++) {

            map.put(s.charAt(j),
                    map.getOrDefault(s.charAt(j), 0) + 1);

            if (j - i + 1 == 3) {

                if (map.size() == 3) {
                    count++;
                }

                char left = s.charAt(i);

                map.put(left, map.get(left) - 1);

                if (map.get(left) == 0) {
                    map.remove(left);
                }

                i++;
            }
        }

        return count;
    }
}