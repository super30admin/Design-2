// Time Complexity: O(N/k)
// Space Complxity: (N + K)

class MyHashMap {
    private final int MAX = 1000000;
    private List<Pair<Integer, Integer>> [] map;
    
    private int getIndex(int key) {
        return key % MAX;
    }

    private int getPos(int key, int index) {
        List<Pair<Integer, Integer>> temp = map[index];
        if (temp == null) {
            return -1;
        }

        for(int i = 0; i < temp.size(); ++i) {
            if (temp.get(i).getKey() == key) {
                return i;
            }
        }
        return -1;
    }

    public MyHashMap() {
        map = (List<Pair<Integer, Integer>>[])new ArrayList[MAX];
    }
    
    public void put(int key, int value) {
        int index = getIndex(key);
        int pos = getPos(key, index);
        if (pos < 0) {
            if (map[index] == null) {
                map[index] = new ArrayList<Pair<Integer, Integer>>();
            }
            map[index].add(new Pair(key, value));
        } else {
            map[index].set(pos, new Pair(key, value));
        }
    }

    public int get(int key) {
        int index = getIndex(key);
        int pos = getPos(key, index);
        if (pos < 0) {
            return -1;
        }    else {
            return map[index].get(pos).getValue();
         }
    }
    
    public void remove(int key) {
        int index = getIndex(key);
        int pos = getPos(key, index);
        if (pos >= 0) {
            map[index].remove(pos);
        }
    }
}
