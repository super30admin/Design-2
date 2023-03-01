// Time: O(N) for all operations
// Space O(N)
class MyHashMap {

    /** Initialize your data structure here. */
    class Node {
        Node next;
        int key;
        int val;
        public Node (int k, int v){
            this.key = k;
            this.val = v;
            this.next = null;
        }
    }
    
    Node [] map;
    int prime = 997; // take prime numbers,997,  2069, 9973
    public MyHashMap() {
        map = new Node[prime];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hash = key%prime;
        if(map[hash]==null){
            map[hash] = new Node (key, value);
        }
        else{
            Node temp = map[hash];
            while(temp.next!=null && temp.key!=key)
                temp = temp.next;
            if(temp.key==key){
                temp.val = value;
                return;
            }
            temp.next = new Node(key, value);
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hash = key%prime;
        if(map[hash]!=null){
            Node temp = map[hash];
            while(temp!=null && temp.key!=key)
                temp=temp.next;
            return temp==null ? -1 : temp.val;
        }
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hash = key%prime;
        if(map[hash]!=null){
            Node temp = map[hash];
            if(temp.key==key){
                map[hash] = temp.next;
                return;
            }
            while(temp.next!=null && temp.next.key!=key)
                temp = temp.next;
            if(temp.next==null)
                return;
            temp.next = temp.next.next;
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