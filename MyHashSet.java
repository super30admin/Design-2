import java.util.ArrayList;
import java.util.List;

public class MyHashSet {
	private int bucketSize;
	private List<Integer> bucketList;
	
	public MyHashSet() {
        this.bucketSize=1000;
        this.bucketList = new ArrayList<>(bucketSize);        
    }
    
    public void add(int key) {
        int index= (key%bucketSize);
        bucketList.add(index, key);
    }
    
    public void remove(int key) {
        int index= (key%bucketSize);
        bucketList.remove(index);
    }
    
    public boolean contains(int key) {
    	return bucketList.contains(key);
    }
	
	public static void main(String[] args) {
		MyHashSet hashSet = new MyHashSet();
		hashSet.add(1);
		hashSet.add(2);
		hashSet.contains(1); // returns true
		hashSet.contains(3); // returns false (not found)
		hashSet.add(2);
		hashSet.contains(2); // returns true
		hashSet.remove(2);
		hashSet.contains(2); // returns false (already removed)
	}
	/**Time O(n) | Space O(n)**/
}
