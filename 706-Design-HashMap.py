class MyHashMap:

    class Node:
        def __init__(self, key, value):
            self.key = key
            self.value = value
            self.next = None

    def __init__(self):
        self.buckets = 1000
        self.bucketItems = [None] * self.buckets
    
    def _hash(self, key):
        return key % self.buckets

    def put(self, key: int, value: int) -> None:
        baseidx = self._hash(key)
        if self.bucketItems[baseidx] is None:
            self.bucketItems[baseidx] = self.Node(-1, -1)
            self.bucketItems[baseidx].next = self.Node(key, value)
            return

        prev = None
        curr = self.bucketItems[baseidx]
        while curr and curr.key != key:
            prev = curr
            curr = curr.next

        if prev.next is None:
            prev.next = self.Node(key, value)
        else:
            prev.next.value = value

    def get(self, key: int) -> int:
        baseidx = self._hash(key)
        if not self.bucketItems[baseidx]:
            return -1
        
        prev = None
        curr = self.bucketItems[baseidx]
        while curr and curr.key != key:
            prev = curr
            curr = curr.next
        
        if prev.next is None:
            return -1
        return prev.next.value
        
    def remove(self, key: int) -> None:
        baseidx = self._hash(key)
        if not self.bucketItems[baseidx]:
            return -1
        
        prev = None
        curr = self.bucketItems[baseidx]
        while curr and curr.key != key:
            prev = curr
            curr = curr.next

        if prev.next is None:
            return
        prev.next = prev.next.next


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)