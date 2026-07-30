class LRUCache {
    static class Node{
        Node next;
        Node prev;
        int key;
        int val;
        public Node(int key,int val){
            this.key = key;
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }
    Node head;
    Node tail;
    HashMap<Integer,Node>map;
    int size;

    public LRUCache(int capacity) {
        this.size = capacity;
        this.map = new HashMap<>();
        this.head = new Node(-1,-1);
        this.tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key))return -1;
        Node node = map.get(key);
        delete(node);
        insert(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        Node node = new Node(key,value);
        if(map.containsKey(key)){
            Node temp = map.get(key);
            delete(temp);
            map.remove(key);
        }else if(map.size()>=size){
            Node temp = tail.prev;
            delete(temp);
            map.remove(temp.key);
        }
        insert(node);
        map.put(key,node);
    }
    public void insert(Node node){
        head.next.prev = node;
        node.next = head.next;
        node.prev = head;
        head.next = node;
    }
    public void delete(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev; 
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */