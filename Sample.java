//Problem 1: (https://leetcode.com/problems/implement-queue-using-stacks/)
// Time Complexity : Mentioned in the code
// Space Complexity : Mentioned in the code
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach:  Stack follows Last In first out(LIFO) and Queue follows First In First Out(FIFO)
// Push: When we push an element in stack it goes to the bottom of it, whereas when we push an element in queue it remains in front. So we maintain a variable firstElement to store the value of the first pushed element in the stack. Then we push the new elements.
// Pop: In queue the pop method will return the First element which was pushed in the queue, whereas in a stack it would pop the last pushed element. We will pop all the elements of stack1 and push it into stack2. Now stack 2 will have all the elements of stack1 in reversed order. Then we will perform pop in stack2 if it is not empty.
// Empty: We will check if both the stacks are empty. If they are then it will return true, ekse false.
// Peek: Since Stack2 contains all the elements in the reversed order, we will use peek method on it as it will return the top elemenet. If stack2 is empty then we will return the value stored in the variable firstElement


class MyQueue {
    Stack <Integer> Stack1;
     Stack <Integer> Stack2;
     int firstElement;

    public MyQueue() {
        this.Stack1=new Stack<>();
        this.Stack2=new Stack<>();
        this.firstElement=0;

    }

// Time Complexity : O(1)
// Space Complexity : O(n)
    
    public void push(int x) 
    {
        if(Stack1.empty())
        {
            firstElement=x;
        }
        Stack1.push(x);
    }
    
    //Time Complexity : Amortized: o(1) Worst case: O(n)
    //Space Complexity : O(1)
    public int pop() {
      if(Stack2.isEmpty())
      {
          while(!Stack1.isEmpty())
          {
              Stack2.push(Stack1.pop());
          }
      }
      return Stack2.pop();
        
    }
    
// Time Complexity : O(1)
// Space Complexity : O(1)

    public int peek() {
        if(!Stack2.isEmpty())
        {
            return Stack2.peek();
        }
        return firstElement;       
    }
  
// Time Complexity : O(1)
// Space Complexity : O(1)

    public boolean empty() {
        return Stack1.isEmpty() && Stack2.isEmpty();
        
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





 //Problem 2: Design Hashmap (https://leetcode.com/problems/design-hashmap/)
// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach:  Stack follows Last In first out(LIFO) and Queue follows First In First Out(FIFO)
// Here to avoid collision we are doing linear probing, so we will make the primary array of nodes of the linked list. Before inserting the node we need to check if it already exists or not
// for put, remove or get function we need to first search for the element, so we create a helper function. We keep two pointers prev and curr for searching. then we return prev key to all the functions, so they can access the current key.


 class MyHashMap {
    class Node{
        int key,val;
        Node next;
        public Node(int key, int val){
            this.key=key;
            this.val=val;
        }
    }
    
    Node [] storage;
    int buckets;
        public MyHashMap() {
            this.buckets=10000;
            this.storage=new Node[buckets];
        }
    
        private int hashIdx(int key)
        {
            return key%buckets;
        }
        
        private Node find(Node head, int key){
            Node prev=null;
            Node curr=head;
            while(curr!=null && curr.key!=key)
            {
                prev=curr;
                curr=curr.next;
            }
            return prev;
        }
    
    
    
        public void put(int key, int value) {
            int bucket=hashIdx(key);
    
            //if there is no node we add a dummy node
    
            if(storage[bucket]==null)
            {
                storage[bucket]=new Node(-1,-1);
            }
    
            //find prev
            Node prev=find(storage[bucket],key);
            //if the current node is null
            if(prev.next==null)
            {
                prev.next=new Node(key,value);
            }
            //if the current node is not null
            else
            {
                prev.next.val=value;
            }
    
        }
    
        
        
        public int get(int key) {
            int bucket=hashIdx(key);
            //if there is no linked list
            if(storage[bucket]==null) return -1;
    
            // find the prev of the key
            Node prev=find(storage[bucket],key);
    
            //if the curr value is null
            if(prev.next==null) return -1;
            return prev.next.val;     
        }
    
        
        public void remove(int key) {
            int bucket=hashIdx(key);
            if(storage[bucket]==null) return;
    
            Node prev=find(storage[bucket],key);
            if(prev.next==null) return;
            else
            prev.next=prev.next.next;
            
        }
    }
    
    /**
     * Your MyHashMap object will be instantiated and called as such:
     * MyHashMap obj = new MyHashMap();
     * obj.put(key,value);
     * int param_2 = obj.get(key);
     * obj.remove(key);
     */