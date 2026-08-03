//Approach: Similar to HashSet implementation try using double-hashing method
// to handle collisions

// Time Complexity: O(1)
// Space Complexity: O(1)

class MyHashMap {

    int[][] arr;
    int buckets;
    int bucketItems;

    public MyHashMap() {
        buckets = 1000;
        bucketItems = 1000;
        arr = new int[buckets][];
    }

    public int getPrimaryHash(int key)
    {
        return key % buckets;
    }

    public int getSecondaryHash(int key)
    {
        return key / bucketItems;
    }

    public void put(int key, int value) {
        var firstIndex = getPrimaryHash(key);
        var secondIndex = getSecondaryHash(key);
        if (arr[firstIndex] == null)
        {
            if (firstIndex == 0)
            {
                arr[firstIndex] = new int[bucketItems + 1];
            }
            else
            {
                arr[firstIndex] = new int[bucketItems];
            }
        }
        if (value == 0)
        {
            arr[firstIndex][secondIndex] = value - 2;
        }
        else
        {
            arr[firstIndex][secondIndex] = value;
        }
    }

    public int get(int key) {
        var firstIndex = getPrimaryHash(key);
        var secondIndex = getSecondaryHash(key);

        if (arr[firstIndex] == null || arr[firstIndex][secondIndex] == 0)
        {
            return -1;
        }
        if (arr[firstIndex][secondIndex] == -2)
        {
            return 0;
        }
        return arr[firstIndex][secondIndex];
    }

    public void remove(int key) {
        var firstIndex = getPrimaryHash(key);
        var secondIndex = getSecondaryHash(key);
        if (arr[firstIndex] == null || arr[firstIndex][secondIndex] == -1) return;
        arr[firstIndex][secondIndex] = -1;
    }
}
/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */