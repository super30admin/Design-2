
// 1. Use two ArrayLists: one for keys, one for values.
// 2. On put: check if key exists – update or insert accordingly.
// 3. On get/remove: use indexOf to find the key and act on both lists.

import java.util.ArrayList;

class DesignHashMap {

    private static ArrayList<Integer> keys, values;

    public DesignHashMap() {
        keys = new ArrayList<>();
        values = new ArrayList<>();
    }

    public void put(int key, int value) {
        int i;
        if ((i = keys.indexOf(key)) != -1) {
            values.set(i, value);
        } else {
            keys.add(key);
            values.add(value);
        }
    }

    public int get(int key) {
        int i;
        if ((i = keys.indexOf(key)) != -1) {
            return values.get(i);
        }
        return -1;
    }

    public void remove(int key) {
        int i = keys.indexOf(key);
        if (i != -1) {
            keys.remove(i);
            values.remove(i);
        }
    }

    public static void main(String[] args) {
        DesignHashMap map = new DesignHashMap();

        map.put(1, 100);
        map.put(2, 200);
        map.put(3, 300);
        System.out.println(map.get(2)); // 200

        map.put(2, 250);
        System.out.println(map.get(2)); // 250

        map.remove(2);
        System.out.println(map.get(2)); // -1

        System.out.println(map.get(3)); // 300
    }
}
