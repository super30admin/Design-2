public class MyHashMap
{

    public class Node
    {
        public int key;
        public int value;
        public Node next;

        public Node(int key, int value)
        {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public Node[] storage;

    public MyHashMap()
    {
        this.storage = new Node[1000];
    }

    public int hash(int key)
    {
        return key % 1000;
    }

    public Node find(Node head, int key)
    {
        Node prev = head;
        Node curr = head.next;
        while (curr != null && curr.key != key)
        {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    public void Put(int key, int value)
    {
        int i = hash(key);
        if (this.storage[i] == null)
        {
            this.storage[i] = new Node(-1, -1); // creating a dummy node
        }

        Node prev = find(this.storage[i], key);
        if (prev.next == null)
        {
            prev.next = new Node(key, value);
        }
        else
        {
            prev.next.value = value;
        }
    }

    public int Get(int key)
    {
        int i = hash(key);
        if (this.storage[i] == null)
        {
            return -1;
        }
        Node prev = find(this.storage[i], key);
        if (prev.next == null)
        {
            return -1;
        }
        return prev.next.value;

    }

    public void Remove(int key)
    {
        int i = hash(key);
        if (this.storage[i] == null)
        {
            return;
        }
        Node prev = find(this.storage[i], key);
        if (prev.next == null)
        {
            return;
        }
        prev.next = prev.next.next;
    }

}