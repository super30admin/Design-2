// Time Complexity : Best Case - get():O(1), put():O(1), remove():O(1),    Average Case - get():O(n), put():O(n), remove():O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
* It is implemented using Linear Chaining approach. findPrev() returns the last node or Node before the matching key. For put(),
* we will get the hash and get the Node using getPrev() and link the new node to it. For remove also we will use a similar
* approach, we'll use prev Node and make to point to next.next node. For get also we'll use the same approach.
*/
class MyHashMap {

    int size;
    Node[] hashMap;

    class Node {
        int key;
        int value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public MyHashMap() {
        this.size = 10000;
        hashMap = new Node[size];
    }

    private int getHash(int key) {
        return key % size;
    }

    public void put(int key, int value) {

        int hash = getHash(key);

        // If the LinkedList is empty, initialize it with dummy node
        if(hashMap[hash] == null)
            hashMap[hash] = new Node(-1,-1);

        Node prev = findPrev(hashMap[hash], key);

        //Adding new node to the last node
        if(prev.next == null)
            prev.next = new Node(key, value);
        //Key already exists, replacing it with new value
        else {
            prev.next.key = key;
            prev.next.value = value;
        }
    }

    public int get(int key) {

        int hash = getHash(key);

        if(hashMap[hash] == null)
            return -1;

        Node prev = findPrev(hashMap[hash], key);

        if(prev.next != null)
            return prev.next.value;

        return -1;
    }

    public void remove(int key) {

        int hash = getHash(key);

        if(hashMap[hash] != null) {
            Node prev = findPrev(hashMap[hash], key);

            if(prev.next != null) {
                prev.next = prev.next.next;
            }
        }
    }

    //iterates over the linkedlist and return the last node or node previous to the node matching the key
    private Node findPrev(Node node, int key) {

        while(node.next != null && node.next.key != key) {
            node = node.next;
        }

        return node;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */