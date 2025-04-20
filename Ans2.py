#  Time Complexity : O(1) average , O(n) worst case
#  Space Complexity : O(n) for hashlist 
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : No

#  Your code here along with comments explaining your approach in three sentences only: The put() method inserts or updates key-value pairs, get() retrieves values, and remove() deletes entries, each using a hash function (find_index) to locate the bucket and traversing the linked list (find_node) for key operations. A dummy node (Node(-1,-1)) is used at each bucket's head to simplify edge cases during insertion/deletion.

class MyHashMap:
    class Node(object):
        def __init__(self, key, val):
            self.key = key
            self.val = val
            self.next = None

    def __init__(self):
        self.Hashlist = [None] * 10000
        
    def put(self, key: int, value: int) -> None:
        i = self.find_index(key)

        if self.Hashlist[i] == None:
            self.Hashlist[i] = self.Node(-1, -1)
        
        prevNode = self.find_node(self.Hashlist[i], key)
        if prevNode.next == None:
            prevNode.next = self.Node(key, value)
        else:
            prevNode.next.val = value         

    def get(self, key: int) -> int:
        i = self.find_index(key)

        if self.Hashlist[i] == None:
            return -1
        
        prevNode = self.find_node(self.Hashlist[i], key)
        return -1 if prevNode.next == None else prevNode.next.val
        

    def remove(self, key: int) -> None:
        i = self.find_index(key)

        if self.Hashlist[i] == None:
            return
        
        prevNode = self.find_node(self.Hashlist[i], key)

        if prevNode.next == None:
            return None
        
        prevNode.next = prevNode.next.next

    
    def find_index(self, key):
        return hash(key) % len(self.Hashlist)
    
    def find_node(self, head, key):
        curr = head
        prev = None

        while curr != None and curr.key != key:
            prev = curr
            curr = curr.next
        
        return prev