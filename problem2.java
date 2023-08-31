//## Problem 2: Design Hashmap (https://leetcode.com/problems/design-hashmap/)

// Time Complexity : O(k) [k is the maximum length of the linked list, worst case O(100) in the program below]
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : none


// Your code here along with comments explaining your approach
// approach: To save space all the keys were not mapped to the elements in array, the size was reduced to 10^4 from 10^6. And in case of conflicts from the hashing function, linked kist were created from each node of the array. Linked list was updated or traversed whenever an operation was needed on the hashmap.


class MyHashMap {

    class node {
        int key;
        int value;

        node next;

        public node(int key, int value)
        {
            this.key =key;
            this.value = value;
        }
    }

    int buckets;
    node[] s;


    public MyHashMap() {
        buckets = 10000;
        s = new node[buckets];
        
    }

    private int posBucket(int key)
    {
        return Integer.hashCode(key)%buckets;
    }

    private node find(node dummy, int key)
    {
        node prev =dummy;
        while(prev.next!=null && prev.next.key!=key)
        {
            prev = prev.next;
        }
        return prev;
    }
    
    public void put(int key, int value) {
        int bucket = posBucket(key);
        if(s[bucket]==null)
        {
            s[bucket] = new node(-1,-1);
        }
        node prev = find(s[bucket],key);
        if(prev.next==null)
        {
            prev.next = new node(key,value);
        }
        else
        {
            prev.next.value = value;
        }
    }
    
    public int get(int key) {
        int bucket = posBucket(key);
        if(s[bucket]==null)
        {
            return -1;
        }

        node prev = find(s[bucket],key);
        if(prev.next ==null)
        {
            return -1;
        }
        else
        {
            return prev.next.value;
        }
        
    }
    
    public void remove(int key) {
        int bucket = posBucket(key);
        if(s[bucket]==null)
        {
            return ;
        }
        node prev = find(s[bucket],key);
        if(prev.next ==null)
        {
            return;
        }
        else
        {
            prev.next = prev.next.next;
        }
        
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */