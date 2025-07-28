class MyHashMap {
    // Map has insert o(1) , search o(1) , remove o(1)
    /* 1. take array of LinkList type , len of array = sqrt(1000000) = 1000 , means max 1000 collision at 1 place
    2. when array node == null means no link list initialised yet
    3. if not null, iterate if not exist then add else update the value
    3. to remove = iterate if node exist remove
    => right index hashKey = key % len
    */


    class Node{
        int key;
        int value;
        Node prev;
        Node next;
        Node head;

        Node( int key , int value ){
            this.key = key;
            this.value = value;
        }
    }

    Node[] arr;
    int len;

    public MyHashMap() {
        len = 1000;
        arr = new Node[len];

    }

    public int hash( int key ){
        return key % len;
    }

    public void put(int key, int value) {
        int index = hash(key);
        if( arr[index] == null ){
            arr[index] = new Node( -1 , -1 );
            arr[index].next =  new Node( key , value );
        }
        else{
            Node head = arr[index];
            Node prev = arr[index];
            Node current = prev.next;
            while( current != null && current.key != key ){
                prev = current;
                current = current.next;

            }
            if( current != null && current.key == key ){
                current.value = value;
                return;
            }
            else{
                prev.next = new Node(key,value);
                return;
            }

        }
    }

    public int get(int key) {
        int index = hash(key);

        if( arr[index] == null ){
            return -1;
        }

        Node head = arr[index];
        Node prev = arr[index];
        Node current = prev.next;

        while( current != null && current.key != key  ){

            prev = current;
            current = current.next;


        }
        if( current != null && current.key == key ){
            return current.value;
        }
        else{
            return -1;
        }

    }

    public void remove(int key) {

        int index = hash(key);

        if( arr[index] != null ){

            Node head = arr[index];
            Node prev = arr[index];
            Node current = prev.next;

            while( current != null && current.key != key ){
                prev = current;
                current = current.next;
            }
            if( current != null && current.key == key ){
                prev.next = current.next;
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