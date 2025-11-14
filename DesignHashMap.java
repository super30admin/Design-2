// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : most of the code i refered from class


// Your code here along with comments explaining your approach
class MyHashMap {
    //10000 bucket with each having linkedlist
    Node[] hashmap;
    int buckets;

    class Node
    {
        int key;
        int value;
        Node next;

        public Node(int key, int val)
        {
            this.key = key;
            this.value = val;
            this.next = null;
        }
    }

    public MyHashMap() {
        this.buckets = 10000;
        this.hashmap = new Node[buckets];
    }

    private int getHash(int key)
    {
        return key%10000;
    }

    private Node find(Node root, int key)
    {
        Node curr = root;
        Node prev = null;
        while(curr!=null && curr.key != key)
        {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    
    public void put(int key, int value) {
        int index = getHash(key);
        if(null == hashmap[index])
        {
            hashmap[index] = new Node(-1,-1);
            hashmap[index].next = new Node(key,value);
            return;
        }
        Node prev = find(hashmap[index], key);
        if(prev.next == null)
        {
            prev.next = new Node(key, value);
        }
        else
        {
            prev.next.value = value;
        }
    }
    
    public int get(int key) {
        int index = getHash(key);
        if(hashmap[index] == null) return -1;
        Node prev = find(hashmap[index], key);
        if(prev.next == null) return -1;
        return prev.next.value;
    }
    
    public void remove(int key) {
        int index = getHash(key);
        if(hashmap[index] == null) return;
        Node prev = find(hashmap[index], key);
        if(prev.next == null) return;
        Node curr = prev.next;
        prev.next = curr.next;
        curr.next = null;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */