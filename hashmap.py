class MyHashMap:
    class Node:
        def __init__(self, key, val):
            self.key = key
            self.val = val
            self.next = None

    def __init__(self):
        self.buckets = 10000
        self.storage = [None] * self.buckets

    def hashIdx(self, key):
        return key % self.buckets

    def find(self, head, key):
        prev = None
        curr = head
        while curr is not None and curr.key != key:
            prev = curr
            curr = curr.next
        return prev

    def put(self, key, value):
        bucket = self.hashIdx(key)
        if self.storage[bucket] is None:
            self.storage[bucket] = self.Node(-1, -1)

        prev = self.find(self.storage[bucket], key)
        if prev.next is None:
            prev.next = self.Node(key, value)
        else:
            prev.next.val = value

    def get(self, key):
        bucket = self.hashIdx(key)
        if self.storage[bucket] is None:
            return -1
        prev = self.find(self.storage[bucket], key)
        if prev.next is None:
            return -1
        return prev.next.val

    def remove(self, key):
        bucket = self.hashIdx(key)
        if self.storage[bucket] is None:
            return
        prev = self.find(self.storage[bucket], key)
        if prev.next is None:
            return
        prev.next = prev.next.next


# Example usage
hashMap = MyHashMap()

hashMap.put(1, 1)
hashMap.put(2, 2)
print(hashMap.get(1))   
print(hashMap.get(3))   
hashMap.put(2, 3)
print(hashMap.get(2))  
hashMap.remove(2)
print(hashMap.get(2))   

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)