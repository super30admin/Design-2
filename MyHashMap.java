class MyHashMap {
    private Node[] primaryArray;
    private int primaryArraySize;

    public MyHashMap() {
        this.primaryArraySize = 10000;
        this.primaryArray = new Node[primaryArraySize];
    }

    // hash function on primary array
    private int getHash(int key) { // Time: O(1) Space: O(1)
        return key % primaryArraySize;
    }

    // helper used across get, put and remove which returns previousNode
    private Node helper(int key) { // Time: amortized O(1) Space: O(1)
        int hash = getHash(key);

        if (primaryArray[hash] == null) {
            return null;
        } else {
            Node node = primaryArray[hash];
            while (node.next != null && node.next.key != key) {
                node = node.next;
            }
            return node;
        }
    }

    public void put(int key, int value) { // Time: amortized O(1) Space: O(1)
        Node prevNode = helper(key);

        if (prevNode == null) { // add dummy node as first node in the chain
            Node dummy = new Node (-1, -1);
            Node newPair = new Node (key, value);
            dummy.next = newPair;
            primaryArray[getHash(key)] = dummy;
        } else if (prevNode.next == null) { // if no Node after previousNode, new pair
            Node newPair = new Node (key, value);
            prevNode.next = newPair;
        } else { // update existing Node with new value
            prevNode.next.value = value;
        }
    }

    public int get(int key) { // Time: amortized O(1) Space: O(1)
        Node prevNode = helper(key);

        if (prevNode == null || prevNode.next == null) { // if null or dummy not alone
            return -1;
        } else {
            return prevNode.next.value;
        }

    }

    public void remove(int key) {
        Node prevNode = helper(key);

        if (prevNode == null || prevNode.next == null) { // if null or dummy not alone
            return;
        } else {
            Node temp = prevNode.next;
            prevNode.next = temp.next;
            temp.next = null;
        }
    }
}

class Node {
    int key;
    int value;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}