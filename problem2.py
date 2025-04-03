#Design Hashmap#

# Definition for a linked list node.
class Node(object):
    def __init__(self, key, val):
        self.key = key    # The key of the entry
        self.val = val    # The value associated with the key
        self.next = None  # Pointer to the next node in the chain

class MyHashMap(object):
    def __init__(self):
        # Initialize the hash table with a fixed size.
        # Each bucket will store a linked list.
        self.size = 10000
        self.Hashlist = [None] * self.size

    def put(self, key, value):
        """
        Insert a (key, value) pair into the HashMap. 
        If the key already exists, update its value.
        """
        i = self.find_index(key)
        # If the bucket is empty, initialize it with a dummy node.
        if self.Hashlist[i] is None:
            self.Hashlist[i] = Node(-1, -1)
        # Find the previous node for the given key.
        prev_node = self.find_node(self.Hashlist[i], key)
        # If key does not exist, add a new node.
        if prev_node.next is None:
            prev_node.next = Node(key, value)
        else:
            # Key exists; update the value.
            prev_node.next.val = value

    def get(self, key):
        """
        Retrieve the value associated with the given key.
        Returns -1 if the key does not exist.
        """
        i = self.find_index(key)
        if self.Hashlist[i] is None:
            return -1
        prev_node = self.find_node(self.Hashlist[i], key)
        return -1 if prev_node.next is None else prev_node.next.val

    def remove(self, key):
        """
        Remove the (key, value) pair from the HashMap if it exists.
        """
        i = self.find_index(key)
        if self.Hashlist[i] is None:
            return
        prev_node = self.find_node(self.Hashlist[i], key)
        if prev_node.next is None:
            return
        # Remove the node by skipping it in the chain.
        prev_node.next = prev_node.next.next

    def find_index(self, key):
        # Compute the bucket index using the built-in hash function.
        return hash(key) % self.size

    def find_node(self, head, key):
        """
        Find the previous node of the node containing the key.
        If key is not present, returns the last node in the chain.
        """
        cur = head
        prev = None
        # Traverse the linked list until the key is found.
        while cur is not None and cur.key != key:
            prev = cur
            cur = cur.next
        return prev

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
