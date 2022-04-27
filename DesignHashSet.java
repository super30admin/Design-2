class MyHashSet {
    
    int first_size = 1000;
    int second_size = 1000;
    
    boolean array[][] = new boolean[first_size][];
    
    public int first_hash(int val){
        return val%first_size;
    }
    public int second_hash(int val){
        return val/first_size;
    }
    
    public MyHashSet() {
        
    }
    
    public void add(int key) {
        int first = first_hash(key);
        int second = second_hash(key);
        
        if(array[first]==null){
            array[first] = new boolean[second_size];
        }
        array[first][second]= true;
    }
    
    public void remove(int key) {
        int first = first_hash(key);
        int second = second_hash(key);
        if(array[first]!=null){
            array[first][second]= false;
        }
    }
    
    public boolean contains(int key) {
        int first = first_hash(key);
        int second = second_hash(key);
        
        return array[first]!=null && array[first][second];
    }
}
