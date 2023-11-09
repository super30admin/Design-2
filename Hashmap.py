class MyHashMap:
    def __init__(self):
        self.buckets=10000
        self.storage=[None]*self.buckets
    
    class Node:
        def __init__(self,key,value):
            self.key=key
            self.value=value
            self.next=None

    def hashkey(self,key):
        return key % self.buckets

    def find_prev(self,head,key):
        prev=None
        curr=head
        while curr !=None and curr.key!=key:
            prev=curr
            curr=curr.next
        return prev

    def put(self, key: int, value: int) -> None:
        hash_val=self.hashkey(key)
        if self.storage[hash_val] is None:
            self.storage[hash_val]=self.Node(-1,-1)
            self.storage[hash_val].next=self.Node(key,value)
        else:
            prev=self.find_prev(self.storage[hash_val],key)
            if prev.next is None:
                prev.next=self.Node(key, value)
            else:
                prev.next.value=value

    def get(self, key: int) -> int:
        hash_val=self.hashkey(key)
        if self.storage[hash_val] is None:
            return -1
        else:
            prev=self.find_prev(self.storage[hash_val],key)
            if prev.next is None:
                return -1
            else:
                return prev.next.value

    def remove(self, key: int) -> None:
        hash_val=self.hashkey(key)
        if self.storage[hash_val] is None:
            return
        else:
            prev=self.find_prev(self.storage[hash_val],key)
            if prev.next is None:
                return
            else:
                prev.next=prev.next.next
        
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)