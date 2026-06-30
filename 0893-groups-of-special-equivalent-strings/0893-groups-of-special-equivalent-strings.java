class Solution {
    public int numSpecialEquivGroups(String[] words) {
        Set<String>set = new HashSet<>();
        int n = words.length;
        for(int i=0;i<n;i++){
            int len = words[i].length();
            char[]even = new char[(len+1)/2];
            char[]odd = new char[len/2];
            char[]nums = words[i].toCharArray();
            int ei=0;
            int oi=0;
            for(int j=0;j<nums.length;j++){
                if(j%2==0)even[ei++]=nums[j];
                else odd[oi++]=nums[j];
            }
            StringBuilder sb = new StringBuilder();
            Arrays.sort(even);
            Arrays.sort(odd);
            String es = new String(even);
            String os = new String(odd);
            
            sb.append(es).append(",").append(os);
            set.add(sb.toString());
        }
        return set.size();

        
    }
}
// cdab. cdab
// ac bd
// ac bd
// abcd.  cdab
// 0123.  0123

// abcd
// even  odd
// a c.  b d
// 0 2.  1 3
// sort them already in sorted

// cdab
// even   odd
// c a    d b
// sort them
// a c.   b d

// check even and odd indexes letters are equal in both 