// Time Complexity :O(1)
// Space Complexity :O(n) - where n is the number of entries in HashMap 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No




// we will use linear Chaning to design Hashmap
// we will use array of nodes which point to the individual linked list.
// when some key come, we get the index of that in nodes array. After that will find key in that pointed linked list.
class MyHashMap {

    // This is the node class.
    class Node{
        int key;
        int val;
        Node next;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    // This function will help to find index in nodes array by hashing.
    public int idx(int key){
        return key%10000;
    }

    // This function will help to find key in linked list.
    public Node find(Node head,int key){
        Node prev = null;
        Node curr = head;
        while(curr != null && curr.key != key){
            prev = curr;
            curr = curr.next;
        }
        return prev;

    }

    // this is nodes array.
    // The size of nodes array is 10000.
    // and nested lined list size will be 100.
    Node[] nodes;
    public MyHashMap() {
        nodes = new Node[10000];   
    }
    

    public void put(int key, int value) {
        // first find index.
        int idx = idx(key);

        // if at that index in nodes, we get null, then first we will make dummy node at that index.
        if(nodes[idx] == null){
            nodes[idx] = new Node(-1,-1);
        }

        // will call "Find" function to find prev of thant node.
        Node prev = find(nodes[idx], key);

        // if there is no such key(no val with that key) then will make new node with tha key and assign the value.
        if(prev.next == null){
            prev.next = new Node(key,value);
        }else{

            // if key is already exist, will change it's value with new values. 
            prev.next.val = value;
        }
    }
    

    // same steps fololow for the get.but we simply return -1 if there is no linked list at that index instead to make dummy linked list.
    public int get(int key) {
        int idx = idx(key);
        if(nodes[idx] == null) return -1;
        Node prev = find(nodes[idx], key);
        if(prev.next == null) return -1;
        return prev.next.val;
    }
    
    // same steps follow for the remove with some minor changes.
    public void remove(int key) {
        int idx = idx(key);
        if(nodes[idx] == null) return;
        Node prev = find(nodes[idx], key);
        if(prev.next == null) return;

        // we will change the pointers.
        prev.next = prev.next.next;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
