import java.util.*;
public class HashsetUsingArray {
	
	    List<Integer> list; 
	    boolean arr[];
	    /** Initialize your data structure here. */
	    public HashsetUsingArray() {
	         list = new ArrayList<>();
	        arr = new boolean[1000000];
	    }
	    
	    public void add(int key) {
	        if(!arr[key]) {
	            list.add(key);
	        }
	        arr[key] = true;
	    }
	    
	    public void remove(int key) {
	        if(arr[key]) {
	            arr[key] = false;
	        }
	    }
	    

	    /** Returns true if this set contains the specified element */
	    public boolean contains(int key) {
	        if(arr[key])
	            return true;
	        return false;
	    }
	    
	    public static void main(String args[]) {
	    	HashsetUsingArray set = new HashsetUsingArray();
			set.add(10);
			set.contains(20);
			set.add(30);
			set.contains(10);
			set.remove(10);
			set.add(10);
			boolean result =set.contains(40);
			System.out.println("Hashset contains key result =:"+result);
			set.remove(10);
			
	}
}
