//time complexity-o(1)
//space complexity-o(n)

//Approach is to create a array of nodes and creata a hashmap using chaining process.
class node {
    int key;
    int value;
    node next;

    public node(int key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}

class MyHashMap {
    node arr[];

    public MyHashMap() {
        arr = new node[10000];
    }

    public int outter(int key) {
        return key % 10000;
    }

    public node search(node head, int key) {
        node prev = null;
        node curr = head;
        while (curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    public void put(int key, int value) {
        int i = outter(key);
        if (arr[i] == null) {
            arr[i] = new node(-1, -1);
        }
        node x = search(arr[i], key);
        if (x.next == null) {
            node n = new node(key, value);
            x.next = n;
        } else {
            x.next.value = value;
        }
    }

    public int get(int key) {
        int i = outter(key);
        if (arr[i] == null)
            return -1;
        node x = search(arr[i], key);
        if (x.next == null)
            return -1;
        else {
            return x.next.value;
        }
    }

    public void remove(int key) {
        int i = outter(key);
        if (arr[i] == null)
            return;
        node x = search(arr[i], key);
        if (x.next == null)
            return;
        x.next = x.next.next;
    }
}