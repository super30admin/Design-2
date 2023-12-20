# // Time Complexity : O(1) 
# // Space Complexity : O(N) 
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Nope


# // Your code here along with comments explaining your approach

# Create linkedlist node class
class ListNode:
    def __init__(self, key, value):
        self.data = (key, value)
        self.next = None 

class MyHashMap:
    # Initialize mod value for hashing/mapping and base array
    def __init__(self):
        self.mod = 10**4
        self.arr = [None for _ in range(self.mod)]
    # If the mapped index is empty then add a new node to the index.
    # If it's not empty then iterate through the linkedlist to check if the key exists(and change it) else add new node to the end of the linkedlist.
    def put(self, key: int, value: int) -> None:
        index = key % self.mod
        if self.arr[index] == None:
            newNode = ListNode(key,value)
            self.arr[index] = newNode
        else:
            curr = self.arr[index]
            while True:
                if curr.data[0] == key:
                    curr.data = (key, value) 
                    return
                if curr.next == None:
                    break
                curr = curr.next
            newNode = ListNode(key,value)
            curr.next = newNode 
    # Iterate through the linkedlist at the mapped index to check if key exists, else return -1
    def get(self, key: int) -> int:
        index = key % self.mod
        curr = self.arr[index]
        while curr:
            if curr.data[0] == key:
                return curr.data[1]
            else:
                curr = curr.next
        return -1
        
        
    # Maintain prev and curr ptr and iterate through the ll and then manipulate the ptrs to remove the node with key value.
    def remove(self, key: int) -> None:
        index = key % self.mod 
        if self.arr[index]:
            curr = self.arr[index]
            prev = self.arr[index]
            if curr.data[0] == key:
                self.arr[index] = curr.next
            else:
                curr = curr.next
                while curr:
                    if curr.data[0] == key:
                        prev.next = curr.next 
                        return 
                    curr = curr.next
                    prev = prev.next
