#TimeComplexity: put get remove all in O(1)
#SpaceComplexity: O(N)
#It successfully runs on leetcode
#I'm sorry Hashmap design is part of design-1 sprint 
# but I got confused and I submitted Design Hashset in design-1 instead of Hashmap so submitting both here again

class Node:
    def __init__(self,key, val):
        self.key=key
        self.val=val
        self.next=None

class MyHashMap:
    buckets=0
    storage=[]
    def __init__(self):
        self.buckets=10000
        self.storage=[None for _ in range(self.buckets)]
        
    def bucketfind(self,head,key):
        prev=None
        cur=head 
        while cur and cur.key!=key:
            prev=cur
            cur=cur.next
        return prev
    
    def bucket(self,key):
        return key%1000

    def put(self, key: int, value: int) -> None:
        bucket= self.bucket(key)
        if self.storage[bucket]==None:
            self.storage[bucket]=Node(-1,-1)
        prev= self.bucketfind(self.storage[bucket], key)
        if prev.next==None:
            prev.next= Node(key,value)
        else:
            prev.next.val=value
        
    def get(self, key: int) -> int:
        bucket= self.bucket(key)
        if self.storage[bucket]==None: return -1
        prev= self.bucketfind(self.storage[bucket], key)
        if prev.next==None: return -1
        return prev.next.val
        

    def remove(self, key: int) -> None:
        bucket= self.bucket(key)
        if self.storage[bucket]==None: return
        prev= self.bucketfind(self.storage[bucket], key)
        if prev.next==None: return
        prev.next = prev.next.next 


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)