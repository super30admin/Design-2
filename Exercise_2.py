
class Node:
    def __init__(self, key, val):
        self.key = key
        self.val = val
        self.next = None
        
class MyHashMap:

    def __init__(self):
        self.pArr = [None for _ in range(10000)]

    def _hash(self, key):
        return key % 10000
    
    def _search(self, head, key):
        prev, curr = head, head.next
        while curr:
            if curr.key == key:
                break
            prev = curr
            curr = curr.next
        return prev, curr        

    def put(self, key: int, value: int) -> None:
        h = self._hash(key)
        if not self.pArr[h]:
            self.pArr[h] = Node(-1, -1)
        prev, curr = self._search(self.pArr[h], key)
        if not curr:
            prev.next = Node(key, value)
        else:
            curr.val = value

    def get(self, key: int) -> int:
        h = self._hash(key)
        if not self.pArr[h]:
            return -1
        prev, curr = self._search(self.pArr[h], key)
        if not curr:
            return -1
        return curr.val
        
    def remove(self, key: int) -> None:
        h = self._hash(key)
        if not self.pArr[h]:
            return
        prev, curr = self._search(self.pArr[h], key)
        if not curr:
            return
        prev.next = curr.next    
