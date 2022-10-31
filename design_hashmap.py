
class ListNode:
    def __init__(self, key= None, val = None, next = None):
        self.key = key
        self.val = val
        self.next = next

class MyHashMap:

    def __init__(self):
        self.size = 1000
        self.buckets = [None]*self.size
    
    def get_bucket(self, key):
        return key % 1000
    
    def find_key(self, idx, key):
        # complexity O(n)
        head = self.buckets[idx]
        while head and head.next:
            if head.next.key == key:
                return head
            head = head.next
        return None
    
    
    def put(self, key: int, value: int) -> None:
        # complexity O(n)
        idx = self.get_bucket(key)
        node = self.find_key(idx, key)
        if node:
            node.next.val = value
            return 
        
        if self.buckets[idx] is not None:
            dummy = self.buckets[idx]
            new_node = ListNode(key, value)
            new_node.next, dummy.next = dummy.next, new_node
        else:
            dummy = ListNode(-1, -1)
            self.buckets[idx] = dummy
            dummy.next = ListNode(key, value)
        
            
        
    def get(self, key: int) -> int:
        # complexity O(n)
        idx = self.get_bucket(key)
        node = self.find_key(idx, key)
        if node is not None:
            return node.next.val
        return -1

    def remove(self, key: int) -> None:
        # complexity O(n)
        idx = self.get_bucket(key)
        node = self.find_key(idx, key)
        if node is not None:
            node.next = node.next.next
            return
        return
        

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)

