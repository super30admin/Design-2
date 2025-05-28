// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class MyQueue {
    private Stack<Integer> inStack;
    private Stack<Integer> outStack;
    public MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if(empty())
            return -1;
        peek();
        return outStack.pop();
    }

    public int peek() {
        if(outStack.isEmpty()){
            while(!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

}
class MyHashSet {

    private boolean[][] storage;
    int buckets;
    int buckets2;
    private int hash1(int key){
        return key % 1000;
    }
    private int hash2(int key){
        return key/1000;
    }

    public MyHashSet() {
        this.buckets = 1000;
        this.buckets2 = 1000;
        this.storage = new boolean [buckets][];


    }

    public void add(int key) {
        int index = hash1(key);
        int index2 = hash2(key);
        if(storage[index] == null){
            if(index == 0){
                storage[index] = new boolean[buckets2+1];
            }
            else{
                storage[index] = new boolean[buckets2];
            }
        }

        storage[index][index2] = true;

    }



    public void remove(int key) {
        int index = hash1(key);
        int index2 = hash2(key);
        if(storage[index] == null)return;
        storage[index][index2] = false;
    }

    public boolean contains(int key) {
        int index = hash1(key);
        int index2 = hash2(key);
        if (storage[index]== null) return false;
        return storage[index][index2];
    }
}
/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */