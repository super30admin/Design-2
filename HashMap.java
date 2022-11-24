class MyHashMap {
    class Node{
        int key;
        int val;
        Node next;
        
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
       private Node[] storage;
       private int buckets;
       public MyHashMap() {
           this.buckets =1000;
           this.storage = new Node[this.buckets];
       }
       
       private Node find(Node head,int key){
           Node prev = null;
           Node curr = head;
           
           while(curr != null && curr.key != key){
               prev = curr;
               curr = curr.next;
           }
           return prev;
       }
       
       private int hash1(int key){
           return key%this.buckets;
       }
       
       public void put(int key, int value) {
           int hash1 = hash1(key);
           if(storage[hash1] == null){
               storage[hash1] = new Node(-1,-1);
           }
            Node prev = find(storage[hash1],key);
            if (prev.next == null){ 
                 prev.next = new Node(key, value);
               }
               else{
                   prev.next.val = value;
               }
           }
       
       
       public int get(int key) {
           int hash1 = hash1(key);
           
           if(storage[hash1] == null) return -1;
           Node prev = find(storage[hash1], key);
           
           if(prev.next == null) return -1;
           return prev.next.val;
       }
       
       public void remove(int key) {
           int hash1 = hash1(key);
           
           if(storage[hash1] == null) return;
           Node prev = find(storage[hash1], key);
           if(prev.next == null) return;
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
   
   
   
   
   // Time Complexity : O(1)
   // Space Complexity :O(1)
   // Did this code successfully run on Leetcode :Yes
   // Any problem you faced while coding this :
   
   
   // Your code here along with comments explaining your approach
   
   // Taking array with size 1000 and performing put, get, remove operations by taking key from hashfunction. If the key in primery Array is null then we have to create a node. Creating find function, which can be used in put,get, remove function. In Put functon creating a node if the index is empty. If nodes already exist the finding the key and updating its value. If there is no key then creating a node and adding key,value. Inorder to get any value, find key in LL and get its value. To remove some key,value first find key using find function and assign prev to cuu and curr to prev.next.next or curr.next.