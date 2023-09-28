// Time Complexity : O(1) For put, get & remove operations
// Space Complexity : O(1) For put, get & remove operations
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MyHashMap
{
    Node[] customHashMap;
    int bukets = 1000;
    public class Node
    {
        int key;
        int value;
        Node next;
        public Node(int key, int value)
        {
            this.key = key;
            this.value = value;
        }
    }
    int hashKey(int key)
    {
        return key%bukets;
    }
    public MyHashMap() {
        customHashMap = new Node[bukets];
    }

    public Node search(Node node, int key)
    {
        Node prev = null;
        while(node != null && node.key != key)
        {
            prev = node;
            node = node.next;
        }
        return prev;
    }
    public void put(int key, int value)
    {
        int bucketKey = hashKey(key);
        if (customHashMap[bucketKey] == null)
            customHashMap[bucketKey] = new Node(-1, -1);

        Node prev = search(customHashMap[bucketKey], key);
        if (prev.next == null)
            prev.next = new Node(key, value);
        else
            prev.next.value = value;
    }

    public int get(int key)
    {
        int bucketKey = hashKey(key);
        if (customHashMap[bucketKey] == null)
            return -1;

        Node prev = search(customHashMap[bucketKey], key);
        if (prev.next == null)
            return -1;
        else
            return prev.next.value;
    }

    public void remove(int key) {
        int bucketKey = hashKey(key);
        if (customHashMap[bucketKey] == null)
            return;

        Node prev = search(customHashMap[bucketKey], key);
        if (prev.next == null)
            return;

        Node temp = prev.next;
        prev.next = temp.next;
        temp.next = null;
    }
}
