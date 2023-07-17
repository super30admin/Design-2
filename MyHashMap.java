import java.util.Arrays;

//this class uses double hashing to implement hashmap
/*
    Time Complexity: for get() and remove() ->O(1)
                     for put()->can be O(n)
    Space Complexity: o(1)

 */
    class MyHashMap {

        int buckets=1000;
        int bucketItems=1000;
        int[][] storage;
        private int hashFunction1(int key)
        {
            return key%1000;
        }
        private int hashFunction2(int key)
        {
            return key/1000;
        }
        public MyHashMap() {
            storage=new int[buckets][];
        }

        public void put(int key, int value) {
            int bucket=hashFunction1(key);
            int bucketItem=hashFunction2(key);
            if(storage[bucket]==null)
            {
                if(bucket==0)
                {
                    storage[bucket]=new int[bucketItems+1];
                }
                else
                {
                    storage[bucket]=new int[bucketItems];
                }
                Arrays.fill(storage[bucket], -1);
            }
            storage[bucket][bucketItem]=value;
        }

        public int get(int key) {
            int bucket=hashFunction1(key);
            int bucketItem=hashFunction2(key);
            if(storage[bucket]==null)
            {
                return -1;
            }
            else
            {
                if(storage[bucket][bucketItem]==-1)
                {
                    return -1;
                }
                else
                {
                    return storage[bucket][bucketItem];
                }
            }
        }




        public void remove(int key) {
            int bucket=hashFunction1(key);
            int bucketItem=hashFunction2(key);
            if(storage[bucket]!=null)
            {
                storage[bucket][bucketItem]=-1;
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

