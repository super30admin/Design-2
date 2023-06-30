# // Time Complexity : O(1)
# // Space Complexity : O(N)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : just had to keep a check on P's value
# // Your code here along with comments explaining your approach: i used a 10^5 array and chaining with a linked list.

class Node:
    def __init__(self, key, data):
        self.data= data
        self.key= key
        self.next=None

class MyHashMap:
    buckets=100000
    # bucket_size=10

    def __init__(self):
        self.hash_pri=[None for i in range(self.buckets)]

    def keyhash(self, key):
        return key%100000

    def find(self, ref, key):
        prev= ref
        curr= ref.next
        while(curr!=None and curr.key!=key):
            prev=curr
            curr=curr.next
        return prev

    def put(self, key: int, value: int) -> None:
        which_bucket=self.keyhash(key)
        if(self.hash_pri[which_bucket]==None):
            self.hash_pri[which_bucket]=Node(None, None)
            newnode= Node(key, value)
            self.hash_pri[which_bucket].next=newnode
        else:
            p=self.find(self.hash_pri[which_bucket],key)
            if(p.next==None):
                newnode= Node(key, value)
                p.next=newnode
            else:
                p.next.data=value

    def get(self, key: int) -> int:
        which_bucket= self.keyhash(key)
        if(self.hash_pri[which_bucket]==None):
            return -1
        p=self.find(self.hash_pri[which_bucket], key)
        if(p.next==None):
            return -1
        else:
            return p.next.data

    def remove(self, key: int) -> None:
        which_bucket= self.keyhash(key)
        if(self.hash_pri[which_bucket]!=None):
            p=self.find(self.hash_pri[which_bucket], key)
            if(p.next!=None):
                p.next=p.next.next

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)