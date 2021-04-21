// Time Complexity :o(n)
// Space Complexity :o(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : not with brute force but ya I am trying little optmised one
//and ther I am facing some challenges.


// Your code here along with comments explaining your approach:
//I have created a boolean array of the entire length and then whatever key
// is coming for addtion I am smply updating the
// the particular index with true and for removal I am setting
// that index in the array with false. if in array a particulr
//index contains true then I am returing true in contains() method else false.


//Note I have not written main method here as I wrote directly over leetcode.

public class DesignHashSet {

    boolean[] arr;
    /** Initialize your data structure here. */
    public DesignHashSet() {
        arr=new boolean[10000001];
    }

    public void add(int key) {
        arr[key]=true;
    }

    public void remove(int key) {
        arr[key]=false;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return arr[key];
    }


}
