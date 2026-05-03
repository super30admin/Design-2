// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
I have implemented a hashmap using double hashing. By default, each bucket is allocated the value -1. If a key is not present, I return
-1 to the user. If key exists in the hashmap, the corresponding value is returned to the user if it's present, or -1 is returned.
*/

public class MyHashMap
{
    private int[][] buckets;
    private int bucketCount;
    private int bucketSize;

    public MyHashMap()
    {
        bucketCount = 1000;
        bucketSize = 1000;
        buckets = new int[bucketCount][];
    }

    public void Put(int key, int value)
    {
        int hash1 = HashFunction1(key);

        if (buckets[hash1] == null)
        {
            if (hash1 == 0)
            {
                buckets[hash1] = new int[bucketSize + 1];
            }

            else
            {
                buckets[hash1] = new int[bucketSize];
            }

            Array.Fill(buckets[hash1], -1);
        }

        int hash2 = HashFunction2(key);

        buckets[hash1][hash2] = value;

    }

    public int Get(int key)
    {
        int hash1 = HashFunction1(key);

        if (buckets[hash1] == null)
        {
            return -1;
        }

        int hash2 = HashFunction2(key);

        return buckets[hash1][hash2];
    }

    public void Remove(int key)
    {
        int hash1 = HashFunction1(key);

        if (buckets[hash1] != null)
        {
            int hash2 = HashFunction2(key);

            buckets[hash1][hash2] = -1;
        }
    }

    private int HashFunction1(int key)
    {
        return key % bucketCount;
    }

    private int HashFunction2(int key)
    {
        return key / bucketSize;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.Put(key,value);
 * int param_2 = obj.Get(key);
 * obj.Remove(key);
 */