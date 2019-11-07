// Time Complexity :
//mthods::add:O(n)
//remove:O(n)
//contains:O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :I was getting null pointer exception in contains method and type incompatible exception while assigning values in wrong manner
//this is new commeng-------------------

// Your code here along with comments explaining your approach

class MyHashSet {
    //an array node of the objexts of class ListNode was created
    ListNode[] node=new ListNode[1000000];
     
    /** Initialize your data structure here. */
    private class ListNode
    {   //ListNode class contains attributes key and next
        int key;
        ListNode next;
        //key was initialised in the constructor
        ListNode(int key)
        {
            this.key=key;
        }
        
    }
    public MyHashSet() 
    {
        
    }
    //to find index of the given key we are using hashCode as follows
    int index(int key)
    {
        return Integer.hashCode(key)%node.length;
    }
    //a method is made to find the location previous than the node to be found in parameters
    ListNode find(ListNode head,int key)
    {   //curr pointer is assigned on the starting of the array and prev is null
        ListNode curr=head;
        ListNode prev=null;
        //while curr is not null and curr key is equal to the required value,loop is continued
        while(curr!=null && curr.key!=key)
        {//curr is assigned to prev
            prev=curr;
            //curr is incremented
            curr=curr.next;
        }
        //at end of the loop,it gives node previous to the key to be found
        return prev;
    }
    
    public void add(int key) 
    {  //index of the key is stored in integer i
        int i=index(key);
        //if the node is null,we'll create a new node having key=-1
        if(node[i]==null)
        {
            node[i]=new ListNode(-1);
        }
        //pointer previous to the node is found
        ListNode prev=find(node[i],key);
        //if next to the prev is null,A new listnode is inserted at the end
        if(prev.next==null)
        {
            prev.next=new ListNode(key);
        }
        else
        {   //key is updated to its value
            prev.next.key=key;
        }
    }
    
    
    public void remove(int key) 
    {   //index is found
         int i=index(key);
        //if node is not there, do nothing
        if(node[i]==null)
        {return;}
      //prev to the node is found
        ListNode prev=find(node[i],key);
            
        //if the node is null, do nothing
        if(prev.next==null){return;}
        //we point the pointer to next to the node to be removed
        prev.next=prev.next.next;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) 
    {
        //index is found
     int i=index(key);
        //if it is not there return false
        if(node[i]==null)
        {return false;}
        //previous to the node is found
        ListNode prev=find(node[i],key);
        //if next to the node is not null,check for the value and if it is there,return true else false
        if( prev.next!=null)
     { if(prev.next.key==key )
       {return true;}}
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */