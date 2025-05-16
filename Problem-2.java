// time complexity - put,get, remove - O(1)
// Space complexity - O(1)
// excecuted on LeetCode - yes
// Any problems faced - no

//Executed the solution Using linear chaining and double hashing, creating the array of Nodes and each Node can have reference to multiple nodes and calculating the hashcode using 2 hashfunction to get in O(1)
class MyHashMap {
    Node[] storage;
    int buckets;

    class Node {
        int key;
        int value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public MyHashMap() {
        this.buckets = 1000;
        storage = new Node[buckets];
    }

    public int getHashValue(int key) {
        return key%buckets;
    }

    public Node getPrevious(Node head, int key) {
        Node prev = head, current = head.next;
        while(current!= null && current.key != key) {
            prev = current;
            current = current.next;
        }
        return prev;
    }
    
    public void put(int key, int value) {
        int hashCode = getHashValue(key);
        if(storage[hashCode] == null) {
            storage[hashCode] = new Node(-1,-1);
        }
        Node prev = getPrevious(storage[hashCode], key);
        if(prev.next == null) {
            prev.next = new Node(key,value);
        } else {
            prev.next.value = value;
        }
        
    }
    
    public int get(int key) {
        int hashCode = getHashValue(key);
        if(storage[hashCode] == null) return -1;
        Node prev = getPrevious(storage[hashCode], key);
        if(prev.next == null) return -1;
        return prev.next.value;
    }
    
    public void remove(int key) {
        int hashCode = getHashValue(key);
        if(storage[hashCode] == null) return;
        Node prev = getPrevious(storage[hashCode], key);
        if(prev.next == null) return;
        Node temp = prev.next;
        prev.next = prev.next.next;
        temp.next = null;
    }
}


//Using double hashing 
// class MyHashMap {
//     Node[][] storage;
//     int buckets;
//     int bucketItems;

//     class Node {
//         int key;
//         int value;
//         Node(int key, int value) {
//             this.key = key;
//             this.value = value;
//         }
//     }

//     public MyHashMap() {
//         this.buckets = 1001;
//         storage = new Node[buckets][];
//         this.bucketItems = 1001;
//     }

//     public int getHashValue1(int key) {
//         return key%buckets;
//     }

//     public int getHashValue2(int key) {
//         return key/bucketItems;
//     }
    
//     public void put(int key, int value) {
//         int x = getHashValue1(key);
//         if(storage[x] == null) {
//             storage[x] = new Node[1000];
//         }
//         int y = getHashValue2(key);
//         if(storage[x][y] == null) {
//             storage[x][y] = new Node(key, value);
//         } else {
//             storage[x][y].value = value;
//         }
//     }
    
//     public int get(int key) {
//         int x = getHashValue1(key);
//         if(storage[x] == null) return -1;
//         int y = getHashValue2(key);
//         if(storage[x][y] == null) return -1;
//         return storage[x][y].value;
//     }
    
//     public void remove(int key) {
//         int x = getHashValue1(key);
//         if(storage[x] == null) return;
//         int y = getHashValue2(key);
//         if(storage[x][y] == null) return;
//         storage[x][y] = null;
        
//     }
// }
/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
