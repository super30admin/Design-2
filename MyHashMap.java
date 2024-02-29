//Time complexity all ops o(n)
// Space complexity o(n)

public class MyHashMap {
    class Node{
        int key;
        int value;
        Node next;

        public Node(int key,int value){
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private Node[] storage;

    public MyHashMap(){
        storage = new Node[10000];
    }

    public int hash(int key){
        return key % 10000;
    }

    public Node search(Node head,int key){ //search value based on key
        Node prev = null;
        Node curr = head;
        while(curr != null && curr.key != key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    public void put(int key,int value){
        int idx = hash(key);
        if(storage[idx] == null){ //check if ll exists
            storage[idx] = new Node(-1, -1); // dummy node
        }

        Node prev = search(storage[idx], key);
        if(prev.next == null){ // new node at end of list
            prev.next = new Node(key, value);
        }
        else{
            prev.next.value = value;
        }
    }

    public int get(int key) {
        int idx = hash(key);
        if(storage[idx] == null){
            return -1;
        }
        Node prev = search(storage[idx], key);
        if(prev.next == null){
            return -1;
        }
        return prev.next.value;
    }

    public void remove(int key) {
        int idx = hash(key);
        if(storage[idx] == null){
            return ;
        }
        Node prev = search(storage[idx], key);
        if(prev.next == null){ // no value found
            return;
        } 
        if(prev.next.key == key){
            Node current = prev.next;
            prev.next = current.next;
        }
    }

    

    public static void main(String[] args) {
        MyHashMap m = new MyHashMap();
        m.put(2, 10);
        m.put(10002, 20);
        m.put(2, 30);
        m.get(2);
        m.remove(2);
    }
}
