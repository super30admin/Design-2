# Time Complexity : O(n) in the worst case if all the key hash to the same index, or else it will be O(1)
# Space Complexity : O(m + n) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : I tried open addressing at first but the code when ran on leetcode timed out. 


# Your code here along with comments explaining your approach

# I am designing the hashmap using the array and linked list. I will be using the index of the array as the hash key and each index will be having a linked list to store the key value pairs.
# To deal with the collisions, I will be using the chaining approach, where if a collision occurs, I will simply append the new key value pair to the linked list at that index.
# I will create a node class to represent the nodes of the linked list and will also create a hash function inside my hashmap class to calculate the hash key for each key using modulo operation.

class Node:
    # Setting key and value to -1 as the first node of the LL will be a dummy node
    def __init__(self, key = -1, value = -1, next = None):
        self.key = key # key of the node
        self.value = value # value of the node
        self.next = next # pointer to the next node


class Hashmap:
    def __init__(self):
        self.map = [Node() for i in range(10000)] # Creating an array of size 10000 as at most 10^4 calls will be made to the hashmap


    def hash_func(self, key):
        return key % len(self.map) # Getting the hash key for each key using modulo operation
    

    def put(self, key, value):
        current = self.map[self.hash_func(key)] # Getting the index using hash function and storing it in current

        # Traversing the LL at that index from current.next as the first node is a dummy node, we use the dummy node to avoid edge cases like if the LL is empty or the first node is the node we want to delete)

        while current.next:

            # First Case - New Insertion at the index
            if current.next.key == key:
                current.next.value = value

                return
            
            current = current.next # On to the next node

        # Second Case - Collision Handling, create a new node and append it to the LL at that index

        current.next = Node(key, value)


    def remove(self, key):
        current = self.map[self.hash_func(key)] 

        # If both current and current.next are not None because first node is a dummy node.
        while current.next and current:
            if current.next.key == key:
                # if the key is matched, we point the current.next to the next node of the node we want to delete
                current.next = current.next.next

                return 
            
            current = current.next # On to the next node


    def get(self, key):
        current = self.map[self.hash_func(key)].next # Setting it to next as the first node is a dummy node

        while current:
            if current.key == key: # If the key is matched, we return the value
                return current.value
            
            current = current.next # On to the next node

        return -1


