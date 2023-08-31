//Time and space complexity is O(n) n = no.of key,values
class MyHashMap {

    class Node{
        int key,value;
        Node next;


        Node(int key, int value){
            this.key =key;
            this.value = value;
        }
    }

    Node find(Node dummy, int key){
        Node prev, current;
        prev = dummy;
        current = dummy.next;
        while(current != null && current.key!=key){
            prev = current;
            current = current.next;
        }
        return prev;
    }

    int buckets;

    Node[] storage;

    public MyHashMap() {
        buckets = 10000;
        storage = new Node[buckets];
    }

    int hashFunction(int key){
        return key % buckets;
    }
    public void put(int key, int value) {
        int bucket = hashFunction(key);
        if(storage[bucket] == null){
            storage[bucket] = new Node(-1,-1);
        }
        Node prev = find(storage[bucket], key);
        if(prev.next == null){
            prev.next = new Node(key, value);
        } else {
            prev.next.value = value;
        }
    }

    public int get(int key) {
        int bucket = hashFunction(key);
        if(storage[bucket]==null){
            return -1;
        }
        Node prev = find(storage[bucket], key);
        if(prev.next == null){
            return -1;
        }
        return prev.next.value;

    }

    public void remove(int key) {
        int bucket = hashFunction(key);
        if (storage[bucket]==null){
            return;
        }
        Node prev = find(storage[bucket], key);
        if(prev.next == null)
            return;
        prev.next = prev.next.next;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */