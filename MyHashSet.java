package test11;

/*
 * Simple HashSet implementation using fixed size object array
 * Doesn't handle collisions.
 */
public class MyHashSet {

	// assuming max size of 4K
	// won't be enough to guarantee collision free index
	int numBuckets = 4096;
	Object[] hashset = new Object[numBuckets+1];
	
	
	//Driver code
    public static void main(String[] args) 
    { 
  
        MyHashSet hashSet = new MyHashSet(); 
        hashSet.add(1);
        hashSet.add(2);
        System.out.println("Contains? " +hashSet.contains(1));
        System.out.println("Contains? " +hashSet.contains(3));
        hashSet.add(2);
        System.out.println("Contains? " +hashSet.contains(2));
        hashSet.remove(2);
        System.out.println("Contains? " +hashSet.contains(2));
        

    } 
    
    /*
     * 
     */
    public MyHashSet() {
    	
    }
    
	public void add(Object value) {		
		
		// using built java function to compute hashcode
		// and applying modulus to get index
		int index = value.hashCode()%numBuckets;
		
		if (hashset[index] != null) {
			hashset[index] = value;		
		} else {
			System.out.println("Value "+value+" already found");
		}
		
	}
	

	public void remove(Object value) {		
		// using built java function to compute hashcode
		// and applying modulus to get index
		int index = value.hashCode()%numBuckets;

		if (hashset[index]  != null) {
			hashset[index] = null;		
		} else {
			System.out.println("Value "+value +" not found in hashset");
		}

	}

	public boolean contains(Integer value) {
	
		// using built java function to compute hashcode
		// and applying modulus to get index
		int index = value.hashCode()%numBuckets;
		
		if (hashset[index] != null) {
			return true;
		}

		return false;
	}

}
