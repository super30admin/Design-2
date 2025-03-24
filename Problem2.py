# Problem 2 : Design HashMap
# Time Complexity :
'''
put - O(n) where n is the number of keys in hash map
get - O(n) where n is the number of keys in hash map
removal - O(n) where n is the number of keys in hash map
'''
# Space Complexity :
'''
put - O(n) where n is the number of keys in hash map
get - O(n) where n is the number of keys in hash map
removal - O(n) where n is the number of keys in hash map
'''
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''

# Your code here along with comments explaining your approach

class MyHashMap:

    # initialize the node class for the linked list
    class Node:
        def __init__(self, key, val):
            self.key = key
            self.val = val
            self.next = None

    # initialize the primary list for hash mao with size 10000
    def __init__(self):
        self.list = [None] * 10000

    # define hash function as module of size of list
    def hashIdx(self, key: int) -> int:
        return key % 10000

    # function to find the prev pointer for the given node with key
    def findPrevNode(self, head: Node, key: int) -> Node:
        # initialize the prev to None and current to head
        prev = None
        current = head
        # loop till the current is None or the current points to key
        while current != None and current.key != key:
            # set prev to current
            prev = current
            # set current to next node
            current = current.next
        # return prev
        return prev

    def put(self, key: int, value: int) -> None:
        # find hash value for given index
        index = self.hashIdx(key)
        # check if there is linked list at the hash index
        if self.list[index] == None:
            # if it is not then create a dummy node
            self.list[index] = self.Node(-1,-1)
        # find the prev pointer for the given key for existing key
        prev = self.findPrevNode(self.list[index], key)
        # check if the next pointer for prev is None ie. the key is not present
        if prev.next == None:
            # create a node with key and value and set the next pointer of prev(last node) to a new node
            prev.next = self.Node(key, value)
        else:
            # else update the value of next node of prev pointer
            prev.next.val = value
            

    def get(self, key: int) -> int:
        # find hash value for given index
        index = self.hashIdx(key)
        # check if there is linked list at the hash index
        if self.list[index] == None:
            # if it is not present return -1
            return -1
        # find the prev pointer for the given key for existing key
        prev = self.findPrevNode(self.list[index], key)
        # check if next pointer to prev is None then it means the key is not present in the list so return -1
        if prev.next == None:
            return -1
        # else return the value of next node of prev
        else:
            return prev.next.val

    def remove(self, key: int) -> None:
        # find hash value for given index
        index = self.hashIdx(key)
        # check if there is linked list at the hash index and if it is None then simply return None
        if self.list[index] == None: return
        # find the prev pointer for the given key for existing key
        prev = self.findPrevNode(self.list[index], key)
        # check if the next node of prev is None and if it is then return
        if prev.next == None: return
        # set the next pointer of prev to next to next node of prev
        prev.next = prev.next.next
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)