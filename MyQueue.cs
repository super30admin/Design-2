public class MyQueue {

    Stack<int> inStack;
    Stack<int> outStack;

    public MyQueue() {
        this.inStack = new Stack<int>();
        this.outStack = new Stack<int>();
    }
    
    public void Push(int x) {
        this.inStack.Push(x);
    }
    
    public int Pop() {
        Peek();
        return outStack.Pop();       
    }
    
    public int Peek() {
        if(outStack.Count == 0) {
            while(inStack.Count != 0) {
                outStack.Push(inStack.Pop()); 
            }
        }

        return outStack.Peek();
        
    }
    
    public bool Empty() {
        return inStack.Count == 0 && outStack.Count == 0;
    }
}