class Node {
    int key;
    int value;
    Node next;

    public Node ( int key, int value ) {
        this.key = key;
        this.value = value;
    }
}


class MyHashMap {
    private Node[] map;

    public MyHashMap() {
        map = new Node[1000];
    }

    private int hash( int key ) {
        return key % 1000;
    }

    public void put(int key, int value) {
        int hsh = hash(key);
        Node temp = map[hsh];
        Node node = new Node( key, value );
        if( temp == null ) {
            map[hsh] = node;
        } else {
            Node curr = map[hsh];
            Node t1 = map[hsh];
            while( curr != null ) {
                if( curr.key == key ) {
                    curr.value = value;
                    return;
                }
                t1 = curr;
                curr = curr.next;
            }
            t1.next = node;
        }
    }

    public int get(int key) {
        int hsh = hash(key);
        Node curr = map[hsh];
        while( curr != null ) {
            if( curr.key == key ) {
                return curr.value;
            }
            curr = curr.next;
        }
        return -1;
    }

    public void remove(int key) {
        int hsh = hash(key);
        Node temp = map[hsh];
        if( temp == null ) return;
        if( temp.key == key ) {
            map[hsh] = temp.next;
            temp.next = null;
            return;
        }
        Node curr = map[hsh].next;
        while( curr != null ) {
            if( curr.key == key ) {
                temp.next = curr.next;
                curr.next = null;
                return;
            }
            temp = curr;
            curr = curr.next;
            //temp = temp.next;
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
/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */