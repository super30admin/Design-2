# Submitted by : Aryan Singh_RN12MAY2023
# Time Complexity : O(1)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : To validate if a list is empty or not

class Node:
    
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.next = None


class MyHashMap:

    def __init__(self):
        # Initialize the hashmap with 10000 empty nodes
        self.hashmap = []
        for i in range(10000):
            new_node = Node(-1,-1)  # Create a new node with key=-1 and value=-1
            self.hashmap.append(new_node)  # Add the new node to the hashmap
   
   
    def put(self, key: int, value: int) -> None:
        # Calculate the hash value for the key
        hash = key % 10000
        curr = self.hashmap[hash]
        # Traverse the linked list at the hash index
        while(curr.next):
            # If the key already exists, update its value and return
            if curr.key == key:
                curr.value = value
                return
            curr = curr.next
        # If the key doesn't exist, add a new node to the end of the linked list
        if curr.key == key:
                curr.value = value
        else:
            new_node = Node(key,value)
            curr.next = new_node
        
        

    def get(self, key: int) -> int:
        # Calculate the hash value for the key
        hash = key % 10000
        curr = self.hashmap[hash]
        # Traverse the linked list at the hash index
        while(curr):
            # If the key is found, return its value
            if curr.key == key:
                return curr.value
            curr = curr.next
        # If the key is not found, return -1
        return -1        


    def remove(self, key: int) -> None:
        # Calculate the hash value for the key
        hash = key % 10000
        curr = self.hashmap[hash]
        # Traverse the linked list at the hash index
        while(curr.next):
            # If the next node has the key, remove it from the linked list
            if curr.next.key == key:
                curr.next = curr.next.next
                return
            curr = curr.next

def test_my_hash_map():
    # Create a new hashmap
    hashmap = MyHashMap()

    # Test the put method
    hashmap.put(1, 1)
    hashmap.put(2, 2)
    assert hashmap.get(1) == 1
    assert hashmap.get(2) == 2
    hashmap.put(1, 10)
    assert hashmap.get(1) == 10

    # Test the remove method
    hashmap.remove(2)
    assert hashmap.get(2) == -1

    # Test edge cases
    assert hashmap.get(10001) == -1
    hashmap.put(10001, 10001)
    assert hashmap.get(10001) == 10001
    hashmap.remove(10001)
    assert hashmap.get(10001) == -1

test_my_hash_map()
# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)