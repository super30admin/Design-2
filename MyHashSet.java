class MyHashSet {

    /** Initialize your data structure here. */
    MyHashMap myHashMap;
    public MyHashSet() {
        myHashMap = new MyHashMap();
    }
    
    public void add(int key) {
        myHashMap.put(key, 0);
    }
    
    public void remove(int key) {
        myHashMap.remove(key);
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return myHashMap.get(key) != -1;
    }

    public static void main(String[] args){
        System.out.println("Hash Set Implementation");
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(10);
        myHashSet.add(20);
        System.out.println(myHashSet.contains(10));
        myHashSet.remove(10);
        System.out.println(myHashSet.contains(10));
    }

    public class MyHashMap {

        /** Initialize your data structure here. */
        public class Node {
            int key;
            int value;
            Node next;
    
            Node(int key, int value){
                this.key = key;
                this.value = value;
            }
        }
    
        public int capacity;
        public Node[] hashTable;
        public MyHashMap() {
            capacity = 10;
            hashTable = new Node[capacity];
        }
        
        /** value will always be non-negative. */
        public void put(int key, int value) {
            int index = calculateIndex(key);
    
            if(hashTable[index] == null){
                Node entry = new Node(key, value);
                hashTable[index] = entry;
            }
            else{           
                Node curr = hashTable[index];
                Node prev = null;
                while(curr != null){
                    if(curr.key == key){
                        curr.value = value;  
                        return;
                    }
                    prev = curr;
                    curr = curr.next;
                }
                Node entry = new Node(key, value);
                prev.next = entry;            
            }
    
        }
        
        /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
        public int get(int key) {
            int index = calculateIndex(key);
            if(hashTable[index] != null){
                
                Node curr = hashTable[index];
                while(curr != null){
                    if(curr.key == key){
                        return curr.value;
                    }
                    curr = curr.next;
                }
                return -1;            
            }
            return -1;
        }
        
        /** Removes the mapping of the specified value key if this map contains a mapping for the key */
        public void remove(int key) {
            int index = calculateIndex(key);
    
            if(hashTable[index] != null){
    
                Node curr = hashTable[index];
                Node prev = null;
                
                while(curr != null){                
                    if(curr.key == key){
                        
                        if(prev == null)
                            hashTable[index] = curr.next;                                            
                        else
                            prev.next = curr.next;   
                                                                     
                        return;               
                    }
                    prev = curr;
                    curr = curr.next;
                }
            }
        }
    
        public int hashCode(int key){
            return Integer.hashCode(key);
        }
    
        public int calculateIndex(int key){
            return hashCode(key)%capacity;
        }
}
}
/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */