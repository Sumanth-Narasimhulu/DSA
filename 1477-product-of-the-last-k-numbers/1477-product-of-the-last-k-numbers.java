class ProductOfNumbers {
    List<Integer>prefix;
    int size;


    public ProductOfNumbers() {
        prefix = new ArrayList<>();
        this.size=0;
        prefix.add(1);
        
    }
    
    public void add(int num) {
        if(num==0){
            prefix = new ArrayList<>();
            size=0;
            prefix.add(1);
        }else{
            prefix.add(prefix.get(size)*num);
            size++;
        }
        
    }
    
    public int getProduct(int k) {
        if(k>size)return 0;
        return (
            prefix.get(size)/prefix.get(size-k)
        );
        
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */