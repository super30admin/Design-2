## Problem 2: Design Hashmap (https://leetcode.com/problems/design-hashmap/)

class MyHashMap:
    class Node:
        def __init__(self, key: int = -1, val: int = -1, next_node: 'Node' | None = None):
            self.key = key
            self.val = val
            self.next = next_node

    # We will use chaining, so we want the link list to be small enough
    # so our map will be of seze 10^4
    # and link list's will have at max 10^2 nodes
    def __init__(self):
        self.n = 10000
        self.hashMap = [self.Node() for _ in range(self.n)] # we will init the hashMap with dummy nodes
        

    # Complexity: O(1)
    def put(self, key: int, value: int) -> None:
        index = self.getHashKey(key)
        previous = self.findPrevious(index, key)

        # previous.next will only be there when key is found in the linked list
        # so we need to update the value
        if previous.next:
            previous.next.val = value
        else: # else insert a new node
            previous.next = self.Node(key, value)

    # Complexity: O(1)
    def get(self, key: int) -> int:
        index = self.getHashKey(key)
        previous = self.findPrevious(index, key)

        if previous.next and previous.next.key == key:
            return previous.next.val
        return -1

    # Complexity: O(1)
    def remove(self, key: int) -> None:
        index = self.getHashKey(key)
        previous = self.findPrevious(index, key)

        # if key, value is present in the linked list, break the link
        if previous.next and previous.next.key == key:
            temp = previous.next
            previous.next = previous.next.next
            temp.next = None


    def getHashKey(self, key: int) -> int:
        return key % self.n
    
    # this is a helper function
    # we need to find the previous in each operation sine we are using a linked list
    # we mainly need previous for the remove operation to break the link
    # but for adding/updating a node, if we know the previous, we can add to its next
    # O(1) since linked list is small enough
    def findPrevious(self, index: int, key: int) -> 'Node':
        previous = None
        current = self.hashMap[index]

        while current:
            if current.key == key:
                break
            
            previous = current
            current = current.next
        
        return previous


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)