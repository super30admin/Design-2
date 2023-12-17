/*
*approach - use one stack to push data, and when pop operation comes, we transfer data from stck1 o stack2. 
* then we can perofrm the basic Stack operations.
*Time Complexity - peek, pop, push - O(1);
*Space complexity -O(n) --not O(2n) , cause we use two stacks but at a time same data will be available in *only one stack.
*
*/

class MyQueue_2 {
    
    Stack<Integer> st1;
    Stack<Integer> st2;
    

    public MyQueue_2() {
        this.st1 = new Stack<>();
        this.st2 = new Stack<>();
    }
    
    public void push(int x) {
        st1.push(x);
        
    }
    
    public int pop() {
        peek();
        return st2.pop();
    }
    
    public int peek() {
        if(st2.isEmpty())
        {
            while(!st1.isEmpty())
            {
                st2.push(st1.pop());
            }
        }
        return st2.peek();
    }
    
    public boolean empty() {
        return st1.isEmpty() && st2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */