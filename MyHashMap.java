class MyHashMap {
Map <Integer,Integer> m;

    public MyHashMap() {
        m=new HashMap<>();
    }
    
    public void put(int key, int value) {
        m.put(key, value);
    }
    
    public int get(int key) {
        return (m.containsKey(key)) ? m.get(key) : -1;
    }
    
    public void remove(int key) {
        m.remove(key);
    }
}

