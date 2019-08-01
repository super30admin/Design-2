/**
 * Implementing DoubleHashing approach to design HashSet
 * @author Manogna
 */
public class HashSet {
	int buckets = 100;
	int bucketItems = 100;
	boolean [][] storage;
	
	//Hashcode to determine bucketIndex
	private int bucket(int key) {
		return key%buckets;
	}
	
	//Hashcode to determine bucketItemIndex
	private int bucketItem(int key) {
		return key/buckets;
	}

	/** Initialize your data structure here. */
    public HashSet() {
    		// All items in an boolean array allocated by new are by default initialized to false
    		storage = new boolean[buckets][bucketItems];
    }
    
    public void add(int key) {
         int bucketIndex = bucket(key);
         int buckeItemIndex = bucketItem(key);
         //Just turn the false item to true to store its presence.
         //Doesn't matter if its already true.
         storage[bucketIndex][buckeItemIndex] = true;
    }
    
    public void remove(int key) {
    		int bucketIndex = bucket(key);
        int buckeItemIndex = bucketItem(key);
        	if(storage[bucketIndex][buckeItemIndex] == true) {
        		storage[bucketIndex][buckeItemIndex] = false;
        } else {
        		System.out.println("Item does not exist!");
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
    		int bucketIndex = bucket(key);
        int buckeItemIndex = bucketItem(key);
        return storage[bucketIndex][buckeItemIndex];
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet hs = new HashSet();
		hs.add(12);
		hs.add(10);
		hs.add(7);
		hs.remove(10);
		System.out.println("Does it contain 12?" + hs.contains(12));
		hs.add(12);
	}
}
