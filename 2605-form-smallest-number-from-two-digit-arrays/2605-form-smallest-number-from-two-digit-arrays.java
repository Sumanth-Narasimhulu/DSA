class Solution {
    public int minNumber(int[] nums1, int[] nums2) {
        //interesection konukkoavali
        // common elements lo minmum return cheyali

        List<Integer>inter = new ArrayList<>();
        Set<Integer>set = new HashSet<>();
        for(int i=0;i<nums1.length;i++){
            set.add(nums1[i]);
        }

        for(int ele:nums2){
            if(set.contains(ele))inter.add(ele);
        }
        int min = 10;
        for(int ele:inter)min = Math.min(min,ele);
        if(inter.size()>0)return min;
        int min1 = 100;
        int min2 = 100;
        for(int ele:nums1)min1 = Math.min(min1,ele);
        for(int ele:nums2)min2 = Math.min(min2,ele);
        StringBuilder res = new StringBuilder();
        StringBuilder res1 = new StringBuilder();
        res.append(min1).append(min2);
        res1.append(min2).append(min1);
        int a = Integer.valueOf(String.valueOf(res));
        int b = Integer.valueOf(String.valueOf(res1));
        return (a<b)?a:b; 

    }
}