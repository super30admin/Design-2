// used storage as primary to store address of nodes and then adding node 
//time complexity : o(n) and space complexity : O(n+m)

class MyHashMap {

    class Node{
        int key;
        int val;
        Node next;

        public Node(int key, int val){
            this.key= key;
            this.val = val;
        }
    }

    Node [] storage ;

    public MyHashMap() {
        this.storage = new Node[10000];
    }

    private int hash(int key){
        return Integer.hashCode(key)%storage.length;

    }
    private Node find(Node node, int key){
        Node curr = node;
        Node prev = null;
        while(curr != null && curr.key != key){
            prev= curr;
            curr = curr.next;

        }
        return prev;

    }
    
    public void put(int key, int value) {
        int index = hash(key);
        if(storage[index] == null){
            storage[index] = new Node(-1,-1);
        }

        Node prev = find(storage[index], key);
        if(prev.next == null){
            prev.next = new Node(key, value);

        }else{
            prev.next.val = value;
        }

    }
    
    public int get(int key) {
        int index = hash(key);
         if(storage[index] == null){
             return -1;
         }else{
             Node prev = find(storage[index], key);
             if(prev.next == null){
                 return -1;
             }else{
                 return prev.next.val;
             }

         }
    }
    
    public void remove(int key) {

        int index = hash(key);
        Node prev = find(storage[index], key);
       

        if(prev !=null && prev.next != null){
            prev.next = prev.next.next;
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