'''

// Time Complexity : O(N)
// Space Complexity : O(N)  where N is Number of buckets + Number of unique values
// Did this code successfully run on Leetcode :  Yes
// Any problem you faced while coding this :    Found issue to arrive the logic


// Your code here along with comments explaining your approach

    Approach has following classes
        Bucket
            This will hold a LinkedList to store keys from key collision 

        HashSet
            This will create as many buckets of key_space
            add
                Hash the key -> decide bucket -> update into the bucket
            contains
                Hash the key -> decide bucket -> check this bucket contains the value

 https://leetcode.com/problems/design-hashset/solution/
 05:40
'''

class Node:
    def __init__(self,data=None,nextNode=None):
        self.data=data
        self.next=nextNode
        
class Bucket:
    def __init__(self):
        self.head=Node(0)
    
    def insert(self,data):
        if not self.exists(data):
            newNode=Node(data,self.head.next)
            self.head.next=newNode
        
    
    def delete(self,data):
        prev=self.head
        curr=self.head.next
        
        while curr is not None:
            if curr.data==data:
                prev.next=curr.next
                return
            prev=curr
            curr=curr.next
            
        
    
    def exists(self,data)->bool:
        curr=self.head.next
        while curr is not None:
            if curr.data==data:
                return True
            curr=curr.next
        return False
        
        
        


class MyHashSet:

    def __init__(self):
        self.key_space=2069
        self.hash_table=[Bucket() for x in range(self.key_space)]

    def add(self, key: int) -> None:
        hash_key=key%self.key_space
        self.hash_table[hash_key].insert(key)

    def remove(self, key: int) -> None:
        hash_key=key%self.key_space
        self.hash_table[hash_key].delete(key)
        

    def contains(self, key: int) -> bool:
        hash_key=key%self.key_space
        return self.hash_table[hash_key].exists(key)
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)