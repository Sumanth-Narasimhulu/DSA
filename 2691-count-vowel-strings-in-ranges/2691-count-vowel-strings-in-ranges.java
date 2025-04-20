class Solution {
    Set<Character> set = new HashSet<>();

    public boolean isMeets(int j, String s) {
        return (set.contains(s.charAt(0)) && set.contains(s.charAt(j)));
    }

    public int[] vowelStrings(String[] words, int[][] queries) {
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int n = words.length;
        int[] prefixSum = new int[n];
        if (isMeets(words[0].length() - 1, words[0])) {
            prefixSum[0] = 1;
        }
        for (int i = 1; i < n; i++) {
            if (isMeets(words[i].length() - 1, words[i])) {
                prefixSum[i] = prefixSum[i - 1] + 1;
            } else {
                prefixSum[i] = prefixSum[i - 1];
            }
        }
        int[] res = new int[queries.length];
        // int ind = 0;
        for (int k = 0; k < queries.length; k++) {
            int l = queries[k][0], r = queries[k][1];
            if (l == 0) {
                res[k] = prefixSum[r];
            } else {
                res[k] = prefixSum[r] - prefixSum[l - 1];
            }
        }

        return res;

    }
}