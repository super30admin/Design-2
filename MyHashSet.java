
public class MyHashSet {
    ArrayList<Integer> hashSet = new ArrayList<Integer>();
    
    

    public MyHashSet() {
        this.hashSet = new ArrayList<Integer>();
    
    }
    
    public void add(int key) {
      
hashSet.add(key);            
            
        
        
    }
    
    public void remove(int key) {
        Iterator i = hashSet.iterator();
        while ( i.hasNext()){
            if ( i.next().equals(key)){
                i.remove();
            }
        }
    }
    
    public boolean contains(int key) {
        for( int i = 0; i < hashSet.size(); i++){
           if (hashSet.get(i).equals(key))
               return true;
        }
        return false;
            
        
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
