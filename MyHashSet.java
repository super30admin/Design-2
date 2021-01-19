// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this : NO

// Your code here along with comments explaining your approach
class MyHashSet {

    boolean[][] myHashSet;
    int max = 1000;
    static int index1 = -1, index2 = -1;

    private void setIndex(int key) {
        index1 = key % (max - 1);
        index2 = key / max;
    }

    /** Initialize your data structure here. */
    public MyHashSet() {

        myHashSet = new boolean[max][];

    }

    public void add(int key) {

        setIndex(key);

        if (myHashSet[index1] == null) {
            myHashSet[index1] = new boolean[max];
        }

        myHashSet[index1][index2] = true;

    }

    public void remove(int key) {
        setIndex(key);

        if (myHashSet[index1] == null) {
            myHashSet[index1] = new boolean[max];
        }

        myHashSet[index1][index2] = false;

    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        setIndex(key);

        if (myHashSet[index1] == null) {
            myHashSet[index1] = new boolean[max];
        }

        return myHashSet[index1][index2];

    }
}