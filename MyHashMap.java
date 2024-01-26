// Time Complexity :
// put() : O(100) : constant : O(1)
// get() : O(100) : constant : O(1)
// remove() : O(100) : constant : O(1)
// search() : O(100) : constant : O(1)

// Space Complexity :
// put() : O(1)
// get() : O(1)
// remove() : O(1)
// search() : O(1)

// Constraints:
// 0 <= key, value <= 10^6
// At most 104 calls will be made to put, get, and remove.


import org.w3c.dom.Node;

class MyHashMap {
    class Node {
        private int key;
        private int value;
        private Node next;
         public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int primaryStorage;
    private int secondaryStorage;

    private Node[] storage;


    public MyHashMap() {
        this.primaryStorage=10000;
        this.secondaryStorage=100;
        this.storage = new Node[primaryStorage];
    }

    public int myHash(int key){
        return key%10000;
    }

    public Node search(Node head, int key) {
        Node prev = null;
        Node curr = head;

        while(curr != null && curr.key != key){
            prev = curr;
            curr = curr.next;
        }
        return prev;

    }
    public void put(int key, int value) {
        int primaryIndex = myHash(key);
        if(storage[primaryIndex] == null){
            storage[primaryIndex] = new Node(-1, -1); //Insertion of dummy node at the beginning
        }

        Node prev = search(storage[primaryIndex],key);

        if(prev.next == null){
            prev.next = new Node(key,value); //first node insertion in nested LinkedList
        }else{
            prev.next.value = value; //key exists and replaces the value
        }
    }

    public int get(int key) {
        int primaryIndex = myHash(key);
        if(storage[primaryIndex] == null) return -1;

        Node prev = search(storage[primaryIndex], key);
        if(prev.next == null) return -1;

        return prev.next.value;

    }

    public void remove(int key) {
        int primaryIndex = myHash(key);
        if(storage[primaryIndex] == null) return;

        Node prev = search(storage[primaryIndex], key);
        if(prev.next == null) return;

        prev.next = prev.next.next;
    }

    public static void main(String[] args) {
        MyHashMap obj = new MyHashMap();
         obj.put(key,value);
         int param_2 = obj.get(key);
         obj.remove(key);
    }
}