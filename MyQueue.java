import java.util.Stack;

// Time Complexity : Amortized O(1) worst case O(n) for pop() and peek()
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Earlier I used a different approch
// where i was transferring elements from one stack to another at every push


// Your code here along with comments explaining your approach
public class MyQueue {
    Stack<Integer> inSt;
    Stack<Integer> outSt;
    public MyQueue() {
        inSt = new Stack<>();
        outSt = new Stack<>();
    }

    public void push(int x) { //O(1)
        inSt.push(x);
    }

    public int pop() {
        if(empty()) return -1;
        peek();
        return outSt.pop();

    }

    public int peek() {
        if(empty()) return -1;
        if(!outSt.isEmpty()){
            return outSt.peek();
        }
        while(!inSt.isEmpty()){
            outSt.push(inSt.pop());
        }
        return outSt.peek();

    }

    public boolean empty() {
        return inSt.isEmpty() && outSt.isEmpty();
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
//public class MyQueue {
//    Stack<Integer> st;
//    Stack<Integer> st1;
//    public MyQueue() {
//        st = new Stack<>();
//        st1 = new Stack<>();
//    }
//
//    public void push(int x) {
//        while(!st.isEmpty())
//            st1.push(st.pop());
//        st.push(x);
//        while(!st1.isEmpty())
//            st.push(st1.pop());
//
//    }
//
//    public int pop() {
//        return st.pop();
//
//    }
//
//    public int peek() {
//        return st.peek();
//
//    }
//
//    public boolean empty() {
//        return st.isEmpty();
//    }
//}
