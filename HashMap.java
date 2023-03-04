/*this is the implementation of hashmap
* I have used lists for keys and values*/
import java.util.List;
import java.util.ArrayList;
public class HashMap {
    private List<Integer> keys;
    private List<Integer> values;

    public HashMap(){
        keys = new ArrayList<>();
        values = new ArrayList<>();
    }

    public void put(int key, int value) {
        if (keys.contains(key)) {
            values.set(keys.indexOf(key), value);
        } else {
            keys.add(key);
            values.add(value);
        }
    }

    public int get(int key) {
        if (keys.contains(key)) {
            return values.get(keys.indexOf(key));
        } else {
            return -1;
        }
    }

    public void remove(int key) {
        if (keys.contains(key)) {
            int index = keys.indexOf(key);
            keys.remove(index);
            values.remove(index);
        }
    }

    public static void main(String[] args) {
        HashMap map = new HashMap();

        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);

        System.out.println(map.get(1)); // output: 1
        System.out.println(map.get(2)); // output: 2

        map.remove(3);

        System.out.println(map.get(3)); // output: -1
    }

}
