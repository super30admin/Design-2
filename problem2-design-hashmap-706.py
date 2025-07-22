#hash map with chaining method
class MyHashMap:
    class Node:
        def __init__(self, Key=None, value=None, next=None):
            self.Key = Key
            self.value = value
            self.next = next

    def __init__(self):
        self.bucket_size = 10000
        self.array = [None] * self.bucket_size
        self.prev = None
        self.current = None

    def hash_fun(self, key):
        return key % self.bucket_size

    def find(self, head, key):
        prev = None
        curr = head
        while curr != None and curr.Key != key:
            prev = curr
            curr = curr.next
        return prev

    def put(self, key: int, value: int) -> None:

        if self.array[self.hash_fun(key)] == None:
            self.array[self.hash_fun(key)] = self.Node(-1, -1)
        prev = self.find(self.array[self.hash_fun(key)], key)
        if prev.next == None:  # we are not able to find
            prev.next = self.Node(key, value, None)
        else:
            prev.next.value = value

    def get(self, key: int) -> int:
        if self.array[self.hash_fun(key)] == None:
            return -1
        else:
            prev = self.find(self.array[self.hash_fun(key)], key)
            if prev.next == None:
                return -1
            else:
                return prev.next.value

    def remove(self, key: int) -> None:
        if self.array[self.hash_fun(key)] == None:
            return
        else:
            prev = self.find(self.array[self.hash_fun(key)], key)
            if prev.next == None:
                return
            else:
                prev.next = prev.next.next
                return

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)