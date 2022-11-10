/*Time Complexity -O(1)
Space Complexity - O(n)
We develop a double hashing function wherein we hash the key out of the key value pair and place those keys into
the secondary array which is LinkedList.
* For all 3 put push and remove we need to use find the node.
* */

public class MyHashMap {

    class Node{
        Node next;
        int key,value;
        public Node(int key,int value){
            this.key = key;
            this.value = value;

        }
    }
    Node[] nodes;
    int buckets;
    public MyHashMap() {
        buckets=10000;
        nodes = new Node[buckets];
    }
    int getBuckets(int key){
        return Integer.hashCode(key)%buckets;
    }
    Node find(Node head, int key){
        Node prev = head;
        Node curr = head.next;
        while(curr!= null && curr.key != key ){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    public void put(int key, int value) {
        int bucket = getBuckets(key);
        if(nodes[bucket]==null){
            nodes[bucket]= new Node(-1,-1);

        }
        Node prev = find(nodes[bucket],key);
        if(prev.next!=null){
            prev.next.value=value;
            return;
        }
        prev.next = new Node(key,value);
    }

    public int get(int key) {
        int bucket = getBuckets(key);
        if(nodes[bucket]==null){
            return -1;
        }
        Node prev = find(nodes[bucket],key);
        if(prev.next!=null){
            return prev.next.value;
        }
        return -1;


    }

    public void remove(int key) {
        int bucket = getBuckets(key);
        if(nodes[bucket]==null){
            return;
        }
        Node prev = find(nodes[bucket],key);
        if(prev.next!=null){
            prev.next = prev.next.next;
        }

    }

    public static void main(String[] args) {
        MyHashMap obj = new MyHashMap();
 obj.put(1,1000);
 int param_2 = obj.get(1);
 obj.remove(1);
    }
}
