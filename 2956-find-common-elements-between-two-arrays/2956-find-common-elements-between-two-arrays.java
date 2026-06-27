class Solution {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        HashSet<Integer>set1 = new HashSet<>();
        HashSet<Integer>set2 = new HashSet<>();

        for(int ele:nums1)set1.add(ele);
        for(int ele:nums2)set2.add(ele);
        int cnt1=0;
        for(int i=0;i<nums1.length;i++){
            if(set2.contains(nums1[i]))cnt1++;
        }
        int cnt2=0;
        for(int j=0;j<nums2.length;j++){
            if(set1.contains(nums2[j])){
                cnt2++;
            }
        }
        return new int[]{cnt1,cnt2};
        
    }
}