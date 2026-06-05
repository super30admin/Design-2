# Design HASHMAP
# Time Complexity : put, get and remove function have O(1) time complexity and find 
# function has O(N) time complexity in worst case scenario
# Space Complexity : O(M+N) where M is primary bucket and N is the bucket which has unique keys
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : I was missing a lot of edge cases scenarios here 
# so I had some hinderance in implementingthe code all together.

class MyHashMap(object):

    class Node:
        def __init__(self,key,value):
            self.key=key
            self.value=value
            self.next=None
    
    def __init__(self):
        self.primary_bucket=10000
        self.size=[None]*self.primary_bucket
        
    def hashfunc1(self,key):
        return key%self.primary_bucket

    def find(self,head,key):
        prev=None
        current=head
        while current and current.key!=key:
            prev=current
            current=current.next
        return prev
    
    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: None
        """
        primary_index=self.hashfunc1(key)
        if self.size[primary_index]==None:
            self.size[primary_index]=self.Node(-1,-1)
            self.size[primary_index].next=self.Node(key,value)
            return
        prev=self.find(self.size[primary_index],key)
        if prev.next is None:
            prev.next=self.Node(key,value)
        else:
            prev.next.value=value 
        
    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        primary_index=self.hashfunc1(key)
        if self.size[primary_index] is None:
            return -1
        prev=self.find(self.size[primary_index],key)
        if prev.next is None:
            return -1
        return prev.next.value
        

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        primary_index=self.hashfunc1(key)
        if self.size[primary_index] is None:
            return
        prev=self.find(self.size[primary_index],key)
        if prev.next is None:
            return
        prev.next=prev.next.next
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)