// Time Complexity : O(1) in average and O(n) in worst case for all operations
// Space Complexity : O(n) where n is number of entries
// Did this code successfully run on Leetcode : Yes



// Your code here along with comments explaining your approach

/*
We take 10000 as bucket size, where each bucket will contain list of Node class. Node class will have
key, value and ptr to next node.

For put, we get index of the bucket using modulo hash function. If the bucket for that has null pointer
then we add a dummy node and then create a new node after that with our key and value;
In case its not null, we traverse the entire list, if where we keep a prev pointer to stop at a position before
current pointer. If next of prev pointer is null, that means its a new node hence insert new node..
or else the key is same, in that case we just update the value


For get, we get the bucket index from hashing function, if that bucket points to null, that means element not found;
if bucket has list, we traverse till we get an element and keep a prev pointer.
if prev.next is null that means not found else return prev.next.value;

For remove, get index of bucket using hashing function. Perform same operation as get function.
In the last step, instead of returing, just point prev.next to prev.next.next ie to next element of prev.next
so that breaks the link of one node which we want to remove.


* */
class Node{
    int key,value;
    Node next;
    public Node(int key,int value)
    {
        this.key=key;
        this.value=value;
    }
}

public class DesignHashMap {
    Node[] storage;
    int bucketSize;

    public DesignHashMap() {
        bucketSize=10000;
        storage=new Node[bucketSize];
    }

    private int getIndex(int key)
    {
        return key % bucketSize;
    }

    private Node getPrev(Node head,int key)
    {
        Node prev=null;
        Node curr=head;

        while(curr!=null && curr.key!=key)
        {
            prev=curr;
            curr=curr.next;
        }
        return prev;
    }

    public void put(int key, int value) {
        int index=getIndex(key);
        if(storage[index]==null)
        {
            storage[index]=new Node(-1,-1);
            storage[index].next=new Node(key,value);
            return;
        }

        Node prev=getPrev(storage[index],key);

        if(prev.next==null)
        {
            prev.next=new Node(key,value);

        }
        else
        {
            prev.next.value=value;
        }
    }

    public int get(int key) {
        int index=getIndex(key);
        if(storage[index]==null)
            return -1;
        Node prev=getPrev(storage[index],key);
        if(prev.next==null)
            return -1;
        return prev.next.value;
    }

    public void remove(int key) {
        int index=getIndex(key);
        if(storage[index]==null)
            return;
        Node prev=getPrev(storage[index],key);
        if(prev.next==null)
            return;
        prev.next=prev.next.next;

    }
}
