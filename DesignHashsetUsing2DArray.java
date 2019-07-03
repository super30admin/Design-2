
public class DesignHashsetUsing2DArray {
	private int array = 1000;
	private int itemsPerArray = 1001;
	private boolean[][] table;

	public DesignHashsetUsing2DArray() {
		table = new boolean[array][];
	}

	// to find the number of row of matrix array
	public int hashValue(int key) {
		return array % key;
	}
	
	// to find the number of column of matrix array
	public int position(int key) {
		return array / key;
	}
	
	
	public void add(int key) {
		int hashKey = hashValue(key);	
		if(table[hashKey] == null) {
			table[hashKey] = new boolean [itemsPerArray];
			}
		table[hashKey][position(key)] = true;
	}

	public void remove(int key) {
		int hashKey = hashValue(key);	
		if(table[hashKey] != null) {
			table[hashKey][position(key)] = false;
			}
	}
	
	public boolean contains(int key) {
		int hashKey = hashValue(key);
		return table[hashKey] != null && table[hashKey][position(key)];
	}
	
	//Driver code 
	 public static void main(String[] args) 
	    { 
		 DesignHashsetUsing2DArray h = new DesignHashsetUsing2DArray(); 
	        h.add(1); 
	        h.add(2); 
	        h.contains(1); 
	        h.contains(3); 
	        h.add(2); 
	        h.contains(2);
	        h.remove(2); 
	        h.contains(2);
	         
	        
	       
	    }

}
