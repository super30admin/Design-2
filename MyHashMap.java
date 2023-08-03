// Time Complexity : Average Case : Insert = O(1) , Get = O(1) , Remove = O(1),
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class MyHashMap {
    class Node {
        int key;
        int value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int bucketSize = 10;
    Node[] bucket;

    public MyHashMap() {
        bucket = new Node[bucketSize];
    }

    public void put(int key, int value) {
        int hash = key % bucketSize;
        if (bucket[hash] == null) {
            bucket[hash] = new Node(-1, -1);
        }
        bucket[hash] = insertList(bucket[hash], key, value);
    }

    public void display() {
        int i = 0;
        for (Node node : bucket) {
            System.out.print("Bucket Position= " + i + " ");
            displayList(node);
            i++;
        }
    }

    public void displayList(Node head) {
        while (head != null) {
            System.out.print("(" + head.key + "," + head.value + ")->");
            head = head.next;
        }
        System.out.println("");
    }

    public Node insertList(Node head, int key, int value) {
        Node newNode = new Node(key, value);
        if (head == null) {
            head = newNode;
        } else {
            Node traverse = head;
            while (traverse.next != null){
                if(traverse.key==key){
                    traverse.value = value;
                    return head;
                }
                traverse = traverse.next;}
            if(traverse.key==key){
                traverse.value = value;
            }else{
                traverse.next = newNode;
            }

        }
        return head;
    }

    public int get(int key) {
        int hash = key % bucketSize;
        if (bucket[hash] == null) {
            return -1;
        } else {
            return findByKey(bucket[hash], key);
        }
    }

    public int findByKey(Node head, int key) {
        Node traverse = head;
        while (traverse != null) {
            if (traverse.key == key)
                return traverse.value;
            traverse = traverse.next;
        }
        return -1;
    }

    public void remove(int key) {
        int hash = key % bucketSize;
        if (bucket[hash] == null) {
            return;
        } else {
            Node previous = bucket[hash];
            Node current = previous.next;
            while (current != null) {
                if (current.key == key) {
                    previous.next = current.next;
                }
                previous = previous.next;
                current = current.next;
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
