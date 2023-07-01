// Time Complexity : O(1)
// Space Complexity : O(1) (defined range)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

class DesignHashMap {
    class Node {
        int key;
        int val;
        Node next;
        Node(int key, int val){
            this.key=key;
            this.val=val;
        }
    }
    Node[] s1;
    public DesignHashMap() {
        this.s1 = new Node[10000];
    }

    private int bucketIndex(int key){
        return key%10000;
    }

    private Node find(Node head, int key){
        Node prev = null;
        Node curr = head;
        while(curr!=null && curr.key!=key){
            prev = curr;
            curr=curr.next;
        }
        return prev;
    }

    public void put(int key, int value) {
        int bucketIndex = bucketIndex(key);
        if(s1[bucketIndex] == null){
            s1[bucketIndex] = new Node(-1,-1);
        }
        Node prev = find(s1[bucketIndex], key);
        if(prev.next == null){
            prev.next = new Node(key, value);
        }
        prev.next.val = value;
    }

    public int get(int key) {
        int bucketIndex = bucketIndex(key);
        if(s1[bucketIndex] == null){
            return -1;
        }
        Node prev = find(s1[bucketIndex], key);
        if(prev.next==null){
            return -1;
        }
        return prev.next.val;
    }

    public void remove(int key) {
        int bucketIndex = bucketIndex(key);
        if(s1[bucketIndex] == null){
            return;
        }
        Node prev = find(s1[bucketIndex], key);
        if(prev.next==null){
            return;
        }
        prev.next = prev.next.next;

    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */