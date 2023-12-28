class MyHashMap:
    class Node:
        def __int__(self, key: int, value: int):
            self.key = key
            self.value = value
            self.next = None

    def find(self, node: Node, key: int) -> Node:
        prev = node
        curr = node.next
        while curr != None and curr.key != key:
            prev = curr
            curr = curr.next
        return prev

    def __init__(self):
        self.buckets = 1000
        self.storage = [None] * self.buckets

    def getBucket(self, key:int) -> int:
        return key % self.buckets

    def put(self, key: int, value: int) -> None:
        bucket = self.getBucket(key)
        if self.storage[bucket] == None:
            self.storage[bucket] = self.Node(-1, -1)
        prev = self.find(self.storage[bucket],key)
        if prev.next != None:
            prev.next.value = value
        else:
            prev.next = self.Node(key,value)
        
    def get(self, key: int) -> int:
        bucket = self.getBucket(key)
        if self.storage[bucket] == None:
            return -1
        prev = self.find(self.storage[bucket],key)
        if prev.next != None:
            return prev.next.value
        return -1

    def remove(self, key: int) -> None:
        bucket = getBucket(key)
        if self.storage[bucket] == None:
            return
        prev = self.find(self.storage[bucket],key)
        if prev.next != None:
            prev.next = prev.next.next

        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)