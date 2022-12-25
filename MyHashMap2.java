// Approach2
// Time Complexity :  put(), get(), remove() run in constant time O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// Using double chaining approach here. 
// Primary and secondary are both arrays and have their own hash functions to give O(1) search time complexity.
// Secondary array will be initalized at that index only when we get an element with corresponding hash value.


class MyHashMap {

    private int[][] hashMap;
    private int primLen;
    private int secLen;
    
    public MyHashMap() {
        this.primLen = 10000;
        this.secLen = 100;
        hashMap = new int[this.primLen][];
    }

    //hash fns
    private int primHash(int key) {
        return key%primLen;
    }

    private int secHash(int key) {
        return key/primLen;
    }

    public void put(int key, int value) {
        int primIdx = primHash(key);
        int secIdx = secHash(key);
        if(hashMap[primIdx]==null) //array not initalized at this index
        {
            if(primIdx==0)
                hashMap[primIdx] = new int[secLen+1]; //handle case when key is 10^6
            else
                hashMap[primIdx] = new int[secLen];
            Arrays.fill(hashMap[primIdx],-1); //initializing array values to -1
        }
        hashMap[primIdx][secIdx] = value;
        
    }
    
    public int get(int key) {
        int primIdx = primHash(key);
        int secIdx = secHash(key);
        if(hashMap[primIdx]==null)
            return -1;
        return hashMap[primIdx][secIdx];
    }
    
    public void remove(int key) {
        int primIdx = primHash(key);
        int secIdx = secHash(key);
        if(hashMap[primIdx]==null)
            return;
        hashMap[primIdx][secIdx]=-1; //set to inital value -1 
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
