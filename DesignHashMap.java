public class DesignHashMap {
    class Node {
        int key;
        int val;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
        private Node[] storage;
        int buckets;
        public DesignHashMap() {
            this.buckets = 1000;
            this.storage = new Node[buckets];
        }
        private int getHash(int key) {
           return key % buckets;
        }

        public Node getPrev(Node head, int key) {
            Node prev = null;
            Node curr = head;
            while(curr != null && curr.key != key) {
                prev = curr;
                curr = curr.next;
            }
           return prev;
        }
        public void put(int key, int val) {
            int primaryIdx = getHash(key);
            if(storage[primaryIdx] == null) {
                storage[primaryIdx] = new Node(-1,-1);
                storage[primaryIdx].next = new Node(key, val);
                return;
            }
            Node prev = getPrev(storage[primaryIdx], key);
            if(prev.next == null) {
                prev.next = new Node(key, val);
            } else {
                prev.next.val = val;
            }

        }
        public void remove(int key) {
            int primaryIdx = getHash(key);
            if(storage[primaryIdx] == null) {
                return;
            }
            Node prev = getPrev(storage[primaryIdx], key);
            if(prev.next == null) {
                return;
            }
            Node curr = prev.next;
            prev.next = curr.next;
            curr.next = null;

        }

        public int get(int key) {
             int primaryIdx = getHash(key);
             if(storage[primaryIdx] == null) return -1;
             Node prev = getPrev(storage[primaryIdx], key);
             if(prev.next == null)  return -1;
             return prev.next.val;
        }

    }
}
