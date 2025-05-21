'''
Maintain an array and hash incoming keys to array indices. 
Create dummy node at each index to ensure we don't have edge cases which try and remove when nothing is present
'''

class ListNode:
    def __init__(self, key=-1, value=-1, next=None):
        self.key = key
        self.value = value
        self.next = next
    
class MyHashMap:

    def __init__(self):
        self.map = [ListNode() for i in range(1000)]

    def hasher(self, key):
        return key % len(self.map)    
        
    def put(self, key: int, value: int) -> None:
        cur = self.map[self.hasher(key)]
        while cur.next:
            if cur.next.key == key:
                cur.next.value = value
                return
            cur = cur.next
        cur.next = ListNode(key, value)
        

    def get(self, key: int) -> int:
        cur = self.map[self.hasher(key)].next
        while cur:
            if cur.key == key:
                return cur.value
            cur = cur.next
        return -1
        

    def remove(self, key: int) -> None:
        cur = self.map[self.hasher(key)]
        while cur and cur.next:
            if cur.next.key == key:
                cur.next = cur.next.next
                return
            cur = cur.next
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)