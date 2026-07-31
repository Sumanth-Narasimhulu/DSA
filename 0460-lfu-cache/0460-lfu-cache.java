class LFUCache {
    class Node{
        int key,val,freq;
        Node next;
        Node prev;
        public Node(int key,int val){
            this.key = key;
            this.val = val;
            this.freq=1;
        }
    }
    class DoublyLinkedList{
        Node head;
        Node tail;
        int size;
        public DoublyLinkedList(){
            this.size =0;
            this.head = new Node(-1,-1);
            this.tail = new Node(-1,-1);
            this.head.next = tail;
            this.tail.prev = head;
        }

        public void addFirst(Node node){
            head.next.prev = node;
            node.next = head.next;
            node.prev = head;
            head.next = node;
            size++;
        }
        public void remove(Node node){
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }
        Node removeLast(){
            if(size == 0){
                return null;
            }
            Node lastOne = tail.prev;
            remove(tail.prev);
            return lastOne;
        }

    }
    HashMap<Integer,DoublyLinkedList>freqMap;
    HashMap<Integer,Node>nodeMap;
    int size;
    int minFreq;
    int capacity;

    public LFUCache(int capacity) {
       this.size = 0;
        this.freqMap = new HashMap<>();
        this.nodeMap = new HashMap<>();
        this.minFreq=1;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(!nodeMap.containsKey(key))return -1;
        Node node = nodeMap.get(key);
        updateFreq(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        
        if(nodeMap.containsKey(key)){
            Node exist = nodeMap.get(key);
            //int freq = nodeMap.get(key).freq;
            exist.val = value;
            updateFreq(exist);
            return;
        }
        if(size == capacity){
            DoublyLinkedList list = freqMap.get(minFreq);
            Node toRemove = list.removeLast();
            nodeMap.remove(toRemove.key);
            size--;
        }
        Node node = new Node(key,value);
        nodeMap.put(key,node);
        minFreq=1;
        freqMap.putIfAbsent(1,new DoublyLinkedList());
        freqMap.get(1).addFirst(node);
        size++;
    }
    public void updateFreq(Node node){
        int oldFreq = node.freq;
        DoublyLinkedList oldList = freqMap.get(oldFreq);
        oldList.remove(node);
        node.freq++;
        if(minFreq == oldFreq && oldList.size ==0){
            minFreq++;
        }
        freqMap.putIfAbsent(node.freq,new DoublyLinkedList());
        freqMap.get(node.freq).addFirst(node);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */