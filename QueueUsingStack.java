//Time complexity: push: O(1) pop :O(n)  peek :O(N) empty: O(1)
//Space complexity: O(N)
class MyQueue {
    Stack<Integer> as;
    Stack<Integer> an;
    public MyQueue() {
        as=new Stack<>();
        an=new Stack<>();
    }
    
    public void push(int x) {
        as.push(x);
    }
    
    public int pop() {
        peek();
        return an.pop();
    }
    
    public int peek() {
        if(an.isEmpty()){
        while(!as.isEmpty()){
        an.push(as.pop());}}
        
        return an.peek();
    }
    
    public boolean empty() {
        return an.isEmpty() && as.isEmpty();
    }
}
