# TC - put - O(n), get- O(n) ,remove - O(n)

# SC = O(1)


# handle collison using chaining
class Node:
    def __init__(self, key, value, next):
        self.key = key
        self.value = value
        self.next = next


class MyHashMap:

    def __init__(self):
        self.hashmap = [None] * 10000
        self.length = len(self.hashmap)

    def search(self, head, key):
        prev = None
        curr = head
        while curr and (curr.key != key):
            prev = curr
            curr = curr.next
        return prev

    def getHash(self, key):
        return key % self.length

    def put(self, key: int, value: int) -> None:
        keyHash = self.getHash(key)
        if self.hashmap[keyHash] == None:
            self.hashmap[keyHash] = Node(-1, -1, None)

        prev = self.search(self.hashmap[keyHash], key)
        if prev.next == None:
            prev.next = Node(key, value, None)
        else:
            prev.next.value = value

    def get(self, key: int) -> int:
        keyHash = self.getHash(key)
        if self.hashmap[keyHash] == None:
            return -1
        prev = self.search(self.hashmap[keyHash], key)
        if prev.next == None:
            print(key, "no key")
            return -1
        else:
            print(key, prev.next.value)
            return prev.next.value

    def remove(self, key: int) -> None:
        keyHash = self.getHash(key)
        if self.hashmap[keyHash] == None:
            return
        prev = self.search(self.hashmap[keyHash], key)
        if prev.next == None:
            return
        temp = prev.next
        prev.next = prev.next.next
        temp.next = None


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
