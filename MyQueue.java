
//  TC.    push pop(amortized) peek empty all are 0(1)

public class MyQueue {
    
    private Stack<Integer> One;
    private Stack<Integer> Two;

    public MyQueue() {
        One= new Stack<>();
        Two= new Stack<>();
    }
    
    public void push(int x) {
        One.push(x);
    }
    
    private void transfer(){   // we will use this function in popping and getting peek because both these operations require us to transfer the elements to the second stack if it is empty
        if(Two.isEmpty()){
            while(!One.isEmpty()){
                Two.push(One.pop());
            }
        }
    }
    
    public int pop() {
        
        int element= peek(); // we have called peek so we have already checked if stack Two is empty and Full stacks r empty and then transfered too 
        if(element!=-1){   // if it is not empty
        return Two.pop();}
        return element;
        
    }
    
    public int peek() {
        if(!empty()){    // no need to check if it is empty because in question it is mentioned all call to pop and peek are valid. But for code reusability lets check here and return a value which can be used by pop method.
            transfer();
            return Two.peek();
        }
        return -1;
        
    }
    
    public boolean empty() {
        // if(One.isEmpty() && Two.isEmpty()){
        //     return true;
        // }
        // return false;
        return(One.isEmpty() && Two.isEmpty());
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