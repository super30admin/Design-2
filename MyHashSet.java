import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MyHashSet {
	

    /** Initialize your data structure here. */
    
    private int bucket;
    private int bucketItem;
    private boolean[][] storage;
    
    
    public MyHashSet() {
        
        this.bucket=1000;
        this.bucketItem=1001;
        storage= new boolean[bucket][];
        
    }
    
    public void add(int key) {
        
        int index= key % bucket;
        int indexTwo= key / bucketItem;
        
        if(storage[index]==null){
            
            storage[index]= new boolean[bucketItem];
            
            
        }
        
        storage[index][indexTwo]= true;
        
    }
    
    public void remove(int key) {
        
        int index= key % bucket;
        int indexTwo= key / bucketItem;
        
        if(storage[index]==null){
            return;
        }
        
        storage[index][indexTwo] =false;
        
        
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        
           int index= key % bucket;
           int indexTwo= key / bucketItem;
        
           if(storage[index]==null)
               return false;
        
        return storage[index][indexTwo];
        
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
