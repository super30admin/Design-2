// Time Complexity : find function has an average time complexity of O(1) and so does all the other functions
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach


class MyHashMap {

    class Node // Node class is created having key,value and pointer to the next node as it's properties
    {
        int key;
        int value;
        Node next;

        Node(int key,int value) // Constructor initializes key and value. The next pointer is not initialised here as it is null by default
        {
            this.key = key;
            this.value = value;
        }
    }
    Node []hashMap;
    
    private int hash(int key) // hash function which generates the hash given the key
    {
        return key%10000;
    }

    public MyHashMap() {
        this.hashMap = new Node[10000]; // constructor initializes primary array of size 10000
    }

    private Node find(Node head,int key) // iterates through secondary array and returns prev pointer (node just prior to the node being searched)
    {
        Node prev = null;
        Node current = head;
        while(current!=null && current.key!=key)
        {
            prev=current;
            current=current.next;
        }
        return prev;
    }
    
    public void put(int key, int value)  // function puts the key value pair in hashMap. If primary array doesn't have node, it first creates a dummy nodes and adds the key value pair after it. If key value pair is already present, it simply updates the value
    {
        int hash = hash(key);
        if(hashMap[hash]==null)
        {
            hashMap[hash] = new Node(-1,-1);
        }
        Node prev = find(hashMap[hash],key);
        if(prev.next==null)
        {
            prev.next = new Node(key,value);
        }
        else
        {
            prev.next.value = value;
        }
    }
    
    public int get(int key) // returns -1 if key doesn't exist, or it returns the value present at that key
    {
        int hash = hash(key);
        if(hashMap[hash]==null)
        {
            return -1;
        }
        Node prev = find(hashMap[hash],key);
        if(prev.next==null)
        {
            return -1;
        }
        else
        {
            return prev.next.value;
        }
    }
    
    public void remove(int key) // if node is present with key, it is deleted. Else nothing is done
    {
        int hash = hash(key);
        if(hashMap[hash]==null)
        {
            return;
        }
        Node prev = find(hashMap[hash],key);
        if(prev.next==null)
        {
            return;
        }
        else
        {
            prev.next = prev.next.next;
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