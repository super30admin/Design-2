// - The row index (outer index) represents `key % 1000` (hash bucket).
// - The column index (inner index) represents `key / 1000` (position within the bucket).
// - This ensures efficient storage and lookup while reducing space usage.
// Time complexities:
// - put: O(1)
// - get: O(1)
// - remove: O(1)

class MyHashMap {
    int[][] hashMap;
    int buckets = 1000;
    int bucketSize = 1000;
       public MyHashMap() {
           hashMap = new int[buckets][];
       }
       public int outerKey(int key){
           return key%1000;
       }
       public int innerKey(int key){
           return key/1000;
       }
   
       public void fillNegatives(int[] arrayCopy){
           for(int i=0; i<arrayCopy.length; i++){
               arrayCopy[i] = -1;
           }
       }
   
       public void put(int key, int value) {
           int outerKeyValue = outerKey(key);
           if(hashMap[outerKeyValue] == null){
               if(outerKeyValue == 0){
                   hashMap[outerKeyValue] = new int[bucketSize+1];
               } else {
                   hashMap[outerKeyValue] = new int[bucketSize];
               }
               fillNegatives(hashMap[outerKeyValue]);
           }
           hashMap[outerKeyValue][innerKey(key)] = value;
       }
       
       public int get(int key) {
           int outerKeyValue = outerKey(key);
           if(hashMap[outerKeyValue] == null){
               return -1;
           } else {
               return hashMap[outerKeyValue][innerKey(key)];
           }
       }
       
       public void remove(int key) {
           int outerKeyValue = outerKey(key);
           if(hashMap[outerKeyValue] == null){
               return;
           } else {
               hashMap[outerKeyValue][innerKey(key)] = -1;
           }
       }
   }
   
   /**
    * Your MyHashMap object will be instantiated and called as such:
    * MyHashMap obj = new MyHashMap();
    * obj.put(key,value);
    * int param_2 = obj.get(key);
    * obj.remove(key);
    */