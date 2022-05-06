//Time Complexity :O(1)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode :Yes

class MyHashSet {
    private final int MAX_LEN = 100000;
    private List<Integer>[] set;
    private int getIndex(int key){
        return key % MAX_LEN;
    }
    private int getPos(int key, int index) {
        List<Integer> temp = set[index];
        if (temp == null) {
            return -1;
        }
        for (int i = 0; i < temp.size(); ++i){
            if (temp.get(i) == key) {
                return i;
            }
        }
        return -1;
    }


    public MyHashSet() {
        set = (List<Integer>[])new ArrayList[MAX_LEN];

    }

    public void add(int key) {
        int index = getIndex(key);
        int pos = getPos(key, index);
        if (pos < 0) {
            if (set[index] == null) {
                set[index] = new ArrayList<Integer>();
            }
            set[index].add(key);

        }
    }

    public void remove(int key) {
        int index = getIndex(key);
        int pos = getPos(key, index);
        if (pos >= 0) {
            set[index].remove(pos);

        }
    }
    public boolean contains(int key) {
        int index = getIndex(key);
        int pos = getPos(key, index);
        return pos >= 0;

    }
}
