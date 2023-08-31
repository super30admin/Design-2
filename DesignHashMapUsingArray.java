//Implemented using Array technique
// Time Complexity : O(1)
// Space Complexity : O(1) //Question, whether this should O(1) because it is constant space of 1000001? or it should be O(N)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

/***
 * OUTPUT:
 * 1
 * -1
 * 1
 * -1
 *
 */

public class DesignHashMapUsingArray {
    int[] storage;

    public DesignHashMapUsingArray() {
        storage = new int[1000001];
    }

   //put
    public void put(int key, int value) {
        storage[key] = value + 1;
    }

    //get
    public int get(int key) {
        if(storage[key] == 0) {
            return -1;
        }
        return storage[key] - 1;
    }

    //remove
    public void remove(int key) {
        storage[key] = 0;
    }

    public static void main(String[] args) {
        DesignHashMapUsingArray hashmap = new DesignHashMapUsingArray();

        hashmap.put(1, 1);
        hashmap.put(2, 2);
        System.out.println(hashmap.get(1));
        System.out.println(hashmap.get(3));
        hashmap.put(2, 1);
        System.out.println(hashmap.get(2));
        hashmap.remove(2);
        System.out.println(hashmap.get(2));
    }
}
