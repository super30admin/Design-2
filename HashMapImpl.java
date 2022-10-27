//Time complexity is O(1) as array lookup is O(1)
//Space complexity is O(N) where N is 1000006
class MyHashMap {
    int size = (int)Math.pow(10, 6)+1;
    int[] hm = new int[size];
    public MyHashMap() {
        Arrays.fill(hm, -1);
    }
    
    public void put(int key, int value) {
        hm[key] = value;
    }
    
    public int get(int key) {
        return hm[key];
    }
    
    public void remove(int key) {
        hm[key]=-1;
    }
}

