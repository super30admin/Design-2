// Time Complexity : o(1)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


//HashSet Implementation

class MyHashSet {
    private boolean[][] storage;
    public MyHashSet() {
        storage=new boolean[1000][];
    }
    
    public int getBucketIndex(int key){
        return key%1000;
    }
    
    public int getBucketItemIndex(int key){
        return key/1000;
    }
    public void add(int key) {
        int bucket=getBucketIndex(key);
    if(storage[bucket]==null){
        //edge case
        if(bucket==0){
            storage[bucket] = new boolean[1001];
        }else{
            storage[bucket] = new boolean[1000];
        }
    }    
    storage[bucket][getBucketItemIndex(key)]=true;
    }
    
    public void remove(int key) {
          if(storage[getBucketIndex(key)]==null){
              return;
          }
            storage[getBucketIndex(key)][getBucketItemIndex(key)]=false;   
          
    }
    
    public boolean contains(int key) {
        if(storage[getBucketIndex(key)]==null){
            return false;
        }
        return storage[getBucketIndex(key)][getBucketItemIndex(key)];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */


 // Time Complexity : push o(1),pop o(1),peek o(1),empty o(1)
// Space Complexity : push o(n), pop o(n),peek o(1),empty o(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class MyQueue {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    public MyQueue() {
        stack1= new Stack<>();
        stack2= new Stack<>();
    }
    
    public void push(int x) {
          stack1.push(x);
    }
    
    public int pop() {
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }   
        }
        return stack2.pop();
    }
    
    public int peek() {
       if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }   
        }
        return stack2.peek();
    }
    
    public boolean empty() {
         return this.stack1.isEmpty() && this.stack2.isEmpty();
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