class RangeFreqQuery {
    HashMap<Integer,List<Integer>>map;
    public RangeFreqQuery(int[] arr) {
        this.map= new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(!map.containsKey(arr[i])){
                List<Integer>ds = new ArrayList<>();
                ds.add(i);
                map.put(arr[i],ds);

            }else{
                List<Integer>ds = map.get(arr[i]);
                ds.add(i);
                map.put(arr[i],ds);
            }
        }
    }
    
    public int query(int left, int right, int value) {
        if(!map.containsKey(value))return 0;
        int lowerBound = lowerBound(left,right,value);
        if(lowerBound == -1)return 0;
        int upperBound = upperBound(left,right,value);
        if(upperBound == -1)return 0;
        return upperBound-lowerBound+1;
    }
    public int lowerBound(int left,int right,int value){
        List<Integer>ds = map.get(value);
        int low = 0;
        int high = ds.size()-1;
        int res=-1;
        while(low<=high){
            int mid = (low+(high-low)/2);
            if(ds.get(mid)>=left){
                res = mid;
                high = mid-1;
            }else low = mid+1;
        }
        return res;
    }
    public int upperBound(int left,int right,int value){
        List<Integer>ds = map.get(value);
        int low=0;
        int high = ds.size()-1;
        int res=-1;
        while(low<=high){
            int mid = (low+(high-low)/2);
            if(ds.get(mid)<=right){
                low = mid+1;
                res = mid;
            }else high = mid-1;
        }
        return res;
    }
}

/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * RangeFreqQuery obj = new RangeFreqQuery(arr);
 * int param_1 = obj.query(left,right,value);
 */