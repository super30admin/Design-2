# // Time Complexity : O(1)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no


# // Your code here along with comments explaining your approach
# We use linked list to store the key value pair for the map. The map contains 1000 slots for storing keys.

class Node:
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.next = None

class MyHashMap:

    def __init__(self):
        self.slots = 1000
        self.hash_map = [None]*self.slots

    def put(self, key: int, value: int) -> None:
        hash_index = key%self.slots

        if self.hash_map[hash_index] is None:
            self.hash_map[hash_index] = Node(key, value)
        else:
            node1 = self.hash_map[hash_index]

            while True:
                if node1.key == key:
                    node1.value = value
                    return
                if node1.next == None:
                    break
                node1 = node1.next

            node1.next = Node(key, value)

    def get(self, key: int) -> int:
        hash_index = key%self.slots
        node1 = self.hash_map[hash_index]
        while node1:
            if node1.key == key:
                return node1.value
            else:
                node1 = node1.next
        return -1

    def remove(self, key: int) -> None:
        hash_index = key%self.slots
        node1 = prev = self.hash_map[hash_index]

        if not node1: return
        
        if node1.key == key:
            self.hash_map[hash_index] = node1.next
        else:
            node1 = node1.next
            while node1:
                if node1.key == key:
                    prev.next = node1.next
                    break
                else:
                    prev, node1 = prev.next, node1.next


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)