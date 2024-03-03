// Time Complexity : O(1)
// Space Complexity : O(n), n-> length of primary array, secondary would be ~ constant, as it will be very small compared to primary
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
public class MyHashMap{
    class MyHashMap {
        // 0 <= n <= 10^6
        // Linkedlist is needed, so creating one
        class Node {
            int key;
            int value;
            Node next;
            Node(int key, int val) {
                this.key = key;
                this.value = val;
            }
        }

        public int primarySize;
        public int secondary;
        public Node[] storage; // need storage array


        public MyHashMap() {
            this.primarySize = 10000;
            this.secondary = 100;
            this.storage = new Node[primarySize];
        }

        public int hash(int key) {
            return key % primarySize;
        }

        public void put(int key, int value) {
            int pIndex = hash(key); // pIndex -> primaryIndex
            if(this.storage[pIndex] == null){
                // if not found, then create a new node and save it there
                this.storage[pIndex] = new Node(-1, -1);
            }
            Node temp = this.storage[pIndex];
            Node prev = search(temp, key);
            if(prev.next == null) {
                prev.next = new Node(key, value); // if previous is tail, then key is not present. Hece create a new one
            } else {
                prev.next.value = value; // existing key, soupdate the value
            }
        }

        public int get(int key) {
            int pIndex = hash(key); // pIndex -> primaryIndex
            if(this.storage[pIndex] == null) return -1;
            // if not null then iterate
            Node temp = this.storage[pIndex];
            Node prev = search(temp, key);
            if(prev.next == null) return -1;
            return prev.next.value;
        }

        public void remove(int key) {
            int pIndex = hash(key); // pIndex -> primaryIndex
            if(this.storage[pIndex] == null) return;
            // if not null then iterate
            Node prev = search(this.storage[pIndex], key);
            if(prev.next == null) return;
            Node temp = prev.next;
            prev.next = prev.next.next;
            temp.next = null;
        }

        public Node search(Node node, int key){
            // dummy node
            Node previous = null;
            Node current = node;
            while(current != null && current.key != key) {
                previous = current;
                current = current.next;
            }
            return previous;
        }
    }
}
