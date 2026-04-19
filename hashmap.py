
"""
@author: chinmayprajapati

Time: O(1) 
Space: O(n + k) 

"""

class ListNode:
    def __init__(self, key=-1, val=-1, next=None):
        self.key = key
        self.val = val
        self.next = next

class MyHashMap:

    def __init__(self):
        self.map = [ListNode() for i in range(1000)]
    
    def hash(self, key):
        return key % len(self.map)
        
    def put(self, key: int, value: int) -> None:
        current = self.map[self.hash(key)]
        while current.next:
            if current.next.key == key:
                current.next.val = value
                return 
            current = current.next
        current.next = ListNode(key, value)

    def get(self, key: int) -> int:
        current = self.map[self.hash(key)].next
        while current:
            if current.key == key:
                return current.val
            current = current.next
        return -1

    def remove(self, key: int) -> None:
        current = self.map[self.hash(key)]
        while current and current.next:
            if current.next.key == key:
                current.next = current.next.next
                return
            current = current.next
        
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)