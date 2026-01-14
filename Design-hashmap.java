class MyHashMap {
    class Node{
        int key;
        int val;
        Node next;
        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    public Node[] storage; // we are keeping array of nodes

    private int hash(int key){
        return key% 10000;
    }

    public MyHashMap() {
        this.storage = new Node[10000]; //we do it 10,000 instead of 10,000
    }

    private Node find(Node head, int key){
        Node prev = null;
        Node curr = head;
        while(curr != null && curr.key != key){ //for iteration of linkedlist
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    public void put(int key, int value) {
        int idx = hash(key);
        if(storage[idx] == null){ // there is no element, initialize a dummy node
            storage[idx] = new Node(-1,-1);
        }
        Node prev = find(storage[idx], key);
        //if curr key already exists in list
        if(prev.next != null)
            prev.next.val = value;
            //else create a fresh node
        else
            prev.next = new Node(key, value);

    }

    public int get(int key) {
        int idx = hash(key);
        if(storage[idx] == null){ //if it is not initialized only then nothing is there
            return -1;
        }
        Node prev = find(storage[idx], key);
        if(prev.next!=null){ //curr key exists
            return prev.next.val;
        }
        return -1;
    }

    public void remove(int key) {
        int idx = hash(key);
        if(storage[idx] == null){ // there is no element simply return
            return;
        }
        Node prev = find(storage[idx], key);
        if(prev.next==null) return; //curr doest not exist then simple return
        //to delete in middle
        Node curr = prev.next;
        prev.next = prev.next.next;
        curr.next = null;

    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */