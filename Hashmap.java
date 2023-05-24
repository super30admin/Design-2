// Time Complexity : O(1) ( not sure as we traverse through linked list in find method()) 
// Space Complexity : O(n) (since we are using primary array to store)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :No but need clarification on time complexity.


// Your code here along with comments explaining your approach
/* Implementation using separate chaining using linked list 
Lets consider primary array of size 10^4 */


class MyHashMap {
    class Node{
        int key,value;
        Node next;
        public Node(int key,int value){
            this.key = key;
            this.value = value;
        }
    }
    
     Node[] nodes; 
     int buckets;
        public MyHashMap() {
             buckets = 1000;// can also try with 10^4
           nodes = new Node[buckets] ;
        }
    
    //hash function to find index in primary array
        private int getBucket(int key){
            // return Integer.hashCode(key) % buckets;
            return key % buckets;
        }
        
        //if we append the new value at the beginning or end we need to traverse the entire linked list so lets just have a common method find to get the head.
        private Node find(Node head,int key){
            Node prev = head;// if no nodes head points to dummy node(-1,-1)
            Node curr = head.next; // null if no nodes are present
            while(curr!=null && curr.key!=key){
                prev = curr;
                curr = curr.next;
            }
            return prev;
            
        }
        public void put(int key, int value) {
            int index = getBucket(key);// get the index of the primary array
            //initialize dummy node if no linked list is present
            if(nodes[index] == null){
                nodes[index] = new Node(-1,-1);
            }
            Node prev = find(nodes[index],key);
            if(prev.next == null){
                //add node if not present
                prev.next = new Node(key,value);
    
            }
            else{
                // if node is present update the value
                prev.next.value = value;
            }
    
            
        }
        
        public int get(int key) {
            int index = getBucket(key);
            // if the index in primary array is null then the element is not present
            if(nodes[index]== null){
                return -1;
            }
             //if its not null traverse through the linked list
            Node prev = find(nodes[index],key);
            if(prev.next==null){
                return -1;
            }
          return prev.next.value;
        }
        
        public void remove(int key) {
            int index = getBucket(key);
            if(nodes[index]== null){
                return;
            }
              Node prev = find(nodes[index],key);
              if(prev.next==null ){
                  return;
              }
              //update the pointer after deletion
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