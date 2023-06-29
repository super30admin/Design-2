/*
 * Time Complexity: 
 * put, find, get, remove - ammortized O(1)
 * Space Complexity:
 * O(N)
 */
public class MyHashMap {
    class Node{
        int key;
        int val;
        Node next;
        Node(int key, int val){
            this.key = key;
            this.val = val;
            this.next = null;
        }
    }

    Node[] store;

    public MyHashMap() {
        this.store = new Node[10000];
    }

    private int hashFn(int key){
        return key%10000;
    }
    
    public void put(int key, int value) {
        int index = hashFn(key);
        if(this.store[index] == null){
            this.store[index] = new Node(-1, -1);
        }
        Node prev = find(key, this.store[index]);
        if(prev.next !=null){
            prev.next.val = value; 
            return;
        }
        Node newNode = new Node(key, value);
        newNode.next = this.store[index].next;
        this.store[index].next = newNode;
    }
    
    public Node find(int key, Node Head){
        Node prev = Head;
        Node curr = Head.next;
        while(curr!=null && curr.key!=key){
            curr = curr.next;
            prev = prev.next;
        }
        return prev;
    }
    public int get(int key) {
        int index = hashFn(key);
        if(this.store[index] == null)
            return -1;
        
        Node prev = find(key, this.store[index]);
        if(prev.next != null){
            return prev.next.val;
        }
        return -1;
    }
    
    public void remove(int key) {
        int index = hashFn(key);
        if(this.store[index] == null){
            return;
        }
        Node prev = find(key, this.store[index]);
        if(prev.next!= null){
           Node curr = prev.next;
           prev.next = curr.next;
           curr.next = null; 
        }
    }

    public static void main(String[] args){
        MyHashMap obj = new MyHashMap();
        int key = 10;
        int value = 100;
        obj.put(key,value);
        System.out.println(obj.get(key));
        obj.remove(key);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */