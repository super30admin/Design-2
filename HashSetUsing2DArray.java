class HashSet2DArray {
  
   public int outerArray = 1000;
   public int innerArray = 1000;
   public boolean[][] bucket = new boolean[outerArray][];
    
    public int hashCode(int key){
        int hash = key % outerArray;
        return hash;
    }
    
     public int pos(int key){
        int position = key / outerArray;
         return position;
    }
    
    
    public void add(int key)
    {
        int hash = hashCode(key);
        if(bucket[hash] == null){
            bucket[hash] = new boolean[innerArray];
        }
            bucket[hash][pos(key)] = true;
            System.out.println("added key="+key);
    }
    
    public void remove(int key) {
       int hash = hashCode(key);
        if(bucket[hash] == null){
            return;
        }
            bucket[hash][pos(key)] = false;
            System.out.println("removed key="+key);
        
    }
    
 
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int hash = hashCode(key);
        System.out.println("contains key?"+key);
        boolean flag = bucket[hash]!=null && (bucket[hash][pos(key)]);
        System.out.println("result ="+flag);
        return flag;
    }
}


public class HashSetUsing2DArray {
	public static void main(String[] args) {
	HashSet2DArray set = new HashSet2DArray();
	set.add(10);
	set.add(20);
	set.add(30);
	set.add(40);
	set.remove(30);
	set.contains(20);
	}
}
