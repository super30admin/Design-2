//Time complexity: all methods - O(1)
//Space Complexity: O(n)
class MyHashMap {
    class Node{
        int key, value;
        Node next;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
    Node data[];
    int buckets;
    public MyHashMap() {
        buckets = 10000;
        data = new Node[buckets];
    }
    private Node getPrev(Node head, int key){
        Node prev = head, curr = head.next;
        while(curr!=null && curr.key != key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    private int hashFunction(int key){
        return key%this.buckets;
    }
    public void put(int key, int value) {
        int index = hashFunction(key);
        if(data[index] == null){
            data[index] = new Node(-1, -1);
        }
        Node prev = getPrev(data[index], key);
        if(prev.next == null){
            prev.next = new Node(key, value);
        }
        else{
            prev.next.value = value;
        }
    }
    
    public int get(int key) {
        int index = hashFunction(key);
        if(data[index] == null){
            return -1;
        }
        Node prev = getPrev(data[index], key);
        if(prev.next == null){
            return -1;
        }
        return prev.next.value;
        
    }
    
    public void remove(int key) {
        int index = hashFunction(key);
        if(data[index] == null){
            return;
        }
        Node prev = getPrev(data[index], key);
        if(prev.next == null){
            return;
        }
        prev.next = prev.next.next;
        return;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
