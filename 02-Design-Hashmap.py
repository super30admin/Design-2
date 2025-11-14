# Problem 2: Design HashMap (https://leetcode.com/problems/design-hashmap/)

# Time Complexity : O(1) for put, get, and remove operations
# Space Complexity : O(n) where n is the number of unique keys added to the HashMap
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No  

# Your code here along with comments explaining your approach
# We will use an array of linked lists to implement the HashMap. Each index in the array will represent a bucket.
# A hash function will be used to determine the index for a given key. Each bucket will be a linked list to handle collisions.
# We will also use a dummy head node for each linked list to simplify insertion and deletion operations.

class MyHashMap:
    class Node:
        def __init__(self, key = None, value = None, next = None):
            self.key = key
            self.value = value
            self.next = None

    def __init__(self):
        self.arr = [None]*10000

    def find(self, head, key):
        prev = None
        curr = head

        while curr!= None and curr.key != key:
            prev = curr
            curr = curr.next
        return prev

    def hash_func(self, key):
        return key%10000

    def put(self, key: int, value: int) -> None:
        idx = self.hash_func(key)
        if self.arr[idx] == None:
            self.arr[idx] = self.Node(-1, -1, None) #dummy

        # if key exists update the value, if not then create the value
        prev = self.find(self.arr[idx], key)
        if prev.next == None: #we were not able to find key
            prev.next = self.Node(key, value, None) # creating new node
        else:
            prev.next.value = value #updating

    def get(self, key: int) -> int:
        idx = self.hash_func(key)
        if self.arr[idx] == None: # no LL initiated
            return -1
        else:
            prev = self.find(self.arr[idx], key) 
            if prev.next != None: #Node we are trying to find exists
                return prev.next.value
            else:
                return -1 #key does not exist in LL

    def remove(self, key: int) -> None:
        idx = self.hash_func(key)
        if self.arr[idx] == None: # no LL initiated
            return
        else:
            prev = self.find(self.arr[idx], key)
            if prev.next == None:
                return 
            else:
                prev.next = prev.next.next

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)