//Time Complexity: O(1) for all the operations
// Space Complexity : O(1) for all the operations


class MyHashMap {
    class Node {
        int key;
        int value; 
        Node next;
        Node(int key, int value) {
          this.key = key;
          this.value = value;
        }
    }
    Node []myarray;
    public MyHashMap() {
        this.myarray = new Node[10000];
    }
    Node find(Node head, int key ) {
        Node prev = null;
        Node temp = head;
        while(temp != null && temp.key != key) {
               prev = temp;
               temp = temp.next;
        }
        return prev;
    }
    int hash(int key) {
        return key%10000;
    }
    public void put(int key, int value) {
        int index = hash(key);
        if(myarray[index] == null) {
            myarray[index] = new Node(-1,-1);
        }
        Node prev = find(myarray[index],key);
        if(prev.next == null) {
            prev.next = new Node(key,value);
        } else {
            prev.next.value = value;
        }
    }
    
    public int get(int key) {
        int index = hash(key); 
        if(myarray[index] == null) {
            return -1;
        }
       Node prev = find(myarray[index],key);
       if(prev.next == null) {
           return -1;
    }
    return prev.next.value;
    }
    
    public void remove(int key) {
        int index = hash(key); 
        if(myarray[index] == null) {
            return;
        }
        Node prev = find(myarray[index],key);
        Node temp = prev.next;
        prev.next = prev.next.next;
        temp.next = null;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */