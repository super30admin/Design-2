//1) Need to identify the bucket size based on  input 
//2) Determine which collision technique you want to implement(linear chaining, BST chaining, Double Hashing)
//Challenges : new learnign - array of Node[] can be created | Basic Linked List Traversal challenges 

class HashMap {
    //Sqrt(input key range) would be the number of = buckets 
    //data structure prefered for this is usually an array because it can be intialized with default values, congiguously allocated for buckets 
    Node[] bucket ;
    int bucketSize;

    class Node{
        int key;
        int val;
        Node next;

        Node(int key,int val){
            this.key = key ;
            this.val = val ;
        }
    }

    public HashMap() {
        bucketSize = 1000;
        bucket = new Node[bucketSize];
    }

    public int hashFunction(int key){
        return key % bucketSize;
    }
    public void put(int key, int value) { // adding an element in a linked list 
    // two option - If I find the key I will update the value  OR I will traverse till the end & insert 
        Node insertNode = new Node(key,value);
        int hashKey = hashFunction(key);
        if(bucket[hashKey] == null) {
            bucket[hashKey] = insertNode;
            return ;
        }
        // else{
            Node prev = null;
            Node current = bucket[hashKey];
            // prev.next = current;
            while(current != null ){
                if(current.key == key) {
                    current.val = value;
                    return ;
                }
                prev = current;
                current = current.next;
            }
            prev.next = insertNode;
        // }
    }
    
    public int get(int key) { // fiding an element in a linked List 
        int hashKey = hashFunction(key);
        // if(bucket[hashKey] == null) return -1;
        // else{
            // Node prev = null;
            Node current = bucket[hashKey];
            // prev.next = current;
            while(current != null){ // normal Single Linked List traversal 
                if(current.key == key ) return current.val;
                current = current.next;
            }
        // }
        return -1;
    }
    
    public void remove(int key) { // deleting an element from a linked list 
        int hashKey = hashFunction(key);
        Node current = bucket[hashKey];
        Node prev = null;
        
        while(current != null ){
            if(current.key == key){
                if(prev == null){
                bucket[hashKey] = current.next;
                }else{
                prev.next = current.next;
                }
                return ;
            }
            prev = current;
            current = current.next;
        }
        // if(current != null) current.next = null;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */