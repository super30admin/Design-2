package S30.exercises;

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on LeetCode : Yes
// Any problem you faced while coding this : No


//Approach - Using SingleLinkedList and multiplicative hashing technique, leaner chaining strategy
// space complexity and minimize  the collusion.  Initialize the  Array with size of
// 10000 elements 

public class MyHashMapUsingSingleLinkedList {

        static final int size = 10000;
        static final double mult = 0.618033988749895;
        SingleLinkedListNode[] dataArray;

        public MyHashMap() {
            this.dataArray = new SingleLinkedListNode[size];
        }
        //to reduce the collusion applied multiplicative hashing
        private int hashCode(int key) {
            double hashValue = key * mult;
            hashValue -= Math.floor(hashValue); // Take fractional part
            return (int) (hashValue * size);
        }


        public void put(int key, int val) {
            remove(key);
            int hashValue = hashCode(key);
            SingleLinkedListNode node = new SingleLinkedListNode(key,val, dataArray[hashValue]);
            dataArray[hashValue] = node;
        }

        public int get(int key) {
            // Get the hash code for the given key first
            // Compare the given key with node's key.
            //If it is equal return the node's value
            //Otherwise return -1.
            int hashValue = hashCode(key);
            //Retrieve the node
            SingleLinkedListNode node = dataArray[hashValue];
            while (node != null) {

                if (node.key == key)
                    return node.val;
                node = node.next;
            }
            return -1;
        }

        public void remove(int key) {
            int hashValue = hashCode(key);
            SingleLinkedListNode node = dataArray[hashValue];
            //If node is null then no need to remove anything
            //return
            if (node == null)
                return;
            //If key matches with node's key then reassign the
            //array element with node's next.
            if (node.key == key) {
                dataArray[hashValue] = node.next;
                return;
            }

            SingleLinkedListNode prev = null;
            while (node != null) {
                if (node.key == key) {
                    prev.next = node.next;
                    return;
                }
                prev = node;
                node = node.next;
            }
        }
        class SingleLinkedListNode {
            int key, val;
            SingleLinkedListNode next;
            public SingleLinkedListNode(int key, int val, SingleLinkedListNode next) {
                this.key = key;
                this.val = val;
                this.next = next;
            }
        }

    }

