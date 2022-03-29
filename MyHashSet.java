
public class MyHashSet {
    /*
     * Time Complexity:
     * Space Complexity: 
     * Author: Aditya Mulik
     */


    public MyHashSet() {

    }

    public void add(int key) {
        
    }
    
    public void remove(int key) {
        
    }
    
    public boolean contains(int key) {
        return true;    
    }

    public static void main(String[] args) {
        MyHashSet hashSet = new MyHashSet();
	System.out.println("MyHashSet");

	hashSet.add(1);
	hashSet.add(2);
	hashSet.contains(1);
	hashSet.contains(3);
	hashSet.add(2);
	hashSet.contains(2);
	hashSet.remove(2);
    }
}
