class MyHashMap:
    class Node:
        def __init__(self,key,value):
            self.key=key
            self.value=value
            self.next=None
    
    def getBucket(self,key):
        return key%self.buckets

    def find(self,key,head):
        prev=head
        curr=head.next
        while curr!=None and curr.key!=key:
            prev=curr
            curr=curr.next
        return prev

    def __init__(self):
        self.buckets=10000
        self.storage=[None]*self.buckets
        
    def put(self, key: int, value: int) -> None:
        bucket=self.getBucket(key)
        if self.storage[bucket]==None: #no linked list present at bucket index in pri arr
            #put dummy node
            self.storage[bucket]=self.Node(-1,-1)
        prev=self.find(key,self.storage[bucket]) #go thro entire linekd list to find key
        if prev.next==None:
            prev.next=self.Node(key,value)
        else:
            prev.next.value=value
   
    
    def get(self, key: int) -> int:
        bucket=self.getBucket(key)
        if self.storage[bucket]==None:
            return -1
        prev=self.find(key,self.storage[bucket])
        if prev.next==None:
            return -1
        return prev.next.value

        
    def remove(self, key: int) -> None:
        bucket=self.getBucket(key)
        if self.storage[bucket]==None:
            return
        prev=self.find(key,self.storage[bucket])
        if prev.next==None:
            return
        prev.next=prev.next.next
        
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)

