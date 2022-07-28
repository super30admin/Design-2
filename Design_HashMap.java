// did not run successfully
// 5 errors, line 20, 21, 46, 65, 79


class MyHashMap {
    class Node{
        int key, value;
        Node next;
        public Node(int key, int value){
            this.key = key;
            this.value = value;

        }
    }

    Node[] nodes;
    int buckets;

    private int getBucket(int key){
        return Integer.hashCode(key)% buckets;
    }

    private Node find(int head, int key){
        Node prev = head;
        Node curr = head.next;
        while(curr != null && curr.key != key){
            prev = curr;
            curr = curr.next;
        }
        return prev;

    }



    public MyHashMap() {
        buckets = 10000;
        nodes = new Node[buckets];
    }




    public void put(int key, int value) {
        int index = getBucket(key);
        //index is not present, create a dummy node
        if(nodes[index] == null){
            nodes[index] = new Node(-1, -1);
        }
        Node prev = find(nodes[index], key);
        if(prev.next == null){
            prev.next = new Node(key, value);

        }
        else{
            prev.next.value = value;
        }



    }

    public int get(int key) {
        int index = getBucket(key);
        //index is not present, create a dummy node
        if(nodes[index] == null){
            return -1;
        }
        Node prev = find(nodes[index], key);
        if(prev.next == null){
            return -1;

        }
        return prev.next.value;
    }

    public void remove(int key) {
        int index = getBucket(key);
        //index is not present, create a dummy node
        if(nodes[index] == null){
            return;
        }
        Node prev = find(nodes[index], key);
        if(prev.next == null){
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