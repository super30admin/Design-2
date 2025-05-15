package Problem2;
// Time Complexity: put-O(n) {worst}(n is 100), get-O(n) {worst}(n is 100), remove- O(n) {worst}(n is 100)
// Space Complexity: ??
//  Idea-> used a  length of 10000 for the array to get a hash index  which will have connected nodes with
//  key and value, to keep a track of all the elements.
public class DesignHasMap {
    static class MyHashMap {

        private Node[] arr;
        private int len;
        class Node {
            int key;
            int value;
            Node next;

            Node(int key, int value) {
                this.key = key;
                this.value = value;
                next = null;
            }
        }

        public MyHashMap() {
            len = 10000;
            this.arr =  new Node[len];
        }

        int hash(int key) {
            return key % len;
        }


        Node helper(Node head, int key) {
            Node prev = null;
            Node curr = head;

            while(curr != null && curr.key != key) {
                prev = curr;
                curr = curr.next;
            }

            return prev;
        }
        public void put(int key, int value) {
            int index = hash(key);
            if(arr[index] == null) {
                arr[index] = new Node(-1, -1);
            }
            Node temp = helper(arr[index], key);
            if(temp.next == null) {
                Node node = new Node(key, value);
                temp.next = node;
            } else {
                temp.next.value = value;
            }
        }

        public int get(int key) {
            int index = hash(key);
            if(arr[index] == null) {
                return -1;
            }

            Node temp = helper(arr[index], key);
            if(temp.next == null) {
                return -1;
            }

            return temp.next.value;
        }

        public void remove(int key) {
            int index = hash(key);
            if(arr[index] == null) {
                return;
            }

            Node temp = helper(arr[index], key);
            if(temp.next == null) {
                return;
            }

            Node node = temp.next;
            temp.next = temp.next.next;
            node.next = null;

        }
    }

    public static void main(String[] args) {
        MyHashMap map =  new MyHashMap();
        map.put(2, 4);
        map.put(20001, 1);
        map.put(30001, 1);
        System.out.println("Value of key 2: " + map.get(2));
        map.put(2, 5);
        System.out.println("Value of key 2: " + map.get(2));
    }
}
