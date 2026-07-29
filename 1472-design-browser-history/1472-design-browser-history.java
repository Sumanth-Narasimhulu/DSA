class BrowserHistory {
    Stack<String>past;
    Stack<String>future;
    String curr;
    public BrowserHistory(String homepage) {
        this.curr = homepage;
        this.past = new Stack<>();
        past.push(homepage);
        this.future = new Stack<>();
    }
    
    public void visit(String url) {
        curr = url;
        past.push(curr);
        future.clear();
    }
    
    public String back(int steps) {
        while(past.size()>1 && steps-->0){
            curr = past.peek();
            future.push(curr);
            past.pop();
            curr = past.peek();
            
        }
        return curr;
    }
    
    public String forward(int steps) {
        while(!future.isEmpty() && steps-->0){
            curr = future.peek();
            past.push(curr);
            future.pop();
        }
        
        return curr;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */