//Optimal Solution for HashMap implementation
//with linked list
//Time Complexity:o(1) and o(n) in worst case
//Space Complexity:o(n)

class Node
{
    int key;
    int value;
    Node next;

    public Node(int key,int value)
    {
        this.key=key;
        this.value=value;
    }
}

public class Solution {

    int buckets=10000;
    Node[] storage;
    private int hashFunction1(int key)
    {
        return key%buckets;
    }
    public Solution() {

        storage=new Node[buckets];
    }

    public Node find(Node head,int key)
    {
        Node prev;
        Node curr;
        prev=null;
        curr=head;
        while(curr!=null && curr.key!=key)
        {
            prev=curr;
            curr=curr.next;

        }
        return prev;
    }
    public void put(int key, int value) {
        //chk if key exists in linked list
        int bucket=hashFunction1(key);
        if(storage[bucket]==null)
        {
            storage[bucket]=new Node(-1,-1);//default head
        }

        Node prev=find(storage[bucket],key);
        //send head node and key to search
        //node is not present in list
        if(prev.next==null)
            prev.next=new Node(key,value);
        else
            prev.next.value=value;

    }

    public int get(int key) {
        int bucket=hashFunction1(key);
        if(storage[bucket]==null) return -1;
        Node prev=find(storage[bucket],key);
        if(prev.next==null) return -1;
        else return prev.next.value;

    }

    public void remove(int key) {
        int bucket=hashFunction1(key);
        if(storage[bucket]==null) return;
        Node prev=find(storage[bucket],key);
        if(prev.next==null)
            return;
        else
            prev.next=prev.next.next;

    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */