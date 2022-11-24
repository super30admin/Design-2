class MyHashMap {
    Node[] bucket;
    int bucketSize;

    class Node{
        int key;
        int value;
        Node next;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public MyHashMap() {
        bucketSize = 10000;
        bucket = new Node[bucketSize];
    }
    
    public void put(int key, int value) {
        int index = key % bucketSize;
        Node node = new Node(key, value);
        if (bucket[index] == null){
            bucket[index] = new Node(-1,-1);
        } 

        Node prevNode = bucket[index];
        Node currNode = prevNode.next;
        if (currNode == null){
            prevNode.next = node;
        } else {
            while (currNode != null){
                if (currNode.key == key) {
                    currNode.value = value; 
                    return;
                }
                prevNode = currNode;
                currNode = currNode.next;
            }
            prevNode.next = node;
        }
        
    }
    
    public int get(int key) {
        int index = key%bucketSize;
        if (bucket[index] == null) return -1;
        Node prevNode = bucket[index];
        Node currNode = prevNode.next;
        
        if (currNode == null) return -1;

        while (currNode != null){
            if (currNode.key == key) {
                return currNode.value; 
            }
            prevNode = currNode;
            currNode = currNode.next;
        }
        return -1;
    }
    
    public void remove(int key) {
        int index = key%bucketSize;
        if (bucket[index] == null){
            return;
        }
        Node prevNode = bucket[index];
        Node currNode = prevNode.next;
        
        if (currNode == null) return;

        while (currNode != null){
            if (currNode.key == key) {
                prevNode.next = currNode.next; 
                return;
            }
            prevNode = currNode;
            currNode = currNode.next;
        }
        
    }

    public static void main(String[] args){
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1, 1); // The map is now [[1,1]]
        myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
        myHashMap.get(1);    // return 1, The map is now [[1,1], [2,2]]
        myHashMap.get(3);    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
        myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
        myHashMap.get(2);    // return 1, The map is now [[1,1], [2,1]]
        myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
        myHashMap.get(2);    // return -1 (i.e., not found), The map is now [[1,1]]
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */