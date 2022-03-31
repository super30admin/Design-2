package design2;
//time complexity: put: O(1), get: O(1), remove: O(1)
//space complexity: O(n)

public class MyHashMap {
	int array[] = new int[1000010];
    public MyHashMap() {}
    
    public void put(int key, int value) {
    	array[key] = value + 1;
    }
    
    public int get(int key) {
    	System.out.println("key= "+array[key]);
    	return array[key] - 1;
    }
    
    public void remove(int key) {
    	array[key] = 0;
    }
    
    public static void main(String args[]) {
    	MyHashMap hashmap = new MyHashMap();
	    hashmap.put(0,1);
	    hashmap.put(1,2);
	    hashmap.put(2,3);
	    hashmap.put(4,4);
	    hashmap.put(4,2);
	    System.out.println("get: key2: "+hashmap.get(2)); 
	    hashmap.remove(3); 
	    System.out.println("get: key3: "+hashmap.get(3)); 
	    System.out.println("get: key4: "+hashmap.get(4));
    }
}
