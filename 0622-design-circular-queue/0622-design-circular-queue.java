class MyCircularQueue {
    int capacity;
    int front,rear,size;
    int[]q;

    public MyCircularQueue(int k) {
        this.q = new int[k];
        this.front=0;
        this.rear =0;
        this.capacity=k;
        this.size=0;
    }
    
    public boolean enQueue(int value) {
        if(isFull())return false;
        q[rear]=value;
        rear = (rear+1)%capacity;
        size++;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty())return false;
        front = (front+1)%capacity;
        size--;
        return true;

    }
    
    public int Front() {
        if(isEmpty())return -1;
        return q[front];
    }
    
    public int Rear() {
        if(isEmpty())return -1;
        return q[(rear-1+capacity)%capacity];
    }
    
    public boolean isEmpty() {
        return size==0;
    }
    
    public boolean isFull() {
        return size==capacity;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */