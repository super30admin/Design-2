// Time Complexity : put -> 0(1), get -> 0(1), remove -> 0(1)
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No


//Use linked list to store the elements, the primary array acts as a reference to the head of the linked list. 
//use helper search function to modularize the code, remember the search function returns the previous node when the (key,value) pair is found


class MyHashMap {

    class Node{
        int key;
        int value;
        Node next;
        Node(int key, int value){
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

 

    Node arr[];

    public MyHashMap() {
        arr = new Node[10000];
    }

    private int hashF(int key){
        return key % 10000;
    }

    //this returns the prev node
    private Node search( Node head, int key){
        Node prev = null;
        Node curr = head;
        while(curr!=null && curr.key != key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    public void put(int key, int value) {
        int idx = hashF(key);
        if (arr[idx] == null){
            arr[idx]= new Node(-1,-1); //if primary array has null, means it's the first instance for that LL
        }
        Node prev = search(arr[idx],key);
        if (prev.next == null){
            prev.next = new Node(key,value); //if it is the tail of the linkedlist or its a new LL
        }
        else{
            prev.next.value = value; //in general case if it already exists
        }


    }
    
    public int get(int key) {
        int idx = hashF(key);
        if (arr[idx] != null){
            Node prev = search(arr[idx],key);
            if (prev.next!=null){
                return prev.next.value;
            }
        }
        return -1;
    }
    
    public void remove(int key) {
        int idx = hashF(key);
        if(arr[idx]!=null){
            Node prev = search(arr[idx],key);
            if(prev.next != null){
                Node temp = prev.next;
                prev.next=prev.next.next;
                temp.next=null;
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