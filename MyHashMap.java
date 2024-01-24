// Time Complexity : for all operations O(1)
// Space Complexity : for all operations O(n)
// Did this code successfully run on Leetcode : Yes

// Any problem you faced while coding this : Yes
/*
 * Since I'm using the same approach as MyHashSet implementation 
 * One Test case failed where value is Zero since I was treating Zero has null in my solution
 * To over come this I have added a logic that If value is Zero push "-2" and while doing get check if "-2" then return Zero 
 */


// Your code here along with comments explaining your approach
/*
 * I've used MyHashset implementation
 * 
 * When doing put()
 * I'm putting "-1" when value not found
 * 
 * When doing get()
 * I return "-1"         when 
 * bucket is empty[Null] OR 
 * value  is "-1"        OR 
 * value  is "Zero" [Treating Zero as NULL since "0" is default value for int []]
 * Added a check 
 * If value is "-2" I return "Zero"
 * 
 * When doing put()
 * Added a check
 * If value is Zero, I put "-2" since I'm considering Zero as Null [default value for int[]]
 * 
 * Rest everything is similar to MyHashSet implementation taught in the class 
 */

class MyHashMap {

    private int buckets;
    private int bucketItems;
    private int [][] storage;
    public MyHashMap() {
        int size = (int) Math.ceil(Math.sqrt(Math.pow(10, 6))) + 1;
        buckets = size;
        bucketItems = size;
        storage = new int [buckets][bucketItems];
    }
    
    private int bucket(int key) {
        return key % buckets;
    }

    private int bucketItem(int key) {
        return key / bucketItems;
    }

    public void put(int key, int value) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        
        if (storage[bucket] == null) {
            storage[bucket] = new int [bucketItems];
        }

        if(value == 0) {
            storage[bucket][bucketItem] = -2;
            return;
        }

        storage[bucket][bucketItem] = value;

    }
    
    public int get(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if(key == 11) {
            if ((storage[bucket] != null)) {
                System.out.println(storage[bucket][bucketItem]);
            }
        }
        if ((storage[bucket] == null) || (storage[bucket][bucketItem] == -1) || (storage[bucket][bucketItem] == 0)) {
            return -1;
        }

        return storage[bucket][bucketItem] == -2 ? 0 : storage[bucket][bucketItem];
    }
    
    public void remove(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);

        if ((storage[bucket] == null) || (storage[bucket][bucketItem] == -1)) {
            return;
        } else {
            storage[bucket][bucketItem] = -1;
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