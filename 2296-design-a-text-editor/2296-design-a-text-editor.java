class TextEditor {
    Stack<Character>left;
    Stack<Character>right;

    public TextEditor() {
        this.left = new Stack<>();
        this.right = new Stack<>();
    }
    
    public void addText(String text) {
        char[]nums = text.toCharArray();
        for(int i=0;i<nums.length;i++){
            left.push(nums[i]);
        }
    }
    
    public int deleteText(int k) {
        int cnt=0;
        while(!left.isEmpty() && k-->0){
            cnt++;
            left.pop();
        }
        return cnt;
    }
    
    public String cursorLeft(int k) {
        while(!left.isEmpty() && k-->0){
            right.push(left.peek());
            left.pop();
        }
        int min = Math.min(10,left.size());
        int temp = min;
        StringBuilder res = new StringBuilder();
        while(!left.isEmpty() && temp-->0){
            res.append(left.peek());
            right.push(left.peek());
            left.pop();
        }
        temp=min;
        while(!right.isEmpty() && temp-->0){
            left.push(right.pop());
        }
        return res.reverse().toString();
    }
    
    public String cursorRight(int k) {
        while(!right.isEmpty() && k-->0){
            left.push(right.pop());
        }
        int min = Math.min(10,left.size());
        int temp = min;
        StringBuilder res = new StringBuilder();
        while(!left.isEmpty() && temp-->0){
            res.append(left.peek());
            right.push(left.peek());
            left.pop();
        }
        temp=min;
        while(!right.isEmpty() && temp-->0){
            left.push(right.pop());
        }
        return res.reverse().toString();

    }
}

/**
 * Your TextEditor object will be instantiated and called as such:
 * TextEditor obj = new TextEditor();
 * obj.addText(text);
 * int param_2 = obj.deleteText(k);
 * String param_3 = obj.cursorLeft(k);
 * String param_4 = obj.cursorRight(k);
 */