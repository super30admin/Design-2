import java.util.*;

// Time Complexity : O(n) for all functions.
// Space Complexity : O(n) for size of array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
class MyHashSet {

    List<Integer> list;
    public MyHashSet() {
        list = new ArrayList<>();
    }

    public void add(int key) {
        if(!contains(key)){
            list.add(key);
        }
    }

    public void remove(int key) {
        list.remove(new Integer(key));
    }

    public boolean contains(int key) {

        for(int i=0;i<list.size();i++){
            if(list.get(i)==key){
                return true;
            }
        }
        return false;
    }

    public static void main(String [] args){
        MyHashSet hashSet = new MyHashSet();

        hashSet.add(1);

        hashSet.add(2);

        System.out.println(hashSet.contains(1));    // returns true

        System.out.println(hashSet.contains(3));    // returns false (not found)

        hashSet.add(2);

        System.out.println(hashSet.contains(2));    // returns true

        hashSet.remove(2);

        System.out.println(hashSet.contains(2));
    }
}