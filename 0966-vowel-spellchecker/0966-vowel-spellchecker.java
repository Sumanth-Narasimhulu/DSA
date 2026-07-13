class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        HashMap<String, List<String>> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        HashMap<String, String> v = new HashMap<>();

        for (String word : wordlist) {
            char[] c = word.toLowerCase().toCharArray();

            for (int i = 0; i < c.length; i++) {
                if (c[i] == 'a' || c[i] == 'e' || c[i] == 'i' || c[i] == 'o' || c[i] == 'u') {
                    c[i] = '*';
                }
            }

            String key = new String(c);

            if (!v.containsKey(key)) {
                v.put(key, word);
            }
        }

        for (String word : wordlist) {
            String lowerCase = word.toLowerCase();
            set.add(word);

            if (map.containsKey(lowerCase)) {
                List<String> ds = map.get(lowerCase);
                ds.add(word);
                map.put(lowerCase, ds);
            } else {
                List<String> ds = new ArrayList<>();
                ds.add(word);
                map.put(lowerCase, ds);
            }
        }

        int n = queries.length;
        String[] res = new String[n];
        int ind = 0;

        for (String q : queries) {
            String lowerCase = q.toLowerCase();

            if (set.contains(q)) {
                res[ind++] = q;
            } else if (map.containsKey(lowerCase)) {
                res[ind++] = map.get(lowerCase).get(0);
            } else {
                String s = vowelsCheck(q, v);
                res[ind++] = s;
            }
        }

        return res;
    }

    public String vowelsCheck(String q, HashMap<String, String> v) {
        char[] qa = q.toLowerCase().toCharArray();

        for (int i = 0; i < qa.length; i++) {
            if (qa[i] == 'a' || qa[i] == 'e' || qa[i] == 'i' || qa[i] == 'o' || qa[i] == 'u') {
                qa[i] = '*';
            }
        }

        String key = new String(qa);

        if (v.containsKey(key)) {
            return v.get(key);
        }

        return "";
    }
}
