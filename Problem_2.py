# Time Complexity : O(n/k) where k is size of hasharray
# Space Complexity : O(k) where k is size of hasharray
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach:

# Define a Linked List node
class Node:
    def __init__(self, data = 0):
        self.data = data
        self.next = None

# Define a Linked List class
class LinkedList:

    # Linked List constructor
    def __init__(self):
        self.head = None
    
    # Add new unique data to the Linked List
    def append(self, data):
        # If the data is already present in the Linked List, don't add it
        if self.isPresent(data):
            return
        newnode = Node(data)
        # If there is no head node, then the new node is the head node
        if not self.head:
            self.head = newnode
        # Else append the new node to the end of the Linked List
        else:
            curr = self.head
            while curr.next:
                curr = curr.next
            curr.next = newnode

    # Delete data from the Linked List        
    def delete(self, key):
        # If there is no head node, there is nothing to delete
        if not self.head:
            return
        # If head node contains the key to be deleted, delete it
        if self.head.data == key:
            temp = self.head
            self.head = self.head.next
            temp = None
        # Else find the node that contains the key and delete that node
        else:
            prev = self.head
            curr = prev.next
            while curr:
                if curr.data == key:
                    prev.next = curr.next
                    curr = None
                    break
                prev = curr
                curr = curr.next
    
    # Check if the key is present in the Linked List
    # Iterate through the Linked List, if any node contains the key, then return True, else return False
    def isPresent(self, key):
        curr = self.head
        while curr:
            if curr.data == key:
                return True
            curr = curr.next
        return False

# Define the MyHashSet class        
class MyHashSet:

    # MyHashSet constructor
    def __init__(self):
        # I randomly chose the size of the hash array to be 907
        self.hasharraysize = 907
        # Create a LinkedList object at each index of the hash array
        self.hasharray = [LinkedList() for i in range(self.hasharraysize)]  

    # Hash Function   
    def _hashfunction(self, key):
        return key % self.hasharraysize    

    # Add a new key to MyHashSet
    def add(self, key: int) -> None:
        # Use the Hash function to calculate the corresponding index of the hash array
        hasharrayindex = self._hashfunction(key)
        # Add the key to the Linked List at the calculated index of the hash array
        self.hasharray[hasharrayindex].append(key)

    def remove(self, key: int) -> None:
        # Use the Hash function to calculate the corresponding index of the hash array
        hasharrayindex = self._hashfunction(key)
        # Delete the key from the Linked List at the calculated index of the hash array
        self.hasharray[hasharrayindex].delete(key)

    def contains(self, key: int) -> bool:
        # Use the Hash function to calculate the corresponding index of the hash array
        hasharrayindex = self._hashfunction(key)
        # Check if the key is present in the Linked List at the calculated index of the hash array
        return self.hasharray[hasharrayindex].isPresent(key)


hashSet = MyHashSet()
hashSet.add(1)
hashSet.add(2)
print(hashSet.contains(1))
print(hashSet.contains(3))
hashSet.add(2)
print(hashSet.contains(2))
hashSet.remove(2)
print(hashSet.contains(2))