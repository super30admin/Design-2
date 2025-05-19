# Time Complexity:
# put O(1)
# get O(1)
# remove O(1)
#find_index O(1)
# find_node O(N)

# Space Complexity : o(N)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No


# Your code here along with comments explaining your approach
# Implemented a HashMap with a fixed-size array of 10,000 where each bucket has linked list for collision handling
#First I will calculate the index using hash function and traverse the linked list to find the index and  will get or put or remove

class MyHashMap:
    #Node to maintain separate chaining in each bucket
    class Node:
        def __init__(self, key, val):
            self.key = key
            self.val = val
            self.next = None

    def __init__(self):
        self.Hashlist = [None] * 10000 #fixed-size array
        

    def put(self, key: int, value: int):
        # Inserts a key value pair into HashMap. And if the key already exists updates the value.
        i = self.find_index(key)
        if self.Hashlist[i] is None:
            self.Hashlist[i] = self.Node(-1, -1) #Dummy head node
        prev_node = self.find_node(self.Hashlist[i], key)
        if prev_node.next is None:
            prev_node.next = self.Node(key, value)
        else:
            prev_node.next.val = value 
        

    def get(self, key):
        # Returns the value for the given key, or -1 if not found.
        i = self.find_index(key)
        if self.Hashlist[i] is None:
            return -1
        prev_node = self.find_node(self.Hashlist[i], key)
        return -1 if prev_node.next is None else prev_node.next.val
        

    def remove(self, key: int):
        i = self.find_index(key)
        if self.Hashlist[i] is None:
            return
        prev_node = self.find_node(self.Hashlist[i], key)
        if prev_node.next is None:
            return
        prev_node.next = prev_node.next.next

    def find_index(self, key):
        return hash(key) % len(self.Hashlist)

    def find_node(self, head, key):
        # Returns the previous node of the node with the given key.
        cur = head
        prev = None
        while cur is not None and cur.key != key:
            prev = cur
            cur = cur.next

        return prev

        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)