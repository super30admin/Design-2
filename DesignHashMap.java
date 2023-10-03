
//Time Complexity for all: O(1)
//Space Complexity for all: O(n)
// Solution runs on leetcode
public class DesignHashMap {

    class Node{
        int key;
        int val;
        Node next;

        public Node (int key, int val) {
                this.key = key;
                this.val = val;
            }
        }

        private Node[] storage;

        private int hash(int key){
            return key%10000;
        }

        public DesignHashMap(){
            this.storage = new Node[10000];
        }

        private Node search(Node head, int key){
            Node prev = null;
            Node curr = head;
            while(curr != null && curr.key != key){
                prev = curr;
                curr = curr.next;
            }

            return prev;
        }

    
        public void put(int key, int value) {

        int idx = hash(key);
        if(storage[idx] == null){
            storage[idx] = new Node(-1,-1);
        }

        Node prev = search(storage[idx],key);

        if(prev.next == null){
            //node doesn't exist
            prev.next = new Node(key,value);
        }
        else
        {
            //node exists, we replace with the new value
            prev.next.val = value;
        }
        
    }
    
    public int get(int key) {
        int idx = hash(key);
        if(storage[idx] == null) return -1;
        Node prev = search(storage[idx],key);
        if(prev.next==null){
            return -1;
        }        
        else
        {
            return prev.next.val;
        }
    }
    
    public void remove(int key) {
        int idx = hash(key);
        if(storage[idx] == null) return;
        Node prev = search(storage[idx],key);
        if(prev.next==null){
            return;
        }
        else
        {
            if(prev.next.next==null)
            {
                prev.next = null;
                return;
            }

            prev.next = prev.next.next;
            return;

        }
    }

    public static void main(String[] args) {
        DesignHashMap   design = new DesignHashMap();

        design.put(10, 23);
        design.put(10, 24);
        design.put(10, 25);
        design.put(10, 26);
        design.put(10, 27);
        design.put(14, 23);
        design.put(15, 23);
        design.put(12, 23);

        design.remove(14);
        System.out.println("DesignHashMap Get" + design.get(10));
    }
}
