// Time Complexity : O(1) for put(), remove(), get() and it could be O(n) for each in worst case
// Space Complexity : O(n+1000) since we have taken 1000 bkts
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Initially due to collisions problems can occur, but later used linkedlist to handle them.
// Your code here along with comments explaining your approach
// I created a custom MyHashMap using an array of linked lists (with dummy head nodes) to handle collisions.
// A helper method `find()` traverses a bucket's list and returns the previous node of the target key if found.
// On `put`, if the key exists, I update its value; otherwise, I append a new node at the end.
// On `get`, I return the value if the node exists, else return -1.
// On `remove`, I update the previous node's pointer to skip over the deleted node.
// Used a simple modulo hash function: key % 1000 as of previous hashset problem.




class HashMap {
    class Node {
        int key, value;
        Node next;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    Node find(Node dummy, int key){
        Node pre = dummy;
        Node cur = dummy.next;
        while(cur!=null && cur.key!=key){
            pre = cur;
            cur = cur.next;
        }
        return pre;
    }

    int bkts;
    Node[] storage;
    int getBkt(int key){
        return Integer.hashCode(key) % this.bkts;
    }

    public HashMap() {
        this.bkts=1000;
        storage = new Node[this.bkts];
        
    }
    
    public void put(int key, int value) {
        int bkt = getBkt(key);
        if(storage[bkt]==null){
            storage[bkt] = new Node(-1, -1);
        }
        Node pre = find(storage[bkt], key);
        if(pre.next==null){
            pre.next=new Node(key, value);
        }
        else{
            pre.next.value = value;
        }
        
    }
    
    public int get(int key) {
        int bkt = getBkt(key);
        if(storage[bkt]==null){
            return -1;
        }
        Node pre = find(storage[bkt], key);
        if(pre.next !=null){
            return pre.next.value;
        }
        return -1;
        
    }
    
    public void remove(int key) {
        int bkt = getBkt(key);
        if(storage[bkt]==null){
            return;
        }
        Node pre = find(storage[bkt], key);
        if (pre.next!=null){
            pre.next = pre.next.next;
        }
        
    }

    public static void main(String[]args){
        HashMap hm = new HashMap();
        hm.put(1,1);
        hm.put(2,2);
        System.out.println(hm.get(1));     
        System.out.println(hm.get(3));    
        hm.put(2, 1);               
        System.out.println(hm.get(2));    
        hm.remove(2);                     
        System.out.println(hm.get(2));  


    }
}
