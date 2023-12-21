// Accepted on leetcode
// Simple chaining problem ; just made a array and than on each node refrenced to the head of the linked list and in each node of the linked list stored the key value pairs. 
// Time complexites Put O(1) amotized as number of noded is constant; get , remove is also O(1)





class MyHashMap {
    public class Node {
        int key;
        int value;
        Node next;

   
        public Node(int key,int data) {
            this.key = key;
            this.value = data;
            this.next = null;
        }
    }
    Node[] arr;

    public MyHashMap() {
        this.arr = new Node[10000];

    }

    public int hash(int x){
        int r = x % 10000;
        return r;
    }
    public Node find(int key){
        int result = hash(key);
        Node crr = arr[result];
        Node prv = null;
        while(crr!=null){
            if(crr.key==key){
                return prv;
            }
            prv = crr;
            crr=crr.next;

        }
        return prv;

    }
    
    public void put(int key, int value) {
        int result = hash(key);
        Node newnode = new Node(key,value);
        if(arr[result]==null){
            arr[result] = new Node(-1,-1);
            arr[result].next = newnode;

        }
        else{
            Node prv = find(key);
            if(prv.next == null){
                prv.next = newnode;
            }
            else{
                prv.next.value  = value;
            }
            
        }

        
    }
    
    public int get(int key) {
        int result = hash(key);
        Node crr = arr[result];
        if(crr==null) return -1;
        
        Node prv = find(key);

        if(prv.next==null) return -1;
        


        return prv.next.value;


        
    }
    
    public void remove(int key) {
        int result = hash(key);
        Node crr = arr[result];
        if(crr==null) return;
        Node prv = find(key);
        if (prv.next==null) return;
        prv.next= prv.next.next;
        return;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */