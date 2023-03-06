class Node:
    def __init__(self, key=None, value=None):
        self.key = key
        self.value = value
        self.next = None

class MyHashMap:

    def __init__(self, key=None, value=None):
        self.size = 10000
        self.table = [None] * self.size
    def _hash(self, key):
        return key % self.size
        

    def put(self, key:int, value:int)->None:
        hash_value = self._hash(key)
        if self.table[hash_value] == None:
            self.table[hash_value] = Node(key, value)
        else:
            curr = self.table[hash_value]
            while True:
                if curr.key == key:
                    curr.value = value
                    return
                if curr.next == None:
                    break
                curr = curr.next
            curr.next = Node(key, value)
        

    def get(self, key: int) -> int:
        hash_value = self._hash(key)
        curr = self.table[hash_value]
        while curr:
            if curr.key == key:
                return curr.value
            curr = curr.next
        return -1
        

    def remove(self, key: int):
        hash_value = self._hash(key)
        curr = self.table[hash_value]
        if curr:
            if curr.key == key:
                self.table[hash_value] = curr.next
                return
            prev = curr
            curr = curr.next
            while curr:
                if curr.key == key:
                    prev.next = curr.next
                    return
                prev = curr
                curr = curr.next


myHashMap = MyHashMap()
myHashMap.put(1, 1); # The map is now [[1,1]]
myHashMap.put(2, 2); # The map is now [[1,1], [2,2]]
myHashMap.get(1);    # return 1, The map is now [[1,1], [2,2]]
myHashMap.get(3);    # return -1 (i.e., not found), The map is now [[1,1], [2,2]]
myHashMap.put(2, 1); # The map is now [[1,1], [2,1]] (i.e., update the existing value)
myHashMap.get(2);    # return 1, The map is now [[1,1], [2,1]]
myHashMap.remove(2); # remove the mapping for 2, The map is now [[1,1]]
myHashMap.get(2);    # return -1 (i.e., not found), The map is now [[1,1]]