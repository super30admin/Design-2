class MyHashMap {

    class Node{
        int key;
        int val;
        Node next;
        public Node(int key, int value)
        {
            this.key=key;
            this.val=value;

        }
    }
    Node[] primary_array;
    int blocks;

    public MyHashMap() {
        this.blocks = 10000;
        this.primary_array = new Node[blocks];
    }

    public void put(int key, int value) {
        int blocks= key%10000;
        if(primary_array[blocks] == null)
        {
            primary_array[blocks]=new Node(-1,-1);
        }
        Node prev = null;
        Node current = primary_array[blocks];
        while(current!=null && current.key!=key)
        {
            prev = current;
            current = current.next;
        }
        if(prev.next == null)
        {
            prev.next =new Node(key,value);
        }
        else
        {
            prev.next.val = value;
        }
    }

    public int get(int key) {
        int block = key%10000;

        if(primary_array[block]==null)
        {
            return -1;

        }
        Node prev = null;
        Node current = primary_array[block];
        while(current!=null && current.key!=key)
        {
            prev = current;
            current = current.next;
        }
        if(prev.next == null)
        {
            return -1;
        }
        else
        {
            return prev.next.val;
        }

    }

    public void remove(int key) {
        int block = key%10000;
        if(primary_array[block]==null)
        {
            return;

        }
        Node prev = null;
        Node current = primary_array[block];
        while(current!=null && current.key!=key)
        {
            prev = current;
            current = current.next;
        }
        if(prev.next == null)
        {
            return;
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