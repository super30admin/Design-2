class MyHashMap {
    private Node[] items;
    private int primaryBucket;
    public class Node{
        private int key;
        private int val;
        private Node next;

        public Node(int key,int val){
            this.key=key;
            this.val=val;
        }
    }
    public MyHashMap() {
        this.primaryBucket=10000;
        this.items=new Node[primaryBucket];
    }
    
    public void put(int key, int value) {
         int index=hash(key);
         if(items[index]==null){
            Node prev=new Node(-1,-1);
            items[index]=prev;
            prev.next=new Node(key,value);
            return;
         }
         Node prev=getPrev(items[index],key);
            if(prev.next==null)prev.next=new Node(key,value);
            else prev.next.val=value;
    }
    
    public int get(int key) {
        int index=hash(key);
         if(items[index]==null){
            return -1;
         }
        Node prev=getPrev(items[index],key);
        if(prev.next==null)return -1;
        else return prev.next.val;
    }
    
    public void remove(int key) {
        int index=hash(key);
         if(items[index]==null)return;
         
        Node prev=getPrev(items[index],key);
        if(prev.next!=null)prev.next=prev.next.next;
    }

    private int hash(int key){
        return key % primaryBucket;
    }

    private Node getPrev(Node head,int key){
        Node prev=head;
        Node cur=prev.next;
        while(cur!=null && cur.key!=key){
            prev=cur;
            cur=cur.next;
        }
        return prev;
    }
}
