// Time Complexity : O(1) for all methods as we're fetching an array element by index for all operations.
// Space Complexity : O(n) where n is the size of range of the input
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
class MyHashMap
{
    private int buckets;
    private int bucketItems;
    private int[][] storage;

    public MyHashMap()
    {
        this.buckets = 1000;
        this.bucketItems = 1000;
        this.storage = new int[buckets][];
    }

    public void put(int key, int value)
    {
        int bucketIndex = hashFunction1(key);
        int bucketItemIndex = hashFunction2(key);

        if(storage[bucketIndex] == null)
        {
            if(bucketIndex == 0)
            {
                storage[bucketIndex] = new int[bucketItems+1];
            }
            else
            {
                storage[bucketIndex] = new int[bucketItems];
            }

        }
        //handle the case where 0 is the value and does not just indicate a miss; as the bucketItems array will be initialized with 0s
        if(value == 0)
        {
            value = -2; //as we will never actually get a -1 value
        }

        //upsert the value at the key
        storage[bucketIndex][bucketItemIndex] = value;
    }

    private int hashFunction1(int key)
    {
        return key % buckets;
    }

    private int hashFunction2(int key)
    {
        return key / bucketItems;
    }

    public int get(int key)
    {
        int bucketIndex = hashFunction1(key);
        if(storage[bucketIndex] != null)
        {
            int bucketItemIndex = hashFunction2(key);
            if(storage[bucketIndex][bucketItemIndex] == -2)
            {
                return 0;
            }
            if(storage[bucketIndex][bucketItemIndex] == 0) //this means these were never added
            {
                return -1;
            }
            return storage[bucketIndex][bucketItemIndex];
        }
        return -1;
    }

    public void remove(int key)
    {
        int bucketIndex = hashFunction1(key);
        if(storage[bucketIndex] == null)
        {
            return;
        }

        int bucketItemIndex = hashFunction2(key);
        //make it -1
        storage[bucketIndex][bucketItemIndex] = -1;

    }

    public static void main(String[] args) {

        MyHashMap obj = new MyHashMap();
        obj.put(2, 4);
        obj.put(0,1);
        obj.put(5000, 0);
        System.out.println(obj.get(2));
        obj.put(2, 76);
        System.out.println(obj.get(2));
        System.out.println(obj.get(5000));
        obj.remove(5000);
        System.out.println(obj.get(5000));
        System.out.println(obj.get(89));
    }
}