class ListNode: 
    def __init__(self, key=-1, val=-1): 
        self.key = key
        self.val = val
        self.next = None

class MyHashMap:
    def __init__(self):
        self.size = 1000
        self.array = [ListNode() for _ in range(self.size)]

    def hash(self, key): 
        return key % self.size

    def put(self, key: int, value: int) -> None:
        place = self.hash(key)
        curr = self.array[place]

        while curr.next:
            if curr.next.key == key: 
                curr.next.val = value
                return 
            curr = curr.next
        
        curr.next = ListNode(key,value)
        

    def get(self, key: int) -> int:
        place = self.hash(key)
        curr = self.array[place]

        while curr.next:
            if curr.next.key == key:
                return curr.next.val
            curr = curr.next
        return -1

        

    def remove(self, key: int) -> None:

        place = self.hash(key)
        curr = self.array[place]
        while curr.next:
            if curr.next.key == key:             
                curr.next = curr.next.next       
                return
            curr, curr.next = curr.next, curr.next.next


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
