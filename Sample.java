// Time Complexity : put() - O(N), get() - O(N), remove() - O(N)
// Space Complexity : O(2N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class MyHashMap {ArrayList<Integer> keys;
    ArrayList<Integer> values;

    /** Initialize your data structure here. */
    public MyHashMap() {
        keys = new ArrayList<>();
        values = new ArrayList<>();
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        if(keys.contains(key))
            //Key is aready present. So the value should be replaced.
            values.set(keys.indexOf(key), value);
        else 
        {
            //Just add the key to 'keys' arraylist and value to 'values' arraylist
            keys.add(key);
            values.add(value);
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        if(keys.contains(key))
            return values.get(keys.indexOf(key));
        else
            return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        if(keys.contains(key))
        {
            //remove the value first and then remove the key
            values.remove(keys.indexOf(key));
            keys.remove(new Integer(key));
        }
    }
}

public class Sample {
    public static void main(String[] args)
    {
        MyHashMap obj = new MyHashMap();
        obj.put(key,value);
        int param_2 = obj.get(key);
        obj.remove(key);
    }
}