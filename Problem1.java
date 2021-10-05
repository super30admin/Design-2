// Time Complexity: O(n)
// Space Complexity: O(n)
// Did this code successfully run on Leetcode: Yes ( https://leetcode.com/submissions/detail/566463576/ )
// Any problem you faced while coding this: 

class MyHashSet {

    ArrayList<Integer> set;

    public MyHashSet() {
        set = new ArrayList<>();
    }

    public void add(int key) {
        if (!(set.contains(key))) {
            set.add(key);
        }
    }

    public void remove(int key) {
        for (int i = 0; i < set.size(); i++) {
            if (set.get(i) == key) {
                set.remove(i);
            }
        }
    }

    public boolean contains(int key) {
        if ((set.contains(key))) {
            return true;
        } else {
            return false;
        }
    }
}
