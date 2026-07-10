class Solution {
    public String alphabetBoardPath(String target) {
        HashMap<Character, int[]> map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            //System.out.println();
            int row = i / 5;
            int col = i % 5;
            char ch = (char) ('a' + i);
            //System.out.println((char)('a'+i)+" "+row+" "+col);
            map.put(ch, new int[] { row, col });
        }
        StringBuilder res = new StringBuilder();
        int i = 0;
        int j = 0;

        char[] nums = target.toCharArray();
        for (int k = 0; k < nums.length; k++) {
            char curr = nums[k];
            int[] cord = map.get(curr);
            int tr = cord[0];
            int tc = cord[1];

            while (i > tr) {
                i--;
                res.append('U');
            }

            while (j > tc) {
                j--;
                res.append('L');
            }

            while (i < tr) {
                i++;
                res.append('D');
            }

            while (j < tc) {
                j++;
                res.append('R');
            }

            res.append('!');
            
        }
        return res.toString();
    }
}