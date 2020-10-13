package Day1;

class MyHashSet {
	  
    // Time Complexity: O(1) 
    
    // Space Complexity: O(n)
    // Not sure on complexity aspects.
    
    // Did this code successfully run on Leetcode : No
    // Any problem you faced while coding this : Difficulty in understanding and implementing the points mentioned in Note in the problem statement.
    
    int MAX_SIZE = 10000;
   
    Node[] mySet ;

    /** Initialize your data structure here. */
    // Initialized an array of custom class Node type of size 10000.
    public MyHashSet() {
        mySet =  new Node[MAX_SIZE];
    }
    
    // get hashcode of the new key
    // use this hashcode as index in 'mySet' array
    public void add(int key) {
        int hash = hasIndex(key);
        
        // if No collision happens
        if (mySet[hash] == null) {
            mySet[hash] = new Node(key);
        } 
        // if collision happens and key is not already present in mySet:
        //     add the key as the last node in the linked list
        else {
            Node root = mySet[hash];
            while (root.next != null) {
                if (root.nodeVal == key) {
                    return;
                }
                root = root.next;
            }
            if (root.nodeVal == key) {
                return;
            } 
            else {
            root.next = new Node(key);
            }
        }
    }
    
    // if collision happens:
    //     remove the node matching the given key in the linked list
    public void remove(int key) {
         int hash = hasIndex(key);
         Node pre = null;
         Node root = mySet[hash];
         if (root == null) {
             return;
         }
         if (root.next == null) {
             mySet[hash] = null;
             return;
         }
         else {
             while (root != null) {
                 if (root.nodeVal == key) {
                     if(pre==null){
                          mySet[hash]=root.next;
                         return;
                     }
                      else  {
                          pre.next = root.next;
                     return; 
                      }
                    
                 } 
                 pre = root;
                 root = root.next;
             }
         }  
    }
    
    /** Returns true if this set contains the specified element */
    // if collision happens:
    //     traverse through the linked list
    //    check if any of the nodes in the linked list match key in the funct argument
    public boolean contains(int key) {
         int hash = hasIndex(key);
        
         Node root = mySet[hash];
          
         while (root != null) {
                 if (root.nodeVal == key) {
                    return true;
                 } 
                 root = root.next;
          }
        return false;
    }
    
    // function to return hashcode for a numeric input
    public int hasIndex(int val){
        return Integer.hashCode(val) % MAX_SIZE;
    }
  
    // custom class for Node containing the values contained in a set
    class Node {
        
        int nodeVal;
        Node next;
        
        public Node(int v) {
            nodeVal = v;
            next = null;
        }
    }
    
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */