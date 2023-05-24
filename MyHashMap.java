// Time Complexity : O(1)

// Space Complexity : O(1)

// Did this code successfully run on Leetcode :
    //Yes. It beats 99.82% of all Java submissions in terms of Time Complexity and 95.48% of them in terms of Space Complexity.

// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
    //I am using Linear Chaining Method to avoid collisions. 
    //Locate the head of the Linked List using the hash index. Traverse through the LL,
    //Add new numbers at end of the LL.
    //We remove the numbers or check their availability like a general Singly LL.

class MyHashMap {

    private ListNode[] hashArray;
    private int primeNumber = 10067;

    public MyHashMap() {
        hashArray = new ListNode[primeNumber];
    }
    
    public void put(int key, int value) {
        ListNode temp = new ListNode(key, value);
        int hashIndex = key%primeNumber;
        ListNode head = hashArray[hashIndex];
        if (head==null)
        {
            head = temp;
            hashArray[hashIndex] = head;
            return;
        }
        ListNode curr = head;
        while(curr.next!=null)
        {
            if (curr.key==key)
            {
                curr.value = value;
                return;
            }
            curr = curr.next;
        }
        if (curr.key==key)
        {
            curr.value = value;
            return;
        }
        curr.next = temp;
        hashArray[hashIndex] = head;
    }
    
    public int get(int key) {
        
        int hashIndex = key%primeNumber;
        ListNode head = hashArray[hashIndex];
        if (head==null)
        {
            return -1;
        }
        ListNode curr = head;
        while(curr!=null)
        {
            if (curr.key==key)
            {
                return curr.value;
            }
            curr = curr.next;
        }
        return -1;
    }
    
    public void remove(int key) {
        int hashIndex = key%primeNumber;
        ListNode head = hashArray[hashIndex];
        if (head==null)
        {
            return;
        }
        if (head.key==key)
        {
            head = head.next;
            hashArray[hashIndex] = head;
            return;
        }
        ListNode curr = head;
        while(curr.next!=null)
        {
            if (curr.next.key==key)
            {
                curr.next = curr.next.next;
                hashArray[hashIndex] = head;
                return;
            }
            curr = curr.next;
        }
        hashArray[hashIndex] = head;
    }
}
    
class ListNode {
    int key;
    int value;
    ListNode next;

    ListNode(int key, int value)
    {
        this.key = key;
        this.value = value;
        next = null;
    }

    @Override
    public String toString()
    {
        return "["+this.key+", "+this.value+"]";
    }
    
    public void print()
    {
        ListNode curr = this;
        while(curr!=null)
        {
            System.out.print(curr+"->");
            curr = curr.next;
        }
        System.out.println("Null");
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */