//Implemented using double hashing technique
// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : NO
// Any problem you faced while coding this : YES TEST CASES FAILED

/**
 *  I have two solutions :
 *  1. Using array
 *  2. Using double Hashing technique which Sir suggested to solve in ( THis fails a few test cases on leetcode)
 *
 */

/**
 * OUTPUT:
 * 1
 * -1
 * 1
 * -1
 */


// Your code here along with comments explaining your approach

/***
 * THIS ONE IS USING DOUBLE HASHING TECHNIQUE
 * THE BELOW CODE SAYS AS Wrong Answer
 * 27 / 36 testcases passed
 * Could you please suggest on what exactly is not correct in this code?
 */
public class DesignHashmapUsingDoubleHashing {

    class KeyValuePair {
        int value;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    int buckets;
    int bucketItems;
    KeyValuePair[][] storage;

    public DesignHashmapUsingDoubleHashing() {
        buckets = 1000;
        bucketItems = 1000;
        storage = new KeyValuePair[buckets][];
    }

    public int getBucket(int key) {
        return key % buckets;
    }

    //getbucketitem
    public int getBucketItem(int key) {
        return key % bucketItems;
    }

    //put
    public void put(int key, int value) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if (storage[bucket] == null) {
            if(bucket == 0) {
                storage[bucket] = new KeyValuePair[bucketItems+1];
            }
            else{
                storage[bucket] = new KeyValuePair[bucketItems];
            }
        }
        KeyValuePair kvp = new KeyValuePair();
        kvp.setValue(value);
        storage[bucket][bucketItem]= kvp;
    }

    //get
    public int get(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if (storage[bucket] == null || storage[bucket][bucketItem] == null) {
            return -1;
        }
        KeyValuePair kvp = storage[bucket][bucketItem];
        return kvp.getValue();

    }

    //remove
    public void remove(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if (storage[bucket] == null || storage[bucket][bucketItem] == null) {
            return;
        }
        storage[bucket][bucketItem] = null;
    }

    public static void main(String[] args) {
        DesignHashmapUsingDoubleHashing hashmap = new DesignHashmapUsingDoubleHashing();

        hashmap.put(1, 1);
        hashmap.put(2, 2);
        System.out.println(hashmap.get(1));
        System.out.println(hashmap.get(3));
        hashmap.put(2, 1);
        System.out.println(hashmap.get(2));
        hashmap.remove(2);
        System.out.println(hashmap.get(2));
    }

}
