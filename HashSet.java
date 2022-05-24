class MyHashSet {
    class Node{
        int val;
        Node next;
        public Node(int x) {
this.val=x;
this.next=null;
        }
    }

    private Node[] arr;
    private int size;


    public MyHashSet() {
this.size=8;
this.arr = new Node[size];
    }

    public int hashFunc(int key){
        return key%10;
    }

    public void add(int key) {
        int index = hashFunc(key);
        if(arr[index]==null){
        arr[index]= new Node(key);
        } else if(arr[index].val==key) {
            return;
        } else {
            //find the next FREE index
            Node head = arr[index];
            while(head.next!=null){
                if(head.val==key) {
                    return;
                }
                head=head.next;
            }
            head.next = new Node(key);
        }
    }

    public void remove(int key) {
        int index = hashFunc(key);
            Node head = arr[index];
            if(head!=null&&head.val==key) {
                System.out.println("Successfully removed.");
            head=null;
            return;
            }
            Node head2 = head.next;
            while (head2!=null){
                if(head.val==key){
                    System.out.println("Successfully removed.");
                    head.next=head2.next;
                }
                head=head.next;
                head2=head2.next;
            }
    }

    public boolean contains(int key) {
        int index = hashFunc(key);

            Node head = arr[index];
            while (head!=null){
                if(head.val==key){
                    System.out.println("Successfully Found.");
                    return true;

                }
            }
        return false;
    }
    public static void main(String[] args){
        MyHashSet hashSet = new MyHashSet();
        hashSet.add(1);
        hashSet.add(2);
       System.out.println(hashSet.contains(1));    // returns true
        System.out.println(hashSet.contains(3));    // returns false (not found)
        hashSet.add(2);
        System.out.println(hashSet.contains(2));    // returns true
        hashSet.remove(2);
        hashSet.remove(2);
        System.out.println(hashSet.contains(2));    // returns false (already removed)
    }
}