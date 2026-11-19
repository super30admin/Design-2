/*

Approach :
hashing using linear chaining
TC: O(1) in average case
SC: O(N)
*/


class MyHashMap {

    class Node {
        int key;
        int val;
        Node next;

        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    Node map[];
    int bucket ;

    public MyHashMap() {
        bucket = 10000;
        map = new Node[bucket];
    }

    private Node search (Node head , int key){
        Node prev = null;
        Node curr = head;
        while(curr!=null && curr.key != key){
            prev = curr;
            curr=curr.next;
        }
        return prev;
    }

    private int hash(int key){
        return key % bucket;
    }

    public void put(int key, int value) {
        int index = hash(key);
        if(map[index]==null){
            map[index] = new Node(-1,-1);
        }
        Node prev = search(map[index] , key);
        if(prev.next!=null){
            prev.next.val = value;
        }
        else{
            prev.next = new Node(key,value);
        }
    }

    public int get(int key) {
        int index = hash(key);
        if(map[index]==null){
            return -1;
        }
        Node prev = search(map[index] , key);
        if(prev.next ==null){
            return -1;
        }
        return prev.next.val;
    }

    public void remove(int key) {
        int index = hash(key);
        if(map[index]==null){
            return;
        }
        Node prev = search(map[index] , key);
        if(prev.next == null){
            return;
        }
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