
// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class MyHashMap {
    int [] vals;
    boolean [] has;
    public MyHashMap() {
        vals = new int[(int)Math.pow(10,6)+1];
        has = new boolean[(int)Math.pow(10,6)+1];
    }

    public void put(int key, int value) {
        vals[key] = value;
        has[key] = true;
    }

    public int get(int key) {
        if(has[key])
        return vals[key];
        else
        return -1;
    }

    public void remove(int key) {
        has[key] = false;
    }
}
