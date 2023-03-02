class HashMap {

    class Node{
        int key,val;
        Node next;
        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    private Node[] storage;

    public HashMap() {
        this.storage = new Node[10000];
    }

    private int hash1(int key) {
        return key%1000;
    }

    private Node search(Node head, int key) {
        Node prev = head;
        Node curr = head.next;
        while(curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }

        return prev;
    }

    //O(1)
    public void put(int key, int value) {
        int indx = hash1(key);
        if(storage[indx] == null){
            storage[indx] = new Node(-1,-1);// create a dummy node
        }
        //check if key already exists
        Node prev = search(storage[indx], key);
        if(prev.next == null) {
            prev.next = new Node(key, value);
        } else {
            prev.next.val = value;
        }
    }

    //O(1)
    public int get(int key) {
        int indx = hash1(key);
        if(storage[indx] == null) return -1;
        Node prev = search(storage[indx], key);
        if(prev.next == null) return -1;
        return prev.next.val;
    }

    //O(1)
    public void remove(int key) {
        int indx = hash1(key);
        if(storage[indx] == null) return;
        Node prev = search(storage[indx], key);
        if(prev.next == null) return;
        prev.next = prev.next.next;
    }
}

