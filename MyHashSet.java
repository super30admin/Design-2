import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MyHashSet {
	
		    /** Initialize your data structure here. */
	    
	            
	        private final int MAX_VALUE=1000000;
	        private final int ARRAY_SIZE=100;
	        private List<List<Integer>> parentList;
	    
	    
	    public MyHashSet() {
	        
	        parentList = new ArrayList<>(ARRAY_SIZE);
	        for(int i=0;i<ARRAY_SIZE;i++)
	            parentList.add(null);     
	        
	    }
	    
	    public void add(int key) {
	        
	        int index= key % ARRAY_SIZE;
	        List<Integer> childList= parentList.get(index);
	        if(childList == null){
	            List<Integer> list= new LinkedList();
	            list.add(key);
	            parentList.set(index,list);
	        }
	        else{
	            
	            if(!childList.contains(key))
	                    childList.add(key);
	        }
	     
	    }
	    
	    public void remove(int key) {
	        
	        int index= key % ARRAY_SIZE;
	        List<Integer> childList= parentList.get(index);
	        if(childList != null){
	            
	            childList.remove(Integer.valueOf(key));
	        }
	        
	        
	    }
	    
	    /** Returns true if this set contains the specified element */
	    public boolean contains(int key) {
	        
	        int index= key % ARRAY_SIZE;
	        List<Integer> childList= parentList.get(index);
	     
	        return (childList!=null && childList.contains(key));
	        
	     }
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub.
		
		
		MyHashSet hashSet = new MyHashSet();
		hashSet.add(1);         
		hashSet.add(2);         
		System.out.println(hashSet.contains(1));    // returns true
		System.out.println(hashSet.contains(3));    // returns false (not found)
		hashSet.add(2);          
		System.out.println(hashSet.contains(2));    // returns true
		hashSet.remove(2);          
		System.out.println(hashSet.contains(2));    // returns false (already removed)

	}

}
