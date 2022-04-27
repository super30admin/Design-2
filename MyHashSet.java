/**

Time Complexity : O(1)
Space Complexity : O(N) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

**/
class MyHashSet 
{
    boolean tracker[][];
    
    int getFirstHash(int key)
    {
        return key % 1000;
    }
    
    int getSecondHash(int key)
    {
        return key/1000;
    }

    public MyHashSet() {
        this.tracker = new boolean[1000][];
    }
    
    public void add(int key) {
        
        int firstHash = getFirstHash(key);
        int secondHash = getSecondHash(key);
        
        if(tracker[firstHash] == null)
        {
            if(firstHash == 0)
                tracker[firstHash] = new boolean[1001];
            else
                tracker[firstHash] = new boolean[1000];
        }
        
        tracker[firstHash][secondHash] = true;
    }
    
    public void remove(int key) {
        
        int firstHash = getFirstHash(key);
        int secondHash = getSecondHash(key);
        
        if(tracker[firstHash] == null)
            return;
        
        tracker[firstHash][secondHash] = false;
        
    }
    
    public boolean contains(int key) {
        
        int firstHash = getFirstHash(key);
        int secondHash = getSecondHash(key);
        
        if(tracker[firstHash] == null)
            return false;
        
        return tracker[firstHash][secondHash];
        
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */