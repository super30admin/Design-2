/*
 * Time Complexity : put - O(1), remove - O(1) [O is going to be max the size of the linkedlist], get - O(1)
 * Space Complexity :  O(n)
 * Did this code successfully run on Leetcode : yes
 * Any problem you faced while coding this : No
 * 
 * Approach - For the hashmap we consider an array of Node which holds key&value. Initially, all the elements of the array will be null. We use hash function to get the index for a key. If the index is empty
 * we assign a dummy (-1,-1) node that link it to the new node having our key value pair. We attach subsequent nodes to this linkedlist. For remove, we iterate through this linked list until we find our key and remove it from the list.
 * We do the same iteration, that is, if the array element at index is not null, we iterate through the linked list and if element is found we return it's value. 
 */

//https://leetcode.com/problems/design-hashmap/description/
class HashMap {
    Node[] myHashMap;
    class Node{
        int key;
        int value;
        Node next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    public HashMap() {
        myHashMap = new Node[10000];
    }

    public int getIndex(int key){
        return key%10000;
    }
    
    public void put(int key, int value) {
        int index = getIndex(key);
        if(myHashMap[index]==null){
            Node node = new Node(-1,-1);
            myHashMap[index]=node;
        }
        Node prev=null;
        Node curr=myHashMap[index];
        while(curr.next!=null && curr.key!=key){
            prev = curr;
            curr=curr.next;
        }
        if(curr.key==key){
            curr.value = value;
        }else{
            Node myNode = new Node(key, value);
            curr.next = myNode;
        }
    }
    
    public int get(int key) {
        int index = getIndex(key);
        if(myHashMap[index]==null){
            return -1;
        }
        Node prev=null;
        Node curr=myHashMap[index];
        while(curr.next!=null && curr.key!=key){
            prev = curr;
            curr=curr.next;
        }
        if(curr.key==key){
            return curr.value;
        }else{
            return -1;
        }
    }
    
    public void remove(int key) {
        int index = getIndex(key);
        if(myHashMap[index]!=null){
            Node prev=null;
            Node curr=myHashMap[index];
            while(curr.next!=null && curr.key!=key){
                prev = curr;
                curr=curr.next;
            }
            if(curr.key==key){
                prev.next=curr.next;
            }
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