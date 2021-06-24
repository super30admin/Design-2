/*
  time complexity: 
  add(element) -> O(1)
  remove(element) -> O(1)
  contains(element) -> O(n);

  Space Complexity: O(n);
*/

/* Solution passes all the test cases on leetcode */

/* Approach:
   1. Create a fixed set of buckets, to do so create a list 
   2. Map the input values to these buckets
   3. To handle collisions, use a list of values that are mapping to each bucket, 
      therefore use list of a list to represent the bucket(list of buckets) and the mapped values(list of 
      mapped values to the list of buckets)
   4. Initialise the list of buckets
   5. Add - 
        i. Get the list of values mapping to calculated hash index (bucket)
        ii. If the list of values is not present for the calculated bucket then 
        create a new list and add the element to that list and add the value list 
         at that paerticular index
        iii. If the valueList contains the element already then do not add the value
        if it does not contain the element, then add the value to the valueList   
   6. Remove -
        i. Get the index of the bucket
        ii. Get the associated mapped values of the bucket
        iii. If the valueList is not null then remove the specified element from the valueList
   7. Contains -
        i. Get the index of the bucket
        ii. Get the associated mapped values for the bucket
        iii. Check if the mapped values are not null and valueList contains given specified element
        then if both these conditions are true then return the element           
 */      

class MyHashSet {

    /** Initialize your data structure here. */
     private final int MAX_VALUE = 1000000;
        private final int ARRAY_SIZE = 100;
        private List<List<Integer>> bucketList;
    public MyHashSet() {
        bucketList  = new ArrayList<>(ARRAY_SIZE);
        for(int i = 0 ; i < ARRAY_SIZE; i++){
            bucketList.add(null); 
        }
    }
    
    public void add(int key) {
       int bucketIndex = key % ARRAY_SIZE;
       List<Integer> valueList = bucketList.get(bucketIndex);
       if(valueList == null) {
           List<Integer> values = new LinkedList<>();
           values.add(key);
           bucketList.set(bucketIndex, values);
           
       } 
        else {
            if(!valueList.contains(key)){
                valueList.add(key);
            }
        }
    }
    
    public void remove(int key) {
        int bucketIndex = key % ARRAY_SIZE;
        List<Integer> valueList = bucketList.get(bucketIndex);
        if(valueList != null){
            valueList.remove(Integer.valueOf(key));
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
     int bucketIndex = key % ARRAY_SIZE;
      List<Integer> valueList = bucketList.get(bucketIndex);
        return valueList != null && valueList.contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */