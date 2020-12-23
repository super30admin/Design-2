// Time Complexity : The time complexities for add, remove and contains operations is O(n) since in worst case scenario there
// is a chance that all the elements would map to the same index in the array and we would traverse through the whole list in that
// particular index.
// Space Complexity : The space complexity is O(n) since as said in worst case scenario there would be a chance that all the elements
// would map to the same index in the array and a linked List of length n would be created.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MyHashSet {

    LinkedList<Integer>[] set;

    /** Initialize your data structure here. */
    public MyHashSet() {

        // Since the maximum number of elements would be 10^6, an array of length 1000 is created and each index would
        // manage a linked list
        set = new LinkedList[1000];

    }

    public void add(int key) {

        int position = key % set.length; // Index of the array is obtained through hashing

        // If the linked list is empty then a new linked list is created
        if(set[position] == null){
            set[position] = new LinkedList<Integer>();
            set[position].add(key);
            return;
        }

        // Traverse through the linked list to check if the key exists or not
        for(int i=0;i<set[position].size();i++){

            if(set[position].get(i) == key){
                return;
            }

        }

        // Key is added if it doesnt exist in the linked list
        set[position].add(key);

    }

    public void remove(int key) {

        int position = key % set.length; // Index of the array is obtained through hashing

        // If the linked list is empty then there are no elements to remove
        if(set[position] == null){
            return;
        }

        // Traverse through the linked list to remove the key if exists
        for(int i=0;i<set[position].size();i++){

            if(set[position].get(i) == key){
                set[position].remove(i);
            }

        }

    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {

        int position = key % set.length; // Index of the array is obtained through hashing

        // If the linked list is empty then the key doesnt exists
        if(set[position] == null){
            return false;
        }

        // Traverse through the linked list to check if the key exists
        for(int i=0;i<set[position].size();i++){

            if(set[position].get(i) == key){
                return true;
            }

        }

        return false;

    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */