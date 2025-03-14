// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class MyHashMap {
        class Node {
            int key;
            int value;
            Node next;
    
            Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }
    
        int bucketSize;
        Node[] buckets; 
    
        public MyHashMap() {
            bucketSize = 9999;
            buckets = new Node[bucketSize];
        }
    
        public int getHash(int key) {
            return key % bucketSize;
        }
    
        public Node getPrev(Node node, int key) {
            Node prev = node;
            while(prev.next != null && prev.next.key != key) {
                prev = prev.next;
            }
            return prev;
        }
    
        public void put(int key, int value) {
            int hash = getHash(key);
            Node node = new Node(key,value);
            if(buckets[hash] == null) {
                buckets[hash] = new Node(-1,-1);
                buckets[hash].next = node;
            }
            else {
                Node previousNode = getPrev(buckets[hash], key);
                if(previousNode.next != null) {
                    previousNode.next.value = value;
                } else {
                    previousNode.next = node;
                }
            }
        }
    
        public int get(int key) {
            int hash = getHash(key);
            if(buckets[hash] == null) {
                return -1;
            }
            else if(buckets[hash] != null) {
                Node previousNode = getPrev(buckets[hash], key);
                if(previousNode != null && previousNode.next != null) {
                    return previousNode.next.value;
                }
            }
            return -1;
        }
    
        public void remove(int key) {
            int hash = getHash(key);
            if(buckets[hash] == null) {
                return;
            }
            else {
                Node previousNode = getPrev(buckets[hash], key);
                if(previousNode != null && previousNode.next != null) {
                    previousNode.next = previousNode.next.next;
                }
            }
        }
}
