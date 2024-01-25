//time complexity - O(n) - In the worst case, when all keys hash to the same index, you might have to traverse the entire linked list at that index.
//Space complexity - O(n)
//linear chaining method- 
//Collision handling is implemented using a linked list at each index in the array. If multiple keys hash to the same index, they are stored in a linked list.
//The search method is used to find the node with the specified key in a linked list. It returns the node preceding the one with the specified key.

class MyHashMap {
    class Node{
        int key;
        int value;
        Node next;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    private Node []storage;

    public MyHashMap() {
        this.storage = new Node[10000];
    }
    private int hash(int key){
        return key%10000;
    }
    public Node search(Node head, int key){
        Node prev = null;
        Node curr = head;
        while(curr != null && curr.key != key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    public void put(int key, int value) {
        int index = hash(key);
        if(storage[index] == null){
            storage[index] = new Node(-1,-1);
        }
        Node prev = search(storage[index], key);
        if(prev.next == null){
            prev.next = new Node(key, value);

        }else{
            prev.next.value = value;

        }
        
    }
    
    public int get(int key) {
        int index = hash(key);
        if(storage[index] == null) return -1;
        Node prev = search(storage[index], key);
        if(prev.next == null) return -1;
        else return prev.next.value;
        
    }
    
    public void remove(int key) {
        int index = hash(key);
        if(storage[index] == null) return;
        Node prev = search(storage[index], key);
        if(prev.next == null) return;
        
        Node temp = prev.next;
        prev.next = prev.next.next;
        temp = null;

        

    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */