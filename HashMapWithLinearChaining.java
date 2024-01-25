
// Time Complexity :
// put() : O(Size of List) = O(100) = O(1)
// get() : O(Size of List) = O(100) = O(1)
// remove() : O(Size of List) = O(100) = O(1)
// search() : O(Size of List) = O(100) = O(1)

// Space Complexity :
// put() : O(1)
// get() : O(1)
// remove() : O(1)
// search() : O(1)

// Constraints:
// 0 <= key, value <= 10^6
// At most 104 calls will be made to put, get, and remove.

public class HashMapWithLinearChaining {
    class MyHashMap {
        private Node[] bucketsArray;
        private int totalBuckets;

        class Node {
            private int key;
            private int value;
            private Node next;

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        public MyHashMap() {
            this.totalBuckets = 10000;
            this.bucketsArray = new Node[totalBuckets];
        }

        public void put(int key, int value) {
            int currentBucket = getBucket(key);
            if (bucketsArray[currentBucket] == null) {
                bucketsArray[currentBucket] = new Node(-1, -1); // Add dummy node to empty bucket
            }

            Node prev = search(bucketsArray[currentBucket], key);

            if (prev.next == null) { // Key DNE in list (prev=head or prev=tail)
                prev.next = new Node(key, value);
            } else { // Key exisits in list
                prev.next.value = value;
            }
        }

        public int get(int key) {
            int currentBucket = getBucket(key);
            if (bucketsArray[currentBucket] == null) {
                return -1;
            }

            Node prev = search(bucketsArray[currentBucket], key);
            if (prev.next == null) { // Key DNE in list (prev=head or prev=tail)
                return -1;
            }
            return prev.next.value;
        }

        public void remove(int key) {
            int currentBucket = getBucket(key);
            if (bucketsArray[currentBucket] == null) {
                return;
            }

            Node prev = search(bucketsArray[currentBucket], key);
            if (prev.next == null) { // Key DNE in list (prev=head or prev=tail)
                return;
            }
            prev.next = prev.next.next;
        }

        private Node search(Node head, int key) {
            Node prev = null;
            Node curr = head;

            while (curr != null && curr.key != key) {
                prev = curr;
                curr = curr.next;
            }
            return prev;
        }

        private int getBucket(int key) {
            return key % totalBuckets;
        }
    }

    /**
     * Your MyHashMap object will be instantiated and called as such:
     * MyHashMap obj = new MyHashMap();
     * obj.put(key,value);
     * int param_2 = obj.get(key);
     * obj.remove(key);
     */
}
