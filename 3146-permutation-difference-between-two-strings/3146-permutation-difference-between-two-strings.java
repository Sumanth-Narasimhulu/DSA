class Solution {
    public int findPermutationDifference(String s, String t) {
        
        HashMap<Character,Integer>sm = new HashMap<>();
        HashMap<Character,Integer>tm = new HashMap<>();
        char[]sc = s.toCharArray();
        char[]tc = t.toCharArray();

        for(int i=0;i<sc.length;i++){
            sm.put(sc[i],i);
        }
        for(int i=0;i<tc.length;i++){
            tm.put(sc[i],i);
        }
        int sum=0;
        for(int i=0;i<sc.length;i++){
            sum+=(Math.abs(
                sm.get(sc[i]) - tm.get(tc[i])
                    )
                );
        }
        return sum;


    }
}