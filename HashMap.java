// Time Complexity : O(1)
// Space Complexity : O(1)->no extra space
// Did this code successfully run on Leetcode : Yes
class MyHashMap {

    //Use yesterday's concept double hashing for HAshSet
    private int[][] array;
    public MyHashMap() {
        array = new int[1000][];//nearest sqaure root
    }

    private int _hash1(int x)
    {
        return x%1000;
    }

    private int _hash2(int x)
    {
        return x/1000;
    }
    //O(1)
    public void put(int key, int value) {
        int primary = _hash1(key);
        if(array[primary]==null)
        {
            if (primary==0)
            {
                array[primary] = new int[1001];
            }
            else{
                array[primary] = new int[1000];
            }
            Arrays.fill(array[primary],-1);
        }
        int sec = _hash2(key);
        array[primary][sec] = value;
    }

    //O(1)
    public int get(int key) {
        int primary = _hash1(key);
        int sec = _hash2(key);
        if (array[primary] == null) {
            return -1;
        }
        return array[primary][sec];
    }

    //O(1)
    public void remove(int key) {
        int primary = _hash1(key);
        int sec = _hash2(key);
        if (array[primary] != null) {
            array[primary][sec] = -1;
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