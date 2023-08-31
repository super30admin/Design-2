//Time complexity: O(1)
//Space complexity: O(N)

class MyHashMap {
    List<Integer> keyList;//List for keys
    List<Integer> valueList;//List for values

    public MyHashMap() {
        keyList = new ArrayList<>();
        valueList = new ArrayList<>();
    }
    
    public void put(int key, int value) {
        if(keyList.contains(key))
            valueList.set(keyList.indexOf(key),value);//get index of key and replace(override) the value exising in that index of value list 
        else{
            keyList.add(key);//add key in key list
            valueList.add(value);//add key in value list
            }
        }

    
    public int get(int key) {
        if(!keyList.contains(key))
            return -1;
        else
            return valueList.get(keyList.indexOf(key));//return value from value list by getting the index from key list (if key exists)
    }
    
    public void remove(int key) {
        if(keyList.contains(key)){
            valueList.remove(keyList.indexOf(key));//remove value
            keyList.remove(keyList.indexOf(key));//remove key
        }
        
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
