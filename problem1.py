"""
Time Complexity:  O(n) as we need to traverse through N nodes where n is number of Nodes created which will be 100 maximum for each bucket and hence can be consider as O(1)
Space Complexity: O(n) where n is the total number of input elements

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
- This problem is solved using Linear Chaining and can be solve using Double Hashing
- Primary array size is chosen as 10,000 to avoid large Linked List , which will be used as secondary data structure. 
- Traversing 1000 Nodes will definately take more time than traversing 100 nodes of a Linked List and hence Primary and Secondary DS' sizes are selected as 10000 and 100.

Put:
1. Calculate Primary Index using Hash Function
2. Check if Linked List is already present at that index
    if no:
        assign a dummy node //dummy node is useful for removal of first Linked List
    
    traverse through the Linked List 
    if key is already present:
        update the corresponding key's value
    else:
        add the newNode at the end of the Linked List

Get:
hashValue = alculate the Hash Value
if primaryArray[hashValue] == None:
    return -1

traverse through the Linked List
if on traversal if key is not present:
    return -1
else:
    return the corresponsding key's value

remove:
hashValue = alculate the Hash Value
if primaryArray[hashValue] == None:
    return // No elemets present for removal

traverse through the Linked List
if on traversal if key is not present:
    return 
else:
    prev.next = prev.next.next
"""
class Node:

    def __init__(self, key, value) -> None:
        self.key = key
        self.value = value
        self.next = None

class MyHashMap:
    
    def __init__(self):
        self.storage = [None] * 10000

    def hashFunction(self, key):
        return key % 10000

    def find(self, headNode, key):
        # prev = None
        # curr = headNode
        # while(curr != None and curr.key != key):
        #     prev = curr
        #     curr = curr.next
        # return prev
        temp = headNode
        while temp.next != None and temp.next.key != key:
            temp = temp.next
        return temp

    def put(self, key: int, value: int) -> None:
        hashValue = self.hashFunction(key)

        if self.storage[hashValue] == None:
            #Insert a dummy node
            self.storage[hashValue] = Node(-1,-1)
        
        prev = self.find(self.storage[hashValue], key)

        if prev.next == None:
            #Key does not exist alread
            prev.next = Node(key,value)
        else:
            prev.next.value = value
            
    def get(self, key: int) -> int:
        hashValue = self.hashFunction(key)
        if self.storage[hashValue] == None:
            return -1
        
        prev = self.find(self.storage[hashValue], key)
        if prev.next == None:
            return -1
        else:
            return prev.next.value

    def remove(self, key: int) -> None:
        hashValue = self.hashFunction(key)
        if self.storage[hashValue] == None:
            return
        
        prev = self.find(self.storage[hashValue], key)

        if prev.next == None:
            return
        else:
            prev.next = prev.next.next

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)