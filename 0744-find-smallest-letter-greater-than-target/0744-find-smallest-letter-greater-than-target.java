class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int[]let = new int[letters.length];
        for(int i=0;i<letters.length;i++){
            let[i]=(int)letters[i];
        }
        int n = let.length;
        int low = 0;
        int high = n-1;
        int tar = (int)target;
        int ans =-1;
        while(low<=high){
            int mid = (low+high)/2;
           if(let[mid]>tar){
               ans =mid;
               high = mid-1;
           }else{
               low = mid+1;
           }
        }
        if(ans == -1)return letters[0];
        return (char)let[ans];
        
    }
}