class MyHashMap {
    static class Pair{
        int key,val;
        public Pair(int key,int val){
            this.key = key;
            this.val = val;
        }
    }
    List<LinkedList<Pair>>map;
    int size;
    public MyHashMap() {
        size = 15000;
        map = new ArrayList<>(size);
        for(int i=0;i<size;i++){
            map.add(new LinkedList<>());
        }
    }
    public int key(int key){
        return key%size;
    }
    
    public void put(int key, int value) {
        int ind = key(key);
        LinkedList<Pair>ds = map.get(ind);
        boolean flag = false;
        for(Pair p:ds){
            if(p.key == key){
                p.val = value;
                flag = true;
                break;
            }
        }
        if(!flag){
            Pair p = new Pair(key,value);
            ds.add(p);
        }
    }
    
    public int get(int key) {
        int ind = key(key);
        LinkedList<Pair>ds = map.get(ind);
        for(Pair p:ds){
            if(p.key == key)return p.val;
        }
        return -1;
    }
    
    public void remove(int key) {
        int ind = key(key);
        LinkedList<Pair>ds = map.get(ind);
        for(int i=0;i<ds.size();i++){
            if(ds.get(i).key==key){
                ds.remove(i);
                break;
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */