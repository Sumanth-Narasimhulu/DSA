class Solution {
    public String getHint(String secret, String guess) {
       char[]s = secret.toCharArray();
       char[]g = guess.toCharArray();
       int n = s.length;
       int bulls =0;
       for(int i=0;i<n;i++){
        if(s[i]==g[i])
        {
            bulls++;
            s[i]='.';
            g[i]='.';
        }
       }
       HashMap<Character,Integer>gm = new HashMap<>();
       HashMap<Character,Integer>sm = new HashMap<>();
       for(int i=0;i<n;i++){
        if(s[i]!='.'){
            sm.put(s[i],sm.getOrDefault(s[i],0)+1);

        }

        if(g[i]!='.'){
            gm.put(g[i],gm.getOrDefault(g[i],0)+1);
        }

       }
       int cows =0;
       for(Map.Entry<Character,Integer>m:sm.entrySet()){
            char curr = m.getKey();
            if(gm.containsKey(curr)){
                cows+=(Math.min(gm.get(curr),sm.get(curr)));
            }
       }
       return bulls+"A"+cows+"B";
       
    }
}