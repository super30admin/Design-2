#Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class ListNode:
    def __init__(self, key=-1, val=-1, next=None):
        self.key = key
        self.value = val
        self.next = next

class MyHashMap:

    def __init__(self):
        self.primaryarray = 10000
        self.storage = [None] * self.primaryarray
        

    def getKeyHash(self, key):
        return key % self.primaryarray

    def getPrevNode(self, key, node):
        prev = None
        curr = node
        while curr:
            if curr.key == key:
                return prev
            prev = curr
            curr = curr.next
        return prev

    def put(self, key: int, value: int) -> None:
        keyHash = self.getKeyHash(key)
        if not self.storage[keyHash]:
            self.storage[keyHash] = ListNode()
        node = self.storage[keyHash]
        prevNode = self.getPrevNode(key, node)
        if not prevNode.next:
            prevNode.next = ListNode(key, value)
        else:
            prevNode.next.value = value

    def get(self, key: int) -> int:
        keyHash = self.getKeyHash(key)
        if not self.storage[keyHash]:
            return -1
        else:
            node = self.storage[keyHash]
            prev = self.getPrevNode(key, node)
            if not prev.next:
                return -1
            return prev.next.value


    def remove(self, key: int) -> None:
        keyHash = self.getKeyHash(key)
        if not self.storage[keyHash]:
            return
        node = self.storage[keyHash]
        prevNode = self.getPrevNode(key, node)
        if not prevNode.next:
            return
        prevNode.next = prevNode.next.next