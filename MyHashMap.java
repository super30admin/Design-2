// Time Complexity : O(1) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

public class MyHashMap {
	
	int MAX = 1000000;
	Node[] storage ;
	int bucketSize;

	public MyHashMap() {
		   this.bucketSize = MAX/100;
		   this.storage = new Node[bucketSize];
	}
	   
	class Node{
		int key;
		int value;
		Node next;
		
		public Node(int key, int value)
		{
			this.key = key;
			this.value = value;
			this.next = null;
		}
	}
	
  
   private int hashIndex(int key)
   {
	   return key % this.bucketSize;
   }
   
   private Node findPrevNode(Node head, int key)
   {
   	Node prevNode = null;
   	Node currentNode = head;
   	while(currentNode != null && currentNode.key != key) 
   	{
   		prevNode = currentNode;
   		currentNode = currentNode.next; 
   	}
   	return prevNode;
    }
   
     public void put(int key, int value) 
     {
    	int bucket = hashIndex(key);
    	if(storage[bucket] == null)
    	{
    		storage[bucket] = new Node(-1,-1);
     	}
    	Node prevNode = findPrevNode(storage[bucket], key);
    	if(prevNode.next == null)
    		prevNode.next = new Node(key, value);
    	else
    		prevNode.next.value = value;
    	
    }
   
    public int get(int key) {
    	int bucket = hashIndex(key);
    	if(storage[bucket] == null)
    	{
    		return -1;
    	}
    	else
    	{
    		Node prevNode = findPrevNode(storage[bucket], key);
    		if(prevNode.next == null) 
    			return -1;
    		return prevNode.next.value;
    	}
        
    }
    
    public void remove(int key) {
    	int bucket = hashIndex(key);
    	if(storage[bucket] == null)
    	{
    		return;
    	}
    	else
    	{
    		Node prevNode = findPrevNode(storage[bucket], key);
    		if(prevNode.next == null)
    			return;
    		else prevNode.next = prevNode.next.next;
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