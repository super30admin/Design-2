/*
  Time complexity: Get O(1); Put O(1); Remove O(1)
  Space complexity: O(1)

  Did this code run successfully on Leetcode: Yes

  Approach: The range of values is 0 to 10^6. The initial nodes array has a size of 10,000. So the maximum size of linked list for each array index is 100. A dummy node is added to each of the indices to simplify operations. Get returns a value if it present and -1 otherwise. Put adds/updates a node to the linked list. Remove removes a node with key if it is present.

*/

public class Node
{
    public int key;
    public int value;
    public Node next;

    public Node(int key, int value)
    {
        this.key = key;
        this.value = value;
        this.next = null;
        
    }
}

public class MyHashMap {
    Node[] nodes;

    public MyHashMap() {
        nodes = new Node[10000];
    }
    
    private int hash(int key)
    {
        return key%10000;
    }

    public void Put(int key, int value) {
        int hashValue = hash(key);

        if(nodes[hashValue]==null)
        {
            nodes[hashValue] = new Node(-1, -1);
        }
            Node prev = helper(key);
            if(prev.next==null)
            {
                prev.next = new Node(key,value);;
                
            }
            else
            {
                prev.next.value = value;
            }
        
    }
    
    public int Get(int key) {
        int hashValue = hash(key);

        if(nodes[hashValue]==null)
        {
            return -1;
        }
        else
        {
            Node prev = helper(key);
            if(prev.next!=null)
            {
                return prev.next.value;
            }
        }
        return -1;
    }
    
    public void Remove(int key) {
         int hashValue = hash(key);

        if(nodes[hashValue]==null)
        {
            return;
        }
        else
        {
            Node prev = helper(key);
            if(prev.next!=null)
            {
                Node current = prev.next;
                prev.next = current.next;
                current.next = null;
            }
        }
    }

    public Node helper(int key)
    {
        Node prev = nodes[hash(key)];
        Node current = prev.next;
        while(current!=null && current.key!=key)
        {
            prev = current;
            current = current.next;
        }
        return prev;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.Put(key,value);
 * int param_2 = obj.Get(key);
 * obj.Remove(key);
 */
