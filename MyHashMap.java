/**
 * 
 */

/**
 * @author Aditya Sinha
 *
 */
//we will follow Linear chaining approach for avoiding collision
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : Yes
public class MyHashMap {

	Node[] storage;
    int buckets;

    class Node{
        int key;
        int value;
        Node next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    
    public MyHashMap() {
        this.buckets = 1000;
        this.storage = new Node[buckets];
    }
    
    private int getHash(int key){
        return key % buckets;
    }

    private Node getPrev(Node head, int key){
        Node prev = null;
        Node curr = head;
        while(curr != null && curr.key != key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    
    public void put(int key, int value) { // time complexity - O(1)
        int index = getHash(key);
        if(storage[index] == null){
            storage[index] = new Node(-1, -1); // create a dummy node at -1 to maintain previous node
            storage[index].next = new Node(key, value);
            return;
        }

        Node prev = getPrev(storage[index], key);
        if(prev.next == null){ 
            prev.next = new Node(key, value);
        }else{ 
            prev.next.value = value;
        }
    }
    
    public int get(int key) { // time complexity - O(1)
        int index = getHash(key);
        if(storage[index] == null) return -1;
        Node prev = getPrev(storage[index], key);
        if(prev.next == null) return -1;
        return prev.next.value;
    }
    
    public void remove(int key) { // time complexity - O(1)
        int index = getHash(key);
        if(storage[index] == null) return;
        Node prev = getPrev(storage[index], key);
        if(prev.next == null) return;
        Node curr = prev.next;
        prev.next = curr.next;
        curr.next = null;
    }
}

//Driver code 
class MainMyHashMap { 
public static void main(String args[]) 
{ 
	MyHashMap obj = new MyHashMap();
	 obj.put(20001, 20);
	 obj.put(10001, 10);
	 obj.put(20004, 24);
	 obj.put(30004, 34);
	 System.out.println("value of 20001 - " + obj.get(20001));
	 System.out.println("value of 10001 - " + obj.get(10001));
	 System.out.println("value of 20004 - " + obj.get(20004));
	 System.out.println("value of 30004 - " + obj.get(30004));
	 obj.remove(30004);
	 System.out.println("value of 30004 - " + obj.get(30004));

} 
}
