class FrontMiddleBackQueue {
    static class Node{
        Node next;
        Node prev;
        int value;
        public Node(int val){
            this.value = val;
        }
    }
    Node head;
    Node tail;


    public FrontMiddleBackQueue() {
        this.head=null;
        this.tail = null;

    }
    
    public void pushFront(int val) {
        Node node = new Node(val);
        if(head==null){
            head = node;
            tail = node;
            head.prev = null;
            head.next = null;
            tail.next = null;
            tail.prev = null;
            return;
        }
        node.next = head;
        node.prev = null;
        head.prev = node;
        head = node;
    }
    
    public void pushMiddle(int val) {
        Node middle = getMiddle(head);
        Node node = new Node(val);
        if((middle == null) ||(middle.next == null && middle.prev ==null)){
            pushFront(val);
            return;
        }
        node.next = middle;
        node.prev = middle.prev;
        middle.prev = node;
        node.prev.next = node;
    }
    
    public void pushBack(int val) {
        Node node = new Node(val);
        if(head==null){
            pushFront(val);
            return;
        }
        node.prev = tail;
        node.next = null;
        tail.next = node;
        tail = node;
    }
    
    public int popFront() {
        if(head==null)return -1;
        int front = head.value;
        head = head.next;
        if(head==null){
            tail=head;  
        }
        if(head!=null)
        head.prev = null;
        return front;
    }
    
    public int popMiddle() {
        Node middle = getMiddle1(head);
        if(middle==null)return -1;
        int pop = middle.value;
        if (middle.prev == null) {
        return popFront();
    }
        if(middle.next == null && middle.prev==null){
            return popFront();
        }
        if(middle.prev!=null)
        middle.prev.next = middle.next;
        if(middle.next!=null)
        middle.next.prev = middle.prev;
        return pop;
    }
    
    public int popBack() {
        if(tail==null)return -1;
        int pop = tail.value;
        if(tail.prev == null){
            return popFront();
        }
        if(tail.prev!=null)
        tail.prev.next = null;
        tail = tail.prev;
        return pop;

    }
    public Node getMiddle(Node head){
        Node fast = head;
        Node slow = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public Node getMiddle1(Node head){
        
        Node fast = head;
        Node slow = head;
        if(fast!=null)fast = fast.next;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */