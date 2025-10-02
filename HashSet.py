# Time Complexity : O(1) for put, get, remove because traversing the linked list is always O(100) = O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : The dummy node is important for the traverse+remove functions to work as expected.

class Node:
    def __init__(self, key: int, val: int):
        self.key = key
        self.val = val
        self.next = None

class MyHashMap:

    def __init__(self):
        # Choosing a larger primary storage so linked lists
        # will only be 100 nodes long at most.
        self.primaryStore = [None] * 10000
    
    def hashFunction(self, key: int) -> int:
        return key % 10000

    # Returns the previous node of the key we are
    # looking for OR previous of the null node.
    def traverse(self, head: Node, key: int) -> Node:
        prev = head
        curr = head.next
        while curr != None:
            if curr.key == key:
                break
            prev = curr
            curr = curr.next
        return prev

    def put(self, key: int, value: int) -> None:
        newNode = Node(key, value)
        index = self.hashFunction(key)
        if self.primaryStore[index] == None:
            # This is needed for traverse to work as expected
            # First item it compares is curr which starts at head.next
            # It also helps with remove as we can never remove the head this way.
            dummyNode = Node(-1,-1)
            self.primaryStore[index] = dummyNode
        
        prev = self.traverse(self.primaryStore[index], key)

        # If the key already exists, just update it
        if prev.next != None:
            prev.next.val = value
        else:
            prev.next = newNode

    def get(self, key: int) -> int:
        index = self.hashFunction(key)
        # No linked list in the bucket
        if self.primaryStore[index] == None:
            return -1

        prev = self.traverse(self.primaryStore[index], key)
        if prev.next == None:
            return -1
        return prev.next.val

    def remove(self, key: int) -> None:
        index = self.hashFunction(key)
        if self.primaryStore[index] == None:
            return

        prev = self.traverse(self.primaryStore[index], key)
        if prev.next == None:
            return
        
        # Remove the current node and point it to null
        # for garbage collection
        temp = prev.next
        prev.next = prev.next.next
        temp.next = None


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)