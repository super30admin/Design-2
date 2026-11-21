class MyHashMap:
    class Node:
        def __init__(self,key,val):
            self.key=key
            self.val=val
            self.next=None
    def __init__(self):
        self.buckets=1000
        self.linkedlist=[None]*self.buckets
    def hash(self,key):
        return key%self.buckets
    def prev(self,head,key):
        
        prev=None
        curr=head
        while curr and curr.key !=key:
            prev=curr
            curr=curr.next
        return prev      
        
    def put(self, key: int, value: int) -> None:
        idx=self.hash(key)
        if self.linkedlist[idx] is None:
            self.linkedlist[idx]=self.Node(-1,-1)
            self.linkedlist[idx].next=self.Node(key,value)
            return
        prev=self.prev(self.linkedlist[idx],key)
        if prev.next is None:
            prev.next=self.Node(key,value)
        else:
            prev.next.val=value


    def get(self, key: int) -> int:
        idx=self.hash(key)
        if self.linkedlist[idx] is None:
            return -1
        prev=self.prev(self.linkedlist[idx],key)
        if prev.next is None:
            return -1
        return prev.next.val

    def remove(self, key: int) -> None:
        idx=self.hash(key)
        if self.linkedlist[idx] is None:
            return -1
        prev=self.prev(self.linkedlist[idx],key)
        if prev.next is None:
            return None
        prev.next=prev.next.next

        
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)