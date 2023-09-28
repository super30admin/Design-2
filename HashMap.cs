    public class MyHashMap
    {
        // Time Complexity : Put - O(1), Get - O(1), Remove - O(1) and Search - O(1)
        // Space Complexity : O(1)
        // Did this code successfully run on Leetcode : Yes
        // Any problem you faced while coding this : No

        class Node
        {
            public int _key;
            public int _val;
            public Node next;

            public Node(int key, int val)
            {
                _key = key;
                _val = val;
            }
        }

        private Node[] storage;
        int storageSize;

        private int PrimaryHash(int key)
        {
            return key % storageSize;
        }

        public MyHashMap()
        {
            storageSize = 10000;
            storage = new Node[storageSize];
        }

        private Node Search(Node head, int key)
        {
            Node prev = null;
            Node curr = head;

            while(curr != null && curr._key != key)
            {
                prev = curr;
                curr = curr.next;
            }
            return prev;
        }

        public void Put(int key, int value)
        {
            int hashIndex = PrimaryHash(key);
            if(storage[hashIndex] == null)
            {
                storage[hashIndex] = new Node(-1, -1);
            }
            Node prev = Search(storage[hashIndex], key);
            if(prev.next == null) //it means it is the last node and key does not exist
            {
                prev.next = new Node(key, value);
            }
            else
            {
                //it means the key exists, so update the value
                prev.next._val = value;
            }
        }

        public int Get(int key)
        {
            int hashIndex = PrimaryHash(key);
            if (storage[hashIndex] == null)
            {
                return -1;
            }

            Node prev = Search(storage[hashIndex], key);
            if(prev.next == null)
            {
                return -1;
            }
            else
            {
                return prev.next._val;
            }
        }

        public void Remove(int key)
        {
            int hashIndex = PrimaryHash(key);
            if (storage[hashIndex] == null)
            {
                return;
            }
            Node prev = Search(storage[hashIndex], key);
            if (prev.next == null) //end of list
            {
                return;
            }
            //else create temp node and remove current node with key
            Node temp = prev.next;
            prev.next = prev.next.next;
            temp.next = null;
        }
    }
