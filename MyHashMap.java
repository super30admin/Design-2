// Time Complexity: O(1)
// getHashIndex: O(1)
// getNode: O(100) -> O(1) Average or Amortized Time Complexity 
// put: At max every bucket would have 100 items thus O(100) -> O(1)
// get: O(100) -> O(1)
// remove: O(100) -> O(1)

// Space Complexity : O(10^6) which is N -> O(N)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this: NO

// Your code here along with comments explaining your approach

class MyHashMap {
    Node[] storage;
    int buckets; 
    
    public class Node {
        int key;
        int data;
        Node next;

        public Node(int key, int data) {
            this.data = data;
            this.key = key;
            this.next = null;
        }
    }

    public MyHashMap() {
        this.buckets = 10000;
        this.storage = new Node[buckets];
    }

    public int getHashIndex(int key) {
        return key % buckets;
    }

    // NOTE
    // I modified the code slightly to introduce string as third param 
    // While it might bring inefficiecy slightly but wanted to try to modify it little bit for practice

    public Node getNode(Node head, int key, String req) {
        Node current = head;
        Node prev = null; 

        while(current != null && key != current.key) {
            prev = current;
            current = current.next; 
        }

        // Returns the current node if currentNode string is passed otherwise it would return prevNode
        if("currentNode".equals(req)) {
            return current;
        } else {
            return prev;
        }
    }

    public void put(int key, int value) {
        int index = getHashIndex(key);

        // storage[index] if null meaning there is no linked list present
        // storage[index] is a null pointer which should point to dummy node
        
        // NOTE
        // Dummy node would make it easier to handle edge cases while remove operation (Remove head of Linked List in that case prev would be pointing to null)
        if(storage[index] == null) {
            storage[index] = new Node(-1, -1);
            storage[index].next = new Node(key, value);
            return;
        }

        // If first node is present then find the previous node of current node 
        // IF the prev node is null that means we couldn't find the node which matches key thus we can add new node to prev node 
        // Else if the prev node is not null that means we found the node which matches the key then we update the data

        // Question: WHY NOT USE CURRENT NODE INSTEAD OF PREVIOUS NODE
        // ANSWER: Current node would work if we found the node which matches the key then we can update the value easily 
        //         When current node is not found then we can't add the node thus we need Prev Node
        Node prevNode = getNode(storage[index], key, "prevNode");
        if(prevNode.next == null) {
            prevNode.next = new Node(key, value);
        } else {
            prevNode.next.data = value;
        }
    }

    // storage[index] if null meaning we didn't find the node we want thus return 
    
    public int get(int key) {
        int index = getHashIndex(key);

        if(storage[index] == null) return -1;

        // Since we need to update the value it's readable to use Current Node instead of Previous Node
        // Get the current node 
        Node currNode = getNode(storage[index], key, "currentNode");

        // If the current node is null which means the node we want does not exists thus return -1
        if(currNode == null) return -1;
        
        // ELSE: we found the node so return the data
        return currNode.data;
    }
    
    // storage[index] if null meaning we didn't find the node we want thus return 

    public void remove(int key) {
        int index = getHashIndex(key);

        if(storage[index] == null) return;
        
        // NOTE
        // Since we want to remove node thus we need to use PrevNode instead of current node
        
        Node prevNode = getNode(storage[index], key, "prevNode");

        // ONCE previous node is found, next node to previous or current node is null that means node with key was not found thus nothing to remove
        if(prevNode.next == null) return;
        // If Current node is not null which means we found the node to remove
        // Thus change the links of linkedList and remove the node
        Node current = prevNode.next;
        prevNode.next = current.next;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */