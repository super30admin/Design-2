// Time Complexity is o(n) and Space complexity is o(i)
class MyHashMap {
    public static class Node{
        int key;
        int value;

        public Node(int key,int value)
        {
            this.key=key;
            this.value=value;
        }

    }
    LinkedList<Node>[] bucket;
    int max=100;
    public MyHashMap() {
        bucket = new LinkedList[max];
        for(int i=0;i<100;i++)
        {
            bucket[i] = new LinkedList<Node>();
        }
    }

    public int bucketHash(int key)
    {
        int bi = key%max;
        return bi; 
    }

    public int listHash(int key,int bi)
    {
        LinkedList<Node> ll = bucket[bi];
        for(int i=0;i<ll.size();i++)
        {
            if(ll.get(i).key == key) return i;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        int bi = bucketHash(key);
        int li = listHash(key,bi);

        if(li == -1)
    {
        LinkedList<Node> ll = bucket[bi];
        ll.add(new Node(key,value));
    }
    else
    {
        Node node = bucket[bi].get(li);
        node.value = value;

    }
        
    }
    
    public int get(int key) {
        int bi = bucketHash(key);
        int li = listHash(key,bi);
        if(li == -1) return -1;
        return bucket[bi].get(li).value;
        
    }
    
    public void remove(int key) {
        int bi = bucketHash(key);
        int li = listHash(key,bi);
        
        if(li == -1) return;
        bucket[bi].remove(li);
        
    }
}
