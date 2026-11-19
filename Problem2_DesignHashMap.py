# Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach: 1. For performing linear chaining, we create a Node class to define the Linked List nodes and a getPrev function to avoid redundancy of fetching the prev node.
#           2. In the put, get and remove functions, we use the hash function to get the index of the key. Then we call the get Prev function to get the node right before the key-node.
#           3. In all 3 cases, if prev.next is None, that means that we have reached the end of the linked list and the key we are looking for is not available, else we perform the required operation on the prev.next node
class Node:
    def __init__(self, key= None, val=None):
        self.key = key
        self.val = val
        self.next = None

class MyHashMap:

    def __init__(self):
        self.bucketSize = 10000
        self.bucket = [None] * self.bucketSize
    
    def _hashFn(self, key):
        return key % self.bucketSize

    def getPrev(self, head, key):
        prev = None
        curr = head

        while curr and curr.key != key:
            prev = curr
            curr = curr.next
        return prev

    def put(self, key: int, value: int) -> None:
        idx = self._hashFn(key)

        if not self.bucket[idx]:
            self.bucket[idx] = Node(-1,-1)
        prev = self.getPrev(self.bucket[idx], key)

        if not prev.next:
            prev.next = Node(key, value)
        else:
            prev.next.val = value


    def get(self, key: int) -> int:
        idx = self._hashFn(key)
        if not self.bucket[idx]:
            return -1

        prev = self.getPrev(self.bucket[idx], key)
        if not prev.next:
            return -1
        return prev.next.val

    def remove(self, key: int) -> None:
        idx = self._hashFn(key)

        if not self.bucket[idx]:
            return -1

        prev = self.getPrev(self.bucket[idx], key)
        if not prev.next:
            return -1
        else:
            prev.next = prev.next.next


commands = ["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
arguments = [[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]

output = []
obj = None

for cmd, args in zip(commands, arguments):
    if cmd == "MyHashMap":
        obj = MyHashMap()
        output.append(None)
    elif cmd == "put":
        output.append(obj.put(args[0], args[1]))
    elif cmd == "get":
        output.append(obj.get(args[0]))
    elif cmd == "remove":
        output.append(obj.remove(args[0]))

print("Output:", output)