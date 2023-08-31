// Time Complexity : O(n) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes https://leetcode.com/problems/design-hashmap/submissions/1036509454/
// Any problem you faced while coding this : No

/*
 * Implementing by using primary array and a single linked list to store the key value pair at the index. 
 * Using hashfn to determine the index of the primary array and if null we return directly as its not present. 
 * Provide a dummy as head of the linked list to the primary array and then traverse through the linked list to carry out all the operations.
 */
// Your code here along with comments explaining your approach
class MyHashMap {

    class Node{
        int key;
        int value;
        Node next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    int Buckets;
    Node[] arr;

    int getBucket(int key){
        return Integer.hashCode(key) % Buckets;
    }

    Node find(int index, int key){
        Node prev = arr[index];
        Node curr = prev.next;
        while(curr != null && curr.key != key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    public MyHashMap() {
        Buckets = 10000;
        arr = new Node[Buckets];
    }

    public void put(int key, int value) {
        int bucket = getBucket(key);
        if(arr[bucket] == null){
            arr[bucket] = new Node(-1, -1);
        }
        Node prev = find(bucket, key);
        if(prev.next != null){
            prev.next.value = value;
        }
        else{
            prev.next = new Node(key,value);
        }
    }

    public int get(int key) {
        int bucket = getBucket(key);
        if(arr[bucket] == null){
            return -1;
        }
        Node prev = find(bucket, key);
        if(prev.next != null){
            return prev.next.value;
        }
        return -1;
    }

    public void remove(int key) {
        int bucket = getBucket(key);
        if(arr[bucket] == null){
            return;
        }
        Node prev = find(bucket, key);
        if(prev.next != null){
            prev.next = prev.next.next;
        }
        return;
    }
}