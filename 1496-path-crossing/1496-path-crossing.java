class Solution {
    public boolean isPathCrossing(String path) {
        Set<String>set = new HashSet<>();
        char[]nums = path.toCharArray();
        int n = nums.length;
        int row=0;
        int col=0;
        StringBuilder cord = new StringBuilder();
        cord.append(String.valueOf(row)).append(",").append(String.valueOf(col));
        set.add(cord.toString());
        for(char c:nums){
            if(c=='N'){
                row-=1;

            }else if(c=='E'){
                col+=1;
            }else if(c=='S'){
                row+=1;
            }else{
                col-=1;
            }
            StringBuilder curr = new StringBuilder();
            curr.append(String.valueOf(row)).append(",").append(String.valueOf(col));
            // System.out.println(set);
            if(set.contains(curr.toString()))return true;
            set.add(curr.toString());
            // System.out.println("====");
            // System.out.println(set);
        }

        return false;
    }
}