import java.lang.Integer;

class MyHashMap {
	private int sizeOfPrim;
	private int sizeOfSec;
	private Integer [][] nested;

    public MyHashMap() {
        this.sizeOfPrim = 1000;
        this.sizeOfSec = 1000;
        this.nested = new Integer [sizeOfPrim][];
    }
    
    private int hash1(int key) {
    	return key%sizeOfPrim;
    }
    
    private int hash2(int key) {
    	return key/sizeOfSec;
    }
    
    public void put(int key, int value) {
        int primAddr = hash1(key);
        int secAddr = hash2(key);
        if (nested[primAddr] == null)
        {
        	if(primAddr == 0)
        	{
        		nested[primAddr] = new Integer [sizeOfSec+1];
        	}
        	else {
        		nested[primAddr] = new Integer [sizeOfSec];
        	}
  
        }
        nested[primAddr][secAddr] = value;
    }
    
    public int get(int key) {
    	int primAddr = hash1(key);
        int secAddr = hash2(key);
        if (nested[primAddr] == null)
        {
        	return -1;
        }
        if (nested[primAddr][secAddr] == null)
        {
        	return -1;
        	
        }
       return nested[primAddr][secAddr];
    }
    
    public void remove(int key) {
    	int primAddr = hash1(key);
        int secAddr = hash2(key);
        if (nested[primAddr] == null)
        {
        	return;
        }
        nested[primAddr][secAddr] =  null;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */