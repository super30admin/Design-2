class Node{
    int key;
    int val;
    Node next;

    public Node(int key, int val){
        this.key = key;
        this.val = val;
    }
}

/**
 * Approach :
 *
 * TC: O(N/K) where N is the number of all possible keys and K is the number of predefined bucket.In avg case we could consider size of bucket as N/K considering uniform distribution.
 * In the worst case we need to iterate through all the values in the bucket the time complexity of each operation is O(N/K)
 * SC: O(K+M) k is the number of buckets and M is the number of unique keys that are inserted into the hashmap
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : Initially had problems understanding complexity
 * **/

class MyHashMap {
    Node arr[];
    int bucket;

    public MyHashMap() {
        bucket = 1000;
        arr = new Node[bucket+1];
    }

    public int hash(int key){
        return key/bucket;
    }

    public Node search(int key, Node node){
        Node prev = node;
        Node head = node.next;
        while(head!=null && head.key != key){
            Node temp = head;
            prev = head;
            head = temp.next;
        }
        return prev;
    }

    public void put(int key, int value) {
        int idx = hash(key);
        if(arr[idx]==null){
            arr[idx] = new Node(-1,-1);
        }
        Node prev = search(key,arr[idx]);
        if(prev.next == null){
            prev.next = new Node(key,value);
            return;
        }
        prev.next.val = value;
    }

    public int get(int key) {
        int idx = hash(key);
        if(arr[idx]==null){
            return -1;
        }
        Node prev = search(key,arr[idx]);
        if(prev.next == null){
            return -1;
        }
        return prev.next.val;
    }

    public void remove(int key) {
        int idx = hash(key);
        if(arr[idx]==null){
            return;
        }
        Node prev = search(key,arr[idx]);
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