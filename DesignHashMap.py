# // Time Complexity : o(1) amortized for put , get remove since the time doesnt grow with input linked list secondary is 100
# // Space Complexity : o(n) extra space for storage 
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this :
    # I understood the concept and tried implementing with open addressing but was missing some edge cases in remove
    # after the lecture could solve it but had to refer again why we need helper to give us the prev node todo: need to implement with double hashing


# // Your code here along with comments explaining your approach
    # 1) setup - prepare datastructure to hold node , initialize hashmpap(under the hood array) to be array of null nodes of a uniform dist size(buckets),
    # helper to locate prev and hash function.
    # 2) put - handle cases - a) no key exists (create one), b) update the keys value for get a) no key (return -1) b) if key (return val)
    # 3) remove - handle case - a) no key or prev.next (cannot remove) b) remove key using prev ref


class Node:
    def __init__(self, key , val):
        self.key = key
        self.val = val
        self.next = None

class MyHashMap:

    def __init__(self):
        self.buckets = 10000
        self.storage = [None]*self.buckets

    def hash(self,key):
        return key%self.buckets

    def helper(self, head, key):
        prev = head
        curr = head.next 
        while curr and curr.key!=key:
            prev,curr = curr, curr.next
        return prev

    def put(self, key: int, value: int) -> None:
        index = self.hash(key)
        if not self.storage[index]:
            self.storage[index] = Node(-1,-1)
        prev = self.helper(self.storage[index], key)
        if not prev.next:
            prev.next = Node(key, value)
        prev.next.val = value
        
    def get(self, key: int) -> int:
        index = self.hash(key)
        if not self.storage[index]:
            return -1
        prev = self.helper(self.storage[index], key)
        if not prev.next:
            return -1
        return prev.next.val

    def remove(self, key: int) -> None:
        index = self.hash(key)
        if not self.storage[index]:
            return None
        prev = self.helper(self.storage[index], key)
        if not prev.next:
            return None
        temp = prev.next
        prev.next = temp.next
        temp.next = None



        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
