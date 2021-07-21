// Time Complexity : O(1) for all operations
// Space Complexity : O(N) in worst case. Where N = 10^6.
// Did this code successfully run on Leetcode : YES
// LC submission link: https://leetcode.com/submissions/detail/525815971/  
// Any problem you faced while coding this : None. While thinking of BST I did.

class MyHashSet {

    /** Initialize your data structure here. */
    private boolean[][] set;
    private int bucketIds;
    private int bucketPositions;
    
    public MyHashSet() {
        // using sqrt(N) decided to keep size as 10^3
        bucketIds = bucketPositions = 1000;
        // set will be initialized to 10^3 null references
        set = new boolean[bucketIds][];
    }
    
    public void add(int key) {
        // using two chain  hashing
        // first get bucket id
        int bktId = getBucket(key);
        // then index in that bucket
        int bktPos = getPositionInBucket(key);
        
        if(null == set[bktId])
        {
            // We need to store 10^3 elements in that case so index will be 1000 thus +1
            if(0 == bktId)
            {
                set[bktId] = new boolean[bucketPositions + 1];
            }
            else
            {
                set[bktId] = new boolean[bucketPositions];
            }
        }
        
        set[bktId][bktPos] = true;
    }
    
    public void remove(int key) {
        int bktId = getBucket(key);
        int bktPos = getPositionInBucket(key);
        
        if(null == set[bktId])
        {
            return;
        }
        
        set[bktId][bktPos] = false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bktId = getBucket(key);
        int bktPos = getPositionInBucket(key);
        
        if(null == set[bktId])
        {
            return false;
        }
        
        return set[bktId][bktPos];
    }
    
    // Helper function to get first hash or bucket Id in set
    private int getBucket(int key)
    {
        return key % bucketIds;
    }

    // Helper function to get second hash or index in set[bucketId]
    private int getPositionInBucket(int key)
    {
        return key / bucketPositions;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */