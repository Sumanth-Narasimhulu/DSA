class Solution {
    public int maximumSetSize(int[] nums1, int[] nums2) {
        // nums1 lo ni unique numbers those which are not in nums2
        HashSet<Integer>set = new HashSet<>();
        HashSet<Integer>nums1Set = new HashSet<>();
        for(int i=0;i<nums1.length;i++){
            set.add(nums1[i]);
            nums1Set.add(nums1[i]);
        }
        HashSet<Integer>common = new HashSet<>();

    
        
        for(int i=0;i<nums2.length;i++){
            if(set.contains(nums2[i]) && !set.isEmpty()){
                set.remove(nums2[i]);
            }
            if(nums1Set.contains(nums2[i])){
                common.add(nums2[i]);
            }
        }
        int set1size = set.size();
        // System.out.println(set);

        HashSet<Integer>set2 = new HashSet<>();

        for(int i=0;i<nums2.length;i++){
            set2.add(nums2[i]);
        }
        
        for(int i=0;i<nums1.length;i++){
            if(set2.contains(nums1[i]) && !set2.isEmpty()){
                set2.remove(nums1[i]);
            }
        }
        int set2size = set2.size();
        int n = nums1.length;
        // System.out.println(set2);
        

        // System.out.println("common set");
        // System.out.println(common);

        int a = set.size();
        int b = set2.size();
        int c = common.size();

        if(a>n/2)a=n/2;
        if(b>n/2) b = n/2;
        if(a+b<n){
            int rem = n-(a+b);
            if(c>rem)c = rem;
            
        }else{
            c=0;
        }


        return a+b+c;
        
        
    }
}