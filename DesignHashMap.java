    /*
    Thought process:
    
    We can solve this using Double Hashing technique which is faster in time but consumes more space
    Doing this by Separate Chaining method:
    
    We'll have a array of LinkedList. Need to choose the length of LL in such a way that it is not very
    long as it will be O(N) in finding an element.
    
    So we choose 100 as LL length and 10000 as parent array size
    
    We need a class Node to design as it is a design problem.
    Next, index func to compute index of a given key. Use (hashCode or array length) % nodes.length
    Next, find method, which will help find a given key
    
    Time Complexity:
    All the functions O(1) -> It considers travering only through the linked list who's maximum
    size will be only 100, which can be considered constant.

    Space Complexty:
    O(N)
    */

class MyHashMap {

    //Define LinkList
    class Node{
        int key;
        int val;
        Node next;

        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    // Array of Nodes of size 10000
    Node[] storage;

    public MyHashMap() {
        this.storage = new Node[10000];
    }

    public int hash(int key){
        return key % 10000;
    }

    public Node search(Node head, int key){
        Node prev = head, curr = head;
        while(curr != null && curr.key != key){
            prev = curr; 
            curr = curr.next;
        }
        return prev;
    }
    
    public void put(int key, int value) {
        int index = hash(key);
        if(storage[index] == null){
            //dummy node if that vertical is empty
            storage[index] = new Node(-1, -1);
        }
        Node prev = search(storage[index], key);
        if(prev.next == null)
            prev.next = new Node(key, value);
        prev.next.val = value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = hash(key);
        if(storage[index] == null) return -1;
        Node prev = search(storage[index], key);
        if(prev.next == null)
            return -1;
        return prev.next.val;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = hash(key);
        if(storage[index] == null) return;
        Node prev = search(storage[index], key);
        if(prev.next != null)
            prev.next = prev.next.next;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
