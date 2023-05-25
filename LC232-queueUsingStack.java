// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach

/* 
Base DS :
(1) arrar[100] since only 100 calls will be made, max size can go to 100
(2) Singly linked list. selecting this
*/
class MyQueue {

    class Node {
        int val;
        Node next;

        public Node(int data) {
            val = data;
        }
    }

    private Node head; // pop here 
    private Node tail; // push here

    int size;

    public MyQueue() {
        size = 0;
    }
    
    public void push(int x) {
       if (tail == null ) {
           tail = new Node(x);
           head = tail;
        }
       else {
           tail.next = new Node(x);
           tail = tail.next;
       }
       size++;
    }
    
    public int pop() {
        int ret = head.val;
        head = head.next;
        size--;
        
        // if head and tail were at same node, then head move to null then move tail as well
        if (head == null) tail = null; 
        
        return ret;

    }
    
    public int peek() {
        return head.val;
    }
    
    public boolean empty() {
        return size==0;
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