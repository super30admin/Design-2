class MyHashMap {
    private Node[] hashMap;
    class Node{
        int key;
        int val;
        Node next;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    public MyHashMap() {
        hashMap = new Node[10000];
    }

    private int hash(int key){
        return key%10000;
    }

    private Node Search(Node head, int key){
        Node prev = null;
        Node curr = head;
        while(curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    
    public void put(int key, int value) {
        int idx = hash(key);
        if(hashMap[idx] == null) {
            hashMap[idx] = new Node(-1,-1);
        }
        Node prev = Search(hashMap[idx], key);
        if(prev.next == null) {
            prev.next = new Node(key, value);
        }
        else{
            prev.next.val = value;
        }
    }
    
    public int get(int key) {
        int idx = hash(key);
        if(hashMap[idx] == null) {
            return -1;
        }
        Node prev = Search(hashMap[idx], key);
        if(prev.next == null) return -1;
        return prev.next.val;
    }
    
    public void remove(int key) {
        int idx = hash(key);
        if(hashMap[idx] == null){
            return;
        }
        Node prev = Search(hashMap[idx],key);
        if(prev.next == null){
            return;
        }
        Node temp = prev.next;
        prev.next = prev.next.next;
        temp.next = null;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */