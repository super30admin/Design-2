mport java.util.*;

import java.util.*;

public class MyHashSet {
    private final int MAX_VAL = 1000000;
    private final int sizeOfArray = 100;
    private List<List<Integer>> mainBucket;

    public MyHashSet() {
        mainBucket = new ArrayList<>(sizeOfArray);
        for (int idx = 0; idx < sizeOfArray; idx++) {
            mainBucket.add(null);
        }
    }

    public void add(int key) {
        int idx = key % sizeOfArray;
        List<Integer> lisInBucket = mainBucket.get(idx);
        if (lisInBucket == null) {
            List<Integer> list = new LinkedList<>();
            list.add(key);
            mainBucket.set(idx, list);
        } else {
            if (!lisInBucket.contains(key)) {
                lisInBucket.add(key);
            }
        }
    }

    public void remove(int key) {
        int idx = key % sizeOfArray;
        List<Integer> lisInBucket = mainBucket.get(idx);
        if (lisInBucket != null) {
            lisInBucket.remove(Integer.valueOf(key));
        }

    }

    public boolean contains(int key) {
        int idx = key % sizeOfArray;
        List<Integer> lisInBucket = mainBucket.get(idx);
        return lisInBucket != null && lisInBucket.contains(key);

    }

    public static void main(String args[]) {
        MyHashSet hs = new MyHashSet();
        hs.add(1);
        hs.add(2);
        System.out.println();
        boolean is1Present = hs.contains(1);
        System.out.println(is1Present);
        boolean is3Present = hs.contains(3);
        System.out.println(is3Present);
        hs.add(4);
        boolean is5Present = hs.contains(5);
        System.out.println(is5Present);
        boolean is4Present = hs.contains(4);
        System.out.println(is4Present);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */