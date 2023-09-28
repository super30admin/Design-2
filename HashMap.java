// Time Complexity :O(1)
// Space Complexity :
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :Node
public class HashMap {
    class MyHashMap {
        class Node{
            int key, val;
            Node next;

            public Node(int key, int val){
                this.key = key;
                this.val = val;
                this.next = null;
            }
        }
        private Node storage[];
        private int hash(int key){
            return key%10000;
        }

        private Node search(Node head, int key){
            Node prev = null;
            Node curr = head;
            while(curr != null && curr.key != key){
                prev = curr;
                curr = curr.next;
            }
            return prev;
        }

        public MyHashMap() {
            this.storage = new Node[10000];
        }

        public void put(int key, int value) {
            int idx = hash(key);
            if(storage[idx] == null){
                storage[idx] = new Node(-1,-1);
            }
            Node prev = search(storage[idx], key);
            if(prev.next == null){
                //very first element in the list
                prev.next = new Node(key, value);
            }
            else{
                //update the list
                prev.next.val = value;
            }
        }

        public int get(int key) {
            int idx = hash(key);
            if(storage[idx] == null){
                return -1;
            }
            Node prev = search(storage[idx], key);
            if(prev.next == null){
                return -1;
            }
            else{
                return prev.next.val;
            }
        }

        public void remove(int key) {
            int idx = hash(key);
            if(storage[idx] == null) return;

            Node prev = search(storage[idx], key);
            if(prev.next == null){
                return;
            }
            else{
                Node temp = prev.next;
                prev.next = prev.next.next;
                temp.next = null;
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
}
