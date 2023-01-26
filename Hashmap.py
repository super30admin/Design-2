# All test cases passed on leetcode

class Node:
    def __init__(self, key, val):
        self.key = key
        self.val = val
        self.next = None


class MyHashMap:

    # Here we create primary array of size 10k s.t. the secondary array (linked list) 
    # holds 100 elements. 
    def __init__(self):
        self.size = 10000
        self.map = [None] * self.size

    # helper function to traverse the linked list
    def find(self, key, node):
        cur = node
        prev = None
        while cur and cur.key != key:
            prev = cur
            cur = cur.next
        return prev

    # helper function to return hash function
    def getHash(self, key):
        return key % self.size

    # Here we get the hash function and see if linked list exists at this index. 
    # If not the then we create a dummy node and then added the key-value node. 
    # If LL exists then we check if the node already present, if yes we update its value, 
    # else we add new node at the end of LL.
    # Time complexity - O(1)
    # Space complexity - Depends on elements added
    def put(self, key: int, value: int) -> None:
        hf = self.getHash(key)
        if not self.map[hf]:
            self.map[hf] = Node(-1, -1)
            self.map[hf].next = Node(key, value)
        else:
            node = self.find(key, self.map[hf])
            if not node.next:
                node.next = Node(key, value)
            else:
                node.next.val = value

    # Here we get the hash function and see if linked list exists at this index. 
    # If not the then we return -1. If LL exists then we check if the node is present, 
    # if yes we return its value, else we return -1.
    # Time complexity - O(1)
    # Space complexity - Depends on elements added
    def get(self, key: int) -> int:
        hf = self.getHash(key)
        if not self.map[hf]:
            return -1
        else:
            node = self.find(key, self.map[hf])
            if not node.next:
                return -1
            return node.next.val

    # Here we get the hash function and see if linked list exists at this index. 
    # If not the then we return. If LL exists then we check if the node is present, 
    # if yes we remove the node by connecting prev node to its next node. 
    # If not present then we just return.
    # Time complexity - O(1)
    # Space complexity - Depends on elements added
    def remove(self, key: int) -> None:
        hf = self.getHash(key)
        if not self.map[hf]:
            return
        else:
            node = self.find(key, self.map[hf])
            if not node.next:
                return
            else:
                node.next = node.next.next

