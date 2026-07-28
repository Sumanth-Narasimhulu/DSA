class MyHashSet {
    List<LinkedList<Integer>>set;
    int size;
    public MyHashSet() {
        size = 15000;
        set = new ArrayList<>(size);

        for(int i=0;i<size;i++){
            set.add(new LinkedList<>());
        }

    }
    public int key(int key){
        return key%size;
    }
    
    public void add(int key) {
        int k = key(key);
        LinkedList<Integer>ds = set.get(k);
        if(!ds.contains(key))ds.add(key);
    }
    
    public void remove(int key) {
        int k = key(key);
        LinkedList<Integer>ds = set.get(k);
        ds.remove(Integer.valueOf(key));
        
    }
    
    public boolean contains(int key) {
        int k = key(key);
        LinkedList<Integer>ds = set.get(k);
        return ds.contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */