
class MyHashMap {

Node[] storage;
int bucket;
    class Node {
        int key;
        int value;
        Node next;

        public Node(int key,int value){
            this.key=key;
            this.value=value;

        }
    }


    public MyHashMap() {
        this.bucket=10000;
        this.storage=new Node[bucket];
        
    }
    
    private int hash(int key){
        return key%bucket;
    }


    private Node getprev(Node head,int key){
        Node prev=null;
        Node curr=head;
        while (curr!= null && curr.key !=key){
            prev =curr;
            curr =curr.next;

        }
        return prev;
    }

    public void put(int key, int value) {
        int index=hash(key);

        if(storage[index]==null){
            storage[index]=new Node(-1,-1);
            storage[index].next=new Node(key,value);
            return;
        }


        Node prev = getprev(storage[index],key);
        if(prev.next ==null){
            prev.next= new Node(key,value);
        }else{
            prev.next.value=value;
        }


    }
    
    public int get(int key) {
        
        int index=hash(key);
        if(storage[index]==null){
            return -1;
        }

        Node prev = getprev(storage[index],key);

        if(prev.next==null){
            return -1;

        }
        return prev.next.value;
    }
    


    public void remove(int key) {
        int index=hash(key);


        if(storage[index]==null){
            return;
        }

        Node prev = getprev(storage[index],key);
        
        if(prev.next==null){
            return;

        }
        prev.next= prev.next.next;
    }


}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
