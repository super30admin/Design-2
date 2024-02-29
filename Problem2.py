# Time Complexity : O(1) for all operations
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
class MyHashMap:

    class Node:
        def __init__(self, key, val):
            self.key = key
            self.val = val
            self.next = None

    def __init__(self):
        self.storage = [None]*10000
        
    def hash(self, key):
        return key%10000
    
    def search(self, head, key):
        prev = head
        curr = head.next
        while curr:
            if curr.key == key:
                return prev
            prev = curr
            curr = curr.next
        return prev

    def put(self, key: int, value: int) -> None:
        idx = self.hash(key)
        if(self.storage[idx] is None):
            self.storage[idx] = self.Node(-1,-1)#dummy Node
        prev = self.search(self.storage[idx], key)
        if prev.next is None:
            prev.next = self.Node(key, value)
        else:
            prev.next.val = value


    def get(self, key: int) -> int:
        idx = self.hash(key)
        if self.storage[idx] is None: return -1
        prev = self.search(self.storage[idx], key)
        if(prev.next is None): return -1
        return prev.next.val
        

    def remove(self, key: int) -> None:
        idx = self.hash(key)
        if self.storage[idx] is None: return 
        prev = self.search(self.storage[idx], key)
        if(prev.next is None): return
        temp = prev.next
        prev.next = prev.next.next
        temp.next = None




# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)