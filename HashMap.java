class MyHashMap {
	
	private Node [] storage;

	class Node {
		int key;
		int val;
		Node next;
		public Node(int key, int val) {
			this.key= key;
			this.val= val;
		}
	}
    public MyHashMap() {
    	this.storage = new Node[10000];
        
    }
    //hash function for primary array
    private int hash1 (int key) {
    	int idx = key%10000;
    	return idx;
    }
  //no second hash func bcz we are creating a array list in case of hashmap
    private Node find(Node head, int key) {
    	Node prev = head;
    	Node cur = head.next;
    	while(cur!=null && cur.key != key)	{
    		prev = cur;
    		cur= cur.next;
    	}
    	return prev;
    }
    public void put(int key, int value) {
    	int idx = hash1(key);
    	if(storage[idx] == null)	{
    		storage[idx] = new Node(-1,-1);
    	}
    	//check if key is there
    	Node prev = find(storage[idx],key);
    	if(prev.next == null)	{
    		//reached end of list and key was not found..#creating new node
    		prev.next = new Node(key,value);
    	} else	{
    		//key has been found update node with new value
    		prev.next.val = value;
    	}	
    }
    
    public int get(int key) {
        int idx1 = hash1(key);
        if(storage[idx1] == null) return -1;//no array list assigned yet
        Node prev = find(storage[idx1],key);
        if(prev.next == null) return -1;
        return(prev.next.val);
        
    }
    
    public void remove(int key) {
        int idx = hash1(key);
        if(storage[idx]==null) return;
        Node prev = find(storage[idx], key);
        if(prev.next == null) return;
        	Node del = prev.next;
        	prev.next= prev.next.next;
        	del.next = null;//orpahned the node to be deleted
        
    }
    

}