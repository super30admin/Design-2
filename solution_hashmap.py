class Node:
    def __init__(self, key, val):
        self.key = key
        self.val = val
        self.next = None
        
class LinkedList:
    def __init__(self):
        self.head = Node(None, None)
        
    def search(self, key):
        prev = self.head
        while prev.next:
            if prev.next.key == key:
                return prev
            prev = prev.next
        return prev
    
    def add(self, key, val):
        prev = self.search(key)
        if prev.next is None:
            prev.next = Node(key,val)
        else:
            prev.next.val = val
            
    def get(self, key):
        prev = self.search(key)
        if prev.next is None:
            return None
        else:
            return prev.next.val
        
    def remove(self, key):
        prev = self.search(key)
        if prev.next is not None:
            prev.next = prev.next.next


class MyHashMap:

    def __init__(self):
        self.size = 2069
        self.arr = [LinkedList() for _ in range(self.size)]
        

    def put(self, key: int, value: int) -> None:
        h = key % self.size
        self.arr[h].add(key, value)
        

    def get(self, key: int) -> int:
        h = key % self.size
        ret = self.arr[h].get(key)
        return ret if ret is not None else -1
        

    def remove(self, key: int) -> None:
        h = key % self.size
        self.arr[h].remove(key)
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
