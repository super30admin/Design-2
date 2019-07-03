public class MyHashSet {
    ListNode[] nodes = new ListNode[100000];

    public class ListNode{
        int key;
        ListNode next;
        public ListNode(int data){
            this.key = data;
            this.next = null;
        }
    }
    public MyHashSet(){

    }

    public void add(int key){
        int index = index(key);
        if(nodes[index] == null)
            nodes[index] = new ListNode(-1);
        ListNode prev = find(nodes[index],key);
        if(prev.next==null)
            prev.next = new ListNode(key);

    }
    public void remove(int key){
        ListNode prev = find(nodes[index(key)],key);
        if(prev.next == null)
            return;
        else
            prev.next = prev.next.next;
    }
    public boolean contains(int key){
        int index = index(key);
        if(nodes[index] == null)
            return false;
        else{
            ListNode prev = find(nodes[index],key);
            if(prev.next==null)
                return false;
            return true;
        }
    }

    public int index(int key){
        int x = Integer.hashCode(key);
        return Integer.hashCode(key)%nodes.length;

    }
    public ListNode find(ListNode bucket,int key){
        ListNode dummy = bucket,prev = null;
        while (dummy!=null && dummy.key!=key){
            prev = dummy;
            dummy = dummy.next;
        }
        return prev;
    }
    public static void main(String[] args) {
        MyHashSet hashSet = new MyHashSet();
        hashSet.add(1);
        hashSet.add(2);
        System.out.println(hashSet.contains(1));    // returns true
        System.out.println(hashSet.contains(3));    // returns false (not found)
        hashSet.add(2);
        System.out.println(hashSet.contains(2));    // returns true
        hashSet.remove(2);
        System.out.println(hashSet.contains(2));    // returns false (already removed)
    }
}
