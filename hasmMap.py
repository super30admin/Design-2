# Implementation of HashMap using Separate Chaining technique for collision resolution.

# Approach:
# - Uses an array of linked lists (separate chaining) to handle hash collisions.
# - Each linked list is represented with Nodes containing key-value pairs.
# - Basic operations: put (insert/update), get (retrieve), remove (delete).

# Time Complexity:
# - Average case: O(1) for put, get and remove operations.
# - Worst case: O(n) when all keys hash to the same index, creating a long chain.

# Space Complexity:
# - O(n + m) where n is the number of key-value pairs stored and m is the size of the underlying array (1000 in this case).

# Did this code successfully run on Leetcode : YES

class Node(object):
    def __init__(self, key, value):
        self.key = key   # Store the key of the key-value pair
        self.value = value  # Store the value of the key-value pair
        self.next = None  # Pointer to the next node in the chain, initially None

class MyHashMap(object):

    def __init__(self):
        # Create an array of 1000 dummy nodes as heads of linked lists
        # The dummy nodes (-1, -1) simplify insertion and removal operations
        self.map = [Node(-1, -1) for i in range(1000)]

    def hash(self, key):
        hashed_key = key % len(self.map) # Simple hash function: key modulo array size
        return hashed_key
        
    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: None
        """
        idx = self.hash(key) # Get the index for this key
     
        put_node = self.map[idx]  # Start at the dummy head node of the linked list
        # Traverse the linked list to find if the key already exists
        while put_node.next:
            if put_node.next.key == key:
                put_node.next.value = value  # Update value if key exists
                return 

            put_node = put_node.next

        # If key doesn't exist, add new node at the end of the list
        put_node.next = Node(key, value)
        
        return 


    def get(self, key):
        """
        :type key: int
        :rtype: int
        """

        idx = self.hash(key) # Get the index for this key
         
        get_node = self.map[idx].next  # Start from the first actual node(skip dummy)
        
        # Traverse the linked list the index idx(hashed key) to find the key
        while get_node:

            if get_node.key == key:
                return get_node.value # return value if key is found
                
            get_node = get_node.next

        return -1  # return -1 if key is not found
        
    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        idx = self.hash(key)  # hashing the key

        remove_node = self.map[idx]  # first actual node in the chain

        # Traverse the linked list to find the key
        while remove_node:

            if remove_node.key == key:
                prev_node.next = remove_node.next  # remove node by updating the pointer
                return
            
            prev_node = remove_node
            remove_node = remove_node.next

        return  # Do nothing if key is not found

