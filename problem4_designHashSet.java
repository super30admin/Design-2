package Design2;

/*
    Time Complexity : O(n)
 */

public class problem4_designHashSet {

    class MyHashSet {

        private boolean[] arr = new boolean[1000001];
        /** Initialize your data structure here. */
        public MyHashSet() {

        }

        public void add(int key) {
            arr[key] = true;
        }

        public void remove(int key) {
            arr[key] = false;
        }

        /** Returns true if this set contains the specified element */
        public boolean contains(int key) {
            return arr[key];
        }
    }

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

    public static void main(String[] args) {

    }
}
