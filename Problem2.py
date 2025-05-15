"""
Time Complexity: 
 - put: O(1)
 - get: amortized O(1)
 - remove: amortized O(1)
 
Space Complexity:
 - put: O(n)
 - get: O(n)
 - remove: O(n)
 
 Approach:
    - Use a hash table to store the data
    - When putting, hash the key and store the data in the corresponding node
    - When getting, hash the key and traverse the linked list to find the node with the key
    - When removing, hash the key and traverse the linked list to find the node with the key and remove it
"""

class MyHashMap:
    
    class Node:
        def __init__(self, value, key):
            self.value = value
            self.key = key
            self.next = None

    def hashFunction(self, key):
        return key % 1000

    def __init__(self):
        self.primary = [self.Node(None, None) for i in range(1000)]

    def put(self, key: int, value: int) -> None:
        index = self.hashFunction(key)
        head = self.primary[index]
        curr = head.next 
        while curr:
            if curr.key == key:
                curr.value = value 
                return 
            curr = curr.next
        new_node = self.Node(value, key) 
        temp = head.next 
        head.next = new_node 
        new_node.next = temp 


    def get(self, key: int) -> int:
        index = self.hashFunction(key)
        head = self.primary[index]
        if head.next is None:
            return -1
        else:
            temp = head.next 
            while temp:
                if temp.key == key:
                    return temp.value
                temp = temp.next
        return -1

    def remove(self, key: int) -> None:
        index = self.hashFunction(key)
        head = self.primary[index]
        if head.next is None:
            return -1
        else:
            curr = prev = head
            while curr:
                if curr.key == key:
                    prev.next = curr.next
                    curr.next = None
                    return 
                prev = curr
                curr = curr.next


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
