/**

// Time Complexity :
    Insert - 
// Space Complexity :
    Total space complexity = Auxilary space + space used towards input.
    n * O(m) - where n is the length of set and m is the size of list at each index.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


Approaches:
- This hashset is implemented using an array of list where index is calculated using hashFunction.
- If the hashfunction is not well distributed then it might end up mapping multiple keys at same index.
- In that case colision occurs and can be solved by linear probing or chaining.
- I have took chaining approach here and it is implemented using an array of LinkedList.

for ex:
index (5) -> 4,7,8,9,3 (list)

**/
class MyHashSet {

    List<Integer> set[];
    int max_length = 1000000;
    

    public MyHashSet() {
        
        set = new LinkedList[max_length];
    }
    
    /**
    Time Complexity : 
    add - O(1) in ideal case where if there is no collision. 
    O(n) -  in the worst case for chaining approach with singly linkedlist where inserting at the end in list will take O(n).
    Can be improved by implementing the chaining by doubly linked list and this operation will be O(1). Here n is the size of list.
    **/
    public void add(int key) {
        
        if (contains(key))
        {
            // This is already present and can not be inserted as set does not contains duplicates.
            return;
        }
        
        int indexToInsert = getIndex(key);
        
        List<Integer> keysAtIndex = set[indexToInsert];
        
        if (keysAtIndex == null)
        {
            keysAtIndex = new LinkedList<>();
            set[indexToInsert] = keysAtIndex;
        }
        
        keysAtIndex.add(key);
    }
    
    private int getIndex(int key)
    {
        return key % max_length;
    }
    
    /**
    Time Complexity
    Remove - O(n) where n is the size of list. In linkedlist need to find the previous of the remove element linearly and then perform 
    delete operations.
    **/
    public void remove(int key) {
        int indexToSearch = getIndex(key);
        
        List<Integer> keys = set[indexToSearch];
        
        if (keys == null)
        {
            return;
        }
      
        for(int i=0; i<keys.size(); i++)
        {
            if (keys.get(i) == key)
            {
                keys.remove(i);
                break;
            }
        }
        
        if (keys.isEmpty())
        {
            set[indexToSearch] = null;
        }
    }
    
    /**
    Time Complexity 
    Search - O(1) if collision does not occur. Otherwise O(n) to search the key linearly. Can be improved to make O(logn) by
    implementing the array of balanced binary search tree as buckets.
    **/
    public boolean contains(int key) {
        
        int indexToSearch = getIndex(key);
        
        return set[indexToSearch] != null && set[indexToSearch].contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */