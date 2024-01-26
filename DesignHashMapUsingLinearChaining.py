'''
TC: put: O(1), get: O(1) since, remove: O(1)
SC: O(n) - n is the number of input keys

Using Double hashing, keeping primary as arrays and nested secondary buckets 
    as Linked List starting with a dummy node to facilitate easy computation.
    Increased the primary array size to 10,000 to have reduction in the linked
    list load with only fixed 100 nodes!
'''

#Linear Chaining
class Node:
    def __init__(self, k,v):
        self.data = (k,v)
        self.next = None

class MyHashMap:
    def __init__(self):
        self.primary = [None for i in range(10000)]       
    
    def hash(self, key):
        return key%10000

    def put(self, key: int, value: int) -> None:
        primaryIndex = self.hash(key)
        if not self.primary[primaryIndex]:      
            self.primary[primaryIndex] = Node(-1, -1) 
        prev = self.primary[primaryIndex]
        pointer = prev.next
        while pointer:
            if pointer.data[0] == key:
                pointer.data = (key, value)
                return
            pointer = pointer.next
            prev = prev.next
        prev.next = Node(key, value)            

    def get(self, key: int) -> int:
        primaryIndex = self.hash(key)
        if not self.primary[primaryIndex]:
            return -1
        curr = self.primary[primaryIndex].next
        while curr:
            if curr.data[0] == key:
                return curr.data[1]
            curr = curr.next
        return -1            

    def remove(self, key: int) -> None:
        primaryIndex = self.hash(key)
        if not self.primary[primaryIndex]:
            return
        prev = self.primary[primaryIndex]     
        curr = prev.next
        while curr:
            if curr.data[0] == key:
                prev.next = curr.next
                curr.next = None
                curr = prev.next
                return
            curr = curr.next
            prev = prev.next
        
# Your MyHashMap object will be instantiated and called as such:
obj = MyHashMap()
obj.put(1,1)
param_2 = obj.get(1)
print(f"The key 1 have value: {param_2}")
obj.remove(1)
param_2 = obj.get(1)
print(f"The key 1 have value: {param_2}")
obj.put(1,1)
param_2 = obj.get(1)
print(f"The key 1 have value: {param_2}")
obj.put(1,2)
param_2 = obj.get(1)
print(f"The key 1 have value: {param_2}")