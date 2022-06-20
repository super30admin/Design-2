//time complexity is 0(n)
// space complexity is 0(n)

import java.util.ArrayList;
import java.util.List;

class MyHashSet {
    List<Integer> set;
    public MyHashSet() {
        set= new ArrayList<>();

    }

    public void add(int key) {
        if(set.contains(key)==false)
        {
            set.add(key);
        }

    }

    public void remove(int key) {
        if(set.contains(key)==true)
        {
            set.remove(set.indexOf(key));
        }
    }

    public boolean contains(int key) {
        if(set.contains(key)==true)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */