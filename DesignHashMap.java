class MyHashMap {

    class Node {
        int key;
        int value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private Node[] storage;


    public MyHashMap() {
        this.storage = new Node[10000];
    }

    private int hash(int key) {
        return key % 10000;
    }


    private Node find(Node head, int key) {

        Node curr = head;
        Node prev = null;

        while(curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    
    public void put(int key, int value) {
        
        int idx = hash(key); 

        if (storage[idx] == null) {
            // initialzie with dummy node
            storage[idx] = new Node(-1,-1); // dummy
        }

        Node prev = find(storage[idx], key);

        if(prev.next != null) {
            prev.next.value = value;
        }
        else {
            Node newNode = new Node(key,value);
            prev.next = newNode;
        }    
    }

            
    
    public int get(int key) {
        
        int idx = hash(key);

        if(storage[idx] == null) {
            return -1;
        }
        else {
            Node prev = find(storage[idx],key);
            Node curr = prev.next;
            while (curr != null) {
                if(curr.key == key) {
                    return curr.value;
                }
                curr = curr.next;
            }
            return -1;
        }
    }
    
    public void remove(int key) {
        
        int idx = hash(key);
        if(storage[idx] == null) {
            return ;
        }
        Node prev = find(storage[idx], key);

       if(prev.next == null) {
        return ;
       }

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