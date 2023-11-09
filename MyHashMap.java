//Time Complexity - amoritized O(1) for put,get , remove operations
//Space Complexity - O(n) for put,get , remove operations
class MyHashMap {

    int bucketSize ;
    Node[] storage;
    class Node{
        int key;
        int value;
        Node next;

        public Node(int key, int value ){
            this.key = key;
            this.value = value;
        }
    }

    

    public MyHashMap() {
        this.bucketSize = 10000;
        storage = new Node[bucketSize];
    }

    private int getHashValue(int key){
        return key % bucketSize;
    }

    private Node getPrevious(Node head, int key){
        Node prev = null;
        Node curr = head;
        while(curr != null && curr.key != key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    
    public void put(int key, int value) {
        int hashValue = getHashValue(key);
        if(storage[hashValue] == null){
            storage[hashValue] = new Node(-1,-1);
            storage[hashValue].next = new Node(key,value);
        }
        else{
            Node prev = getPrevious(storage[hashValue],key);
            if(prev.next == null){
                //Node not present
                prev.next = new Node(key,value);
            }
            else{
                //Node present, update value
                prev.next.value = value;
            }
        }
    }
    
    public int get(int key) {
        int hashValue = getHashValue(key);
        //No element present
         if(storage[hashValue] == null)
            return -1;
        else{
            Node prev = getPrevious(storage[hashValue],key);
             //Node not present
            if(prev.next == null)
                return -1;
            //Node present, return value
            else
                return prev.next.value;
        }
    }
    
    public void remove(int key) {
        int hashValue = getHashValue(key);
         if(storage[hashValue] != null){
              Node prev = getPrevious(storage[hashValue],key);
              if(prev.next != null){
                  prev.next = prev.next.next;
              }
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