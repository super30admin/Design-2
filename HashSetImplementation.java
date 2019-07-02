//Hashset implementation using linked List. Reference Leetcode solutions.

class UserDefinedHashSet {
	    // initializing array of linnkedList to 10000
	    final  ListNode[] nodes =  new ListNode[10000];
	    
	    //default constructor
	    UserDefinedHashSet(){
	    	
	    }
	    
	    //class ListNode which contains element of hashset and pointer to next node in linnkedlist
	    class ListNode{
	     int key;
	     ListNode next;
	     ListNode(int k){
	         this.key = k;
	     }
	    }
	    
	    //add unique  element into hashset
	    public void add(int key)
	    {
	        int index = hashCode(key);
	        //if node at index is null then create new node with initial value as -1.
	        if(nodes[index] == null){
	             nodes[index] =  new ListNode(-1);
	        }
	        
	        // find previous node of nodes[index] in linked list
	        ListNode prev = find(nodes[index], key);
	        
	        //if prev is last node in linked list then add new node at the end of linkedlist
	        if(prev.next == null){
	           prev.next = new ListNode(key); 
	           System.out.println("addded element = "+key);
	           
	        }else {
	        	//if element already exist in hashset then update the value which is same.
	            prev.next.key = key;
	            System.out.println("Element already present = "+key);
	        }   
	    }
	    
	    // remove element from hashset
	    public void remove(int key) {
	    	//find out hashcode of given key 
	        int index = hashCode(key);
	        
	        // if node is null the do nothing
	        if(nodes[index] == null) {
	        	System.out.println("hashset is empty = "+key);
	        	return;
	        }
	        ListNode prev = find(nodes[index], key);
	        // element is not found after searching till end of linked list.
	        if(prev.next == null) {
	        	System.out.println("element not found = "+key);
	        	return;
	        }
	        //if lement found then assigning previous element next to deleted element's next
	        prev.next = prev.next.next;
	        System.out.println("removed element = "+key);
	        
	        
	    }
	    
	 
	    
	    /** Returns true if this set contains the specified element */
	    public boolean contains(int key) {
	    	//find out hashcode of given key
	        int index = hashCode(key);
	        
	        System.out.println("Is Hashset contains key ="+key);
	        //if node at index is null then return false
	        if(nodes[index] ==  null) return false;
	        //find out previous element of key element
	        ListNode prev = find(nodes[index], key);
	        
	        //key element is not found return false
	        if(prev.next == null) return false;
	        
	        else return true;
	   
	    }
	    
	    //returns hashcode of given key
	       public int hashCode(int key){
	        return Integer.hashCode(key)%nodes.length;
	    }
	    
	       //returns previous element of given key element inside linkedlist
	       public ListNode find(ListNode bucket, int key){
	        ListNode node = bucket;
	        ListNode prev = null;
	        while(node!=null && node.key!=key){
	            prev =  node;
	            node = node.next;
	        }
	        
	        return prev;
	        
	    }
	}

	public class HashSetImplementation {
		public static void main(String args[]) {
			UserDefinedHashSet set = new UserDefinedHashSet();
			set.add(10);
			set.add(20);
			set.add(30);
			set.add(10);
			set.add(10);
			set.add(10);
			boolean result =set.contains(20);
			System.out.println("Hashset contains key result =:"+result);
			set.remove(10);
			
	}
}
	
