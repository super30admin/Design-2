// Time Complexity : push O(1) and empty O(1), pop and peek O(1) averagely
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this :NO


// Your code here along with comments explaining your approach
// Used 2 stacks. One to push and another one to pop. If popping stack is mpty and a pop is called then all elements from push stack is first moved to pop stack and then pop is called on second stack.
class MyQueue {

    Stack<Integer> s1;
    Stack<Integer> s2;
    public MyQueue() {
        this.s1 = new Stack<>();
        this.s2 = new Stack<>();
    }
    
    public void push(int x) {
            s1.push(x);
    }
    
    public int pop() {
        if(s2.isEmpty()){
            while(s1.size()>0){
                int popingElem = s1.pop();
                s2.push(popingElem);
            }
        }
        return s2.pop();
    }
    
    public int peek() {
        if(s2.isEmpty()){
             while(s1.size()>0){
                int popingElem = s1.pop();
                s2.push(popingElem);
            }           
        }
        return s2.peek();
    }
    
    public boolean empty() {
        if(s1.isEmpty() && s2.isEmpty()){
            return true;
        } 
        return false;
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
// Time Complexity : O(1) except for get and remove where it is O(k) where k is number of items in arraylist.
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this :NO


// Your code here along with comments explaining your approach
// Used double hashing. INorder to keep track of removed indexes keeping an arraylist to track it.
class MyHashMap {

    int [][] storage;
    int buckets;
    int bucketItems;
    ArrayList<Integer> zeroValueTracker;

    public MyHashMap() {
        this.buckets = 1000;
        this.bucketItems = 1000;
        this.storage = new int[buckets][];
        this.zeroValueTracker = new ArrayList<>();
    }
    
    private int hash1(int key){
        return key%buckets;
    }

    private int hash2(int key){
        return key/bucketItems;
    }
    public void put(int key, int value) {
        if(value==0){
            zeroValueTracker.add(key);
        }
        int hash1 = hash1(key);
        int hash2 = hash2(key);
        if(storage[hash1]==null){
            if(hash1==0){
                storage[hash1] = new int[bucketItems+1];
            } else storage[hash1] = new int[bucketItems];
            storage[hash1][hash2] = value;
        } else{
            storage[hash1][hash2] = value;
        }
    }
    
    public int get(int key) {
        int hash1 = hash1(key);
        int hash2 = hash2(key);
        if(storage[hash1]==null){
           return -1;
        } else if (storage[hash1][hash2]==0){
                    if(zeroValueTracker.contains(key)){
                        return storage[hash1][hash2];
                    }
                    return -1;
        } else return storage[hash1][hash2];
    }
    
    public void remove(int key) {
        int hash1 = hash1(key);
        int hash2 = hash2(key);
        if(storage[hash1]!=null){
           
          if (storage[hash1][hash2]==0){
                    if(zeroValueTracker.contains(key)){
                        int ToRemove = zeroValueTracker.indexOf(key);
                        zeroValueTracker.remove(ToRemove);
                    }
        } else storage[hash1][hash2]=0;
    }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
