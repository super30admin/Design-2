# Time Complexity : O(1) for put, get and remove
# Space Complexity : O(n) where n is the number of elements in the hashmap
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach:
# 1. I am implementing a hashmap using linear chaining. For each key, I calculate the index by taking modulo of the key with the size of the hashmap.
# 2. If the index is empty, I create a dummy node and add the key-value pair as the next node.
# 3. If the index is not empty, I traverse the linked list and update the value if the key is already present in the linked list.
# 4. For get operation, I traverse the linked list and return the value if the key is found.
# 5. For remove operation, I traverse the linked list and remove the node if the key is found.

class Node:
    # Node class to store key, value and next pointer
    def __init__(self, key: int, val: int, next: None):
        self.key = key
        self.val = val
        self.next = next

class MyHashMap:
    def __init__(self):
        # Initialize array of 10000 null pointers
        self.size = 10000
        # Initialize hashmap with 10000 null pointers
        self.hashMap = [None] * self.size

    # Helper function to get the previous node of the key
    def getPrev(self, key, node: Node):
        # Initialize prev and cur pointers
        prev = None
        # Traverse the linked list until the key is found
        cur = node
        while cur and cur.key != key:
            prev = cur
            cur = cur.next
        # Return the previous node
        return prev

    # Put the key-value pair in the hashmap
    def put(self, key: int, value: int) -> None:
        # Calculate the index
        index = key % self.size
        # If the index is empty, create a dummy node and add the key-value pair
        if self.hashMap[index] is None:
            self.hashMap[index] = Node(-1, -1, None)
            self.hashMap[index].next = Node(key, value, None)
            return
        # If the index is not empty, traverse the linked list and update the value if the key is
        # already present in the linked list
        prev = self.getPrev(key, self.hashMap[index])
        # If the key is not found, add the key-value pair at the end of the linked list
        if prev.next is None:
            prev.next = Node(key, value, None)
        # If the key is found, update the value
        else:
            prev.next.val = value

    # Get the value of the key
    def get(self, key: int) -> int:
        # Calculate the index
        index = key % self.size
        # If the index is empty, return -1 because the key does not exist
        if self.hashMap[index] is None: return -1
        # Traverse the linked list and return the value if the key is found
        cur = self.hashMap[index]
        # Iterate through the linked list until the key is found
        while cur and cur.key != key:
            cur = cur.next
        # Return the value if the key is found else return -1
        return cur.val if cur else -1

    # Remove the key from the hashmap
    def remove(self, key: int) -> None:
        # Calculate the index
        index = key % self.size
        # If the index is empty, return
        if self.hashMap[index] is None: return
        # Get the previous node of the key
        prev = self.getPrev(key, self.hashMap[index])
        cur = prev.next
        # If the key is not found, return
        if cur is None: return
        # If the key is found, remove the node
        else:
            prev.next = cur.next
            cur.next = None

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)