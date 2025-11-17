'''
Here I implemented my Hashmap using linear chaining for handling collisions, using a hash function.
put():
- with the index returned from hash function we go to the index and check if the index already has a chain initialized.
- if not we add a dummy node before creating the head node(because when the head had to be removed from the storage array, 
    it will break the connection to rest of the elements)
- if it already has values then we connect the new values to existing node.
get():
we directly fetch the value from the key
remove():
from the find we get the prevois node and delete the prev.next and connect prev.next to prev.next.next
'''

class MyHashMap:

    class Node:
        def __init__(self, key, val):
            self.key = key
            self.val = val
            self.next = None

    def __init__(self):
        self.size = 10000
        self.storage = [None] * self.size

    # hash function for equal distribution
    def hashFunc(self, key: int)-> int:
        return key % self.size
        
    # function to find the prev node
    def find(self, head, key):
        prev = None
        curr = head
        while curr is not None and curr.key != key:
            prev = curr
            curr = curr.next
        return prev

    def put(self, key: int, value: int) -> None:
        idx = self.hashFunc(key)

        # to check if the index has any chain, if not create a dummy pair
        if self.storage[idx] is None:
            self.storage[idx] = self.Node(-1,-1)

        # to find the previous node of the target key
        prev = self.find(self.storage[idx], key)
        
        # if the index has values append with new values
        if prev.next:
            prev.next.val = value
        else:
            prev.next = self.Node(key, value)

    def get(self, key: int) -> int:
        idx = self.hashFunc(key)
        
        # if no linked list exists at the index
        if self.storage[idx] is None:
            return -1
        # to find the previous node of the target key
        prev = self.find(self.storage[idx], key)

        # if exists return the value 
        if prev.next:
            return prev.next.val
        
        # if the key is not found return -1
        return -1   

    def remove(self, key: int) -> None:
        idx = self.hashFunc(key)
        
        # to check if it has no elements in that if not return
        if self.storage[idx] is None:
            return

        # to find the previous node of the target key
        prev = self.find(self.storage[idx], key)

        if prev.next is None:
            return
       
        # to link previous node to next node of removed node
        prev.next = prev.next.next 

'''
Time Complexity: O(1)
Space Complexity: O(1)
'''
