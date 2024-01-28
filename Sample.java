/* Time Complexity :
    push - Always 0(1)
    pop - Amortized 0(1)
    peek - Amortized 0(1)
    empty - 0(1)
*/

/* Space Complexity :
    O(1) for all the operations
*/

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nothing

// Follwed Instack and OutStack Approach
// When the pop(), peek() operation comes, if the outstack is empty,
// transfer the data from instack to outstack so that it becomes FIFO
class MyQueue {

    Stack<Integer> inStack;
    Stack<Integer> outStack;

    public MyQueue() {
        inStack = new Stack<Integer>();
        outStack = new Stack<Integer>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if(outStack.isEmpty()) {
            while(!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }

        return outStack.pop();
    }

    public int peek() {
        if(outStack.isEmpty()) {
            while(!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }

        return outStack.peek();
    }

    public boolean empty() {
        return outStack.isEmpty() && inStack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

//********************************************************************************

/* Time Complexity :
    put - Always 0(1)
    get - Always 0(1)
    remove - Always 0(1)
*/

/* Space Complexity :
    O(1) for all the operations
*/

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nothing

class MyHashMap {

    class Entry {
        int key;
        int value;

        Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    Entry[][] storage;
    int buckets;
    int bucketSize;

    public MyHashMap() {
        buckets = 1000;
        bucketSize = 1000;

        storage = new Entry[buckets][];
    }

    private int hash(int key) {
        return key%buckets;
    }

    public void put(int key, int value) {
        int hashValue = hash(key);

        if(storage[hashValue] == null) {
            if(hashValue == 0) {
                storage[hashValue]  = new Entry[bucketSize + 1];
            } else {
                storage[hashValue]  = new Entry[bucketSize];
            }
        }

        if(storage[hashValue][key/bucketSize] == null) {
            storage[hashValue][key/bucketSize] = new Entry(key, value);
        } else {
            storage[hashValue][key/bucketSize].setValue(value);
        }
    }

    public int get(int key) {
        int hashValue = hash(key);

        if(storage[hashValue] == null || storage[hashValue][key/bucketSize] == null) {
            return -1;
        }

        return storage[hashValue][key/bucketSize].getValue();
    }

    public void remove(int key) {
        int hashValue = hash(key);

        if(storage[hashValue] != null && storage[hashValue][key/bucketSize] != null) {
            storage[hashValue][key/bucketSize] = null;
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

// Hashmap using linear chaining
class MyHashMap {

    class Node {
        int key;
        int value;

        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;

            this.next = null;
        }

        public int getKey() {
            return this.key;
        }

        public int getValue() {
            return this.value;
        }
    }

    Node[] storage;

    int buckets;

    public MyHashMap() {
        buckets = 10000;

        storage = new Node[buckets];
    }

    private int hash(int key) {
        return key%buckets;
    }

    private Node search(Node head, int key) {
        Node current = head;
        Node prev = null;

        while(current != null && current.key != key) {
            prev = current;
            current = current.next;
        }

        return prev;
    }

    public void put(int key, int value) {

        int hash = hash(key);
        Node newNode = new Node(key, value);

        if(storage[hash] == null) {
            storage[hash] = newNode;
        } else {
            Node prevNode = search(storage[hash], key);

            if(prevNode == null) {
                storage[hash].value = value;
            } else if(prevNode.next == null) {
                prevNode.next = newNode;
            } else {
                prevNode.next.value = value;
            }
        }
    }

    public int get(int key) {
        int hash = hash(key);

        if(storage[hash] == null) {
            return -1;
        } else {
            Node prevNode = search(storage[hash], key);

            if(prevNode == null) {
                return storage[hash].value;
            } else if(prevNode.next != null) {
                return prevNode.next.value;
            }
        }

        return -1;
    }

    public void remove(int key) {
        int hash = hash(key);

        if(storage[hash] == null) {
            return;
        } else {
            Node prevNode = search(storage[hash], key);

            if(prevNode == null) {
                storage[hash] = storage[hash].next;
            } else if(prevNode.next != null) {
                Node temp = prevNode.next;
                prevNode.next = prevNode.next.next;
                temp = null;
            }

            return;
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