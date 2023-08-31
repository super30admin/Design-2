# Time Complexity : O(linked_list_len) for put, get, and remove.
# Space Complexity : O( bucket_size * max(linked_list_len)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# - First Hash Function: `key % (10^3)`
# - Separate Chaining:  LinkedList to maintain the key value pair
class Node:
    def __init__(self, key,  val):
        self.key = key
        self.val = val
        self.next = None
class MyHashMap:
    def __init__(self):
        self.bucket = [None for _ in range(1000)]
        
    def findPrevOfKey(self, node, key):
        prev = node
        curr = node.next
        while(curr != None and curr.key != key):
            prev = curr
            curr = curr.next
        return prev

    def put(self, key: int, value: int) -> None:
        key1 = key %1000
        if self.bucket[key1] == None:
            self.bucket[key1] = Node(-1, -1)

        prev = self.findPrevOfKey(self.bucket[key1], key)
        if prev.next == None:
            newNode = Node(key, value)
            prev.next = newNode
        else:
            prev.next.val = value
        

    def get(self, key: int) -> int:
        key1 = key %1000
        if self.bucket[key1] == None:
            return -1
        prev = self.findPrevOfKey(self.bucket[key1], key)
        if prev.next == None:
            return -1
        return prev.next.val
        

    def remove(self, key: int) -> None:
        key1 = key %1000
        if self.bucket[key1] == None:
            return
        prev = self.findPrevOfKey(self.bucket[key1], key)
        if prev.next == None:
            return 
        prev.next = prev.next.next
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
