# HashMap design using linear chaining with Linked list for collision handling
# TC: O(1) avg case for all the methods
# SC: O(N) N is elements in the hashmap
class Node:
    def __init__(self, key=None, value=None):
        self.key = key
        self.value = value
        self.next = None


class MyHashMap:

    def __init__(self, size=10000):
        # initialize data structure/hash table
        self.size = size
        self.storage = [None] * self.size

    def getHash(self, key):  # index for the key in hash table
        return key % self.size

    def put(self, key: int, value: int) -> None:
        index = self.getHash(key)
        if not self.storage[index]:
            # create dummy node for simple Linked list management when bucket is empty
            self.storage[index] = Node(-1, -1)

        # find prev node for the key and update the value if key exist
        # if doesnt then create new node
        prev = self.findNode(index, key)
        if prev.next:
            prev.next.value = value
        else:
            prev.next = Node(key, value)

    def get(self, key: int) -> int:
        index = self.getHash(key)
        if not self.storage[index]:
            return -1

        # find the prev node for the key and return the value if key exist
        prev = self.findNode(index, key)
        if prev.next:
            return prev.next.value
        return -1

    def remove(self, key: int) -> None:
        index = self.getHash(key)
        if not self.storage[index]:
            return -1

        # find prev node for the key and remove it by skiiping the node
        prev = self.findNode(index, key)
        if prev.next:
            # deleted_value = prev.next.value
            prev.next = prev.next.next
            # return deleted_value
        return -1

    def findNode(self, index, key):
        current = self.storage[index]
        while current.next and current.next.key != key:
            current = current.next
        return current


# Your MyHashMap object will be instantiated and called as such:
obj = MyHashMap()
obj.put(1, 10)
obj.put(2, 20)

param_2 = obj.get(1)
print(param_2)
param_3 = obj.get(2)
print(param_3)
obj.remove(1)
