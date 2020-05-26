class MyHashSet {
    //HashSet Using Matrix and Double Hashing
    boolean[][] matrix;
    int buckets;
    int bucketItems;
    /** Initialize your data structure here. */
    public MyHashSet() {
        buckets=1000;
        bucketItems=1001;
        matrix=new boolean[buckets][];

    }
    
    private int hashBucket(int key)
    {
        return key%buckets;
    }
    
     private int hashBucketItems(int key)
    {
        return key/bucketItems;
    }
    
    public void add(int key) {
         int row=hashBucket(key);
         int column=hashBucketItems(key);
         if(matrix[row]==null)
         {
             matrix[row]=new boolean[bucketItems];
         }
        matrix[row][column]=true;
        
    }
    
    public void remove(int key) {
         int row=hashBucket(key);
         int column=hashBucketItems(key);
         if(matrix[row]!=null)
         {
            matrix[row][column]=false;  
         }
       
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
         int row=hashBucket(key);
         int column=hashBucketItems(key);
         if(matrix[row]!=null)
         {
            return matrix[row][column];
             
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