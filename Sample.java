//      1. Implement Queue using Stack

// Time Complexity : O(n) for pop() and peek(), O(1) for push
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class MyQueue {

    Stack<Integer> inStack;
    Stack<Integer> outStack;

    public MyQueue() {
        inStack = new Stack();
        outStack = new Stack();
    }
    
    public void push(int x) {
        inStack.push(x);
    }
    
    public int pop() {
        if(outStack.isEmpty()){
            while(!inStack.isEmpty())
                outStack.push(inStack.pop());
        }
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


// Your code here along with comments explaining your approach

//      2. Design HashMap

// Time Complexity : O(n) for pop() and peek(), O(1) for push
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class MyHashMap {

    private class Node{
        int key;
        int value;

        Node(int key, int value){
            this.key = key;
            this.value = value;
        }

    }

    private int n; // n - Nodes

    private int N; // N - Number of buckets

    private LinkedList<Node> buckets[]; // N - buckets.length
    

    public MyHashMap() {
        this.N = 4;
        this.buckets = new LinkedList[N];
        for(int i =0; i < N ; i++){
            this.buckets[i] = new LinkedList<>();
        }

    }

    private int hashFunction(Integer key){
        int bi = key.hashCode();
        return Math.abs(bi)%N;
    }

    private int searchInLL(int key, int bi){
        LinkedList<Node> ll = buckets[bi];
        for(int i =0; i < ll.size(); i++){
            if(ll.get(i).key==key)
                return i;
        }
        return -1;
    }

    private void rehash(){
        LinkedList<Node> oldBucket[] = buckets;
        N = N*2;
        buckets = new LinkedList[N*2];

        for(int i = 0; i < N*2 ; i++){
            buckets[i] = new LinkedList<>();
        }

        for(int i =0; i < oldBucket.length ; i++){
            LinkedList<Node> ll = oldBucket[i];
            for(int j =0; j < ll.size(); j++){
                Node node = ll.get(j);
                put(node.key,node.value);
            }

        }
    }

    
    public void put(int key, int value) {
        
        int bi = hashFunction(key);
        int di = searchInLL(key,bi); // di = -1;

        if(di==-1){ // key doesnt exist
            buckets[bi].add(new Node(key,value));
            n++;
        }
        else{ // if key exist in bi bucket
            Node node = buckets[bi].get(di);
            node.value = value;
        }

        double lambda = (double)(n/N);

        if(lambda > 2.0) // if we need to optimize the Put operation
            rehash();


    }
    
    public int get(int key) {
        int bi = hashFunction(key);
        int di = searchInLL(key,bi);

        if(di == -1)
            return -1;
        else{
            Node node = buckets[bi].get(di);
            return node.value;
        }
    }
    
    public void remove(int key) {

        int bi = hashFunction(key);
        int di = searchInLL(key,bi);

        if(di == -1)
            return;
        else{
            Node node = buckets[bi].remove(di);
            n--;
            return;
        }
        
    }
}
