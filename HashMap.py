class Node:
    def __init__(self, key=None, val=None):
        self.key = key
        self.val = val
        self.next = None


class MyHashMap:
    def __init__(self):
        self.storage = [None for i in range(10000)]

    def hash(self, key) -> int:
        return key % 10000

    def search(self, prev: Node, key: int):
        curr = Node()
        curr = prev.next
        while curr is not None:
            if curr.key == key:
                return prev
            prev = curr
            curr = curr.next
        return prev

    def put(self, key: int, value: int) -> None:
        Pindex = self.hash(key)
        if self.storage[Pindex] == None:
            self.storage[Pindex] = Node(-1, -1)
        prev = self.search(self.storage[Pindex], key)
        if prev.next == None:
            prev.next = Node(key, value)
        else:
            prev.next.val = value

    def get(self, key: int) -> int:
        try:
            idx = hash(key)
            if self.storage[idx] == None:
                return -1
            prev = self.search(self.storage[idx], key)
            if prev.next == None:
                return -1
            return prev.next.val
        except:
            return -1

    def remove(self, key: int) -> None:
        try:
            idx = hash(key)
            if self.storage[idx] == None:
                return
            prev = self.search(self.storage[idx], key)
            if prev.next == None:
                return
            temp = prev.next
            prev.next = prev.next.next
            temp.none = None
            return
        except:
            print("Error Caught")
            return


obj = MyHashMap()
obj.put(1, 2)
param_2 = obj.get(1)
obj.remove(2)
