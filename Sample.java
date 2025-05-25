// Time Complexity :
// push : o(n)
// pop: o(1)
// peek; o(1)
//empty: o(1)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/*
 I'm using two stacks to implement the queue. It can be done in two ways. Either make the push operation sotly or pop costly
  I'm moving all the elements to a new stack before pushing , pushing the element and moving back the elements.
  This reverses the elements and implements FIFO. 
  Now the queue is implemented
 */
class MyQueue {
    int size;
    Stack<Integer> st1;
    Stack<Integer> st2;
    
    public MyQueue() {
        size = 0;
        st1 = new Stack<>();
        st2 = new Stack<>();
    }
    
    public void push(int x) {
        
        while(!st1.isEmpty())
        {
            st2.push(st1.pop());
        }
        
        st1.push(x);
        while(!st2.isEmpty())
        {
            st1.push(st2.pop());
        }
        size++;
    }
    
    public int pop() {
        if(empty())
        {
            return -1;
        }
        else
        {
            int x = st1.pop();
            size--;
             return x;
        }
        
       
    }
    
    public int peek() {
        if(empty())
        {
            return -1;
        }
        else
        {
            int x = st1.peek();
            return x;
        }
        
    }
    
    public boolean empty() {
        return size == 0;
    }
}




// Time Complexity :
// put : o(n)
// get: o(1)
// remove; o(1)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/*
I have used two arraya sof size 10^6+1 . one to store values and the others to store if it is pesent or not. Instead of this 
we can also insert -1 in the array and send the value directly
*/
class MyHashMap {
    int [] vals;
    boolean [] has;
    public MyHashMap() {
        vals = new int[(int)Math.pow(10,6)+1];
        has = new boolean[(int)Math.pow(10,6)+1];
    }
    
    public void put(int key, int value) {
        vals[key] = value;
        has[key] = true;
    }
    
    public int get(int key) {
        if(has[key])
        return vals[key];
        else
        return -1;
    }
    
    public void remove(int key) {
        has[key] = false;
    }
}

