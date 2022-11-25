#Time Complexity :  put, get, remove O(1)
#Space Complexity : O(n) since we are using array data structure
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : Yes faced difficulty with put and remove method

#Your code here along with comments explaining your approach
class Linkedlist_Node:
    def __init__(self, key, val, next=None):
        self.key = key
        self.val = val
        self.next = next

class MyHashMap:

    def __init__(self):
        self.storage = [None] * 10000                                   #initializing storage arr of size 10000 with None
        
    def calculateHash(self, key):                                       #function to calculate hash
        return key % 10000

    def put(self, key: int, value: int) -> None:
        bucket = self.calculateHash(key)
        if self.storage[bucket] is None:                                #if the key,value to be added is not in storage
            self.storage[bucket] = Linkedlist_Node(key, value)          #we create a new Node and add it to storage[bucket]
        else:
            node = self.storage[bucket]                                 #if storage[bucket] is not None we get node value
            while node:
                if node.key == key:                                     #if node key matches with existing key
                    node.val = value                                    #we update value
                    return
                node = node.next                                        #otherwise we move forward
            node = self.storage[bucket]
            self.storage[bucket] = Linkedlist_Node(key, value, node)    #we add the updated node to the storage[bucket]

    def get(self, key: int) -> int:
        bucket = self.calculateHash(key)
        if self.storage[bucket] is None:                                #if storage[bucket] is None we return -1
            return -1
        else:
            node = self.storage[bucket]                                 #if node exists
            while node:
                if node.key == key:                                     #and node.key matches with key we are looking for
                    return node.val                                     #we return the node's value
                node = node.next
            return -1                                                   #else return -1

    def remove(self, key: int) -> None:
        bucket = self.calculateHash(key)
        if self.storage[bucket]:                                        #if storage[bucket] has node
            node = self.storage[bucket]                             
            if node.key == key:                                         #node's key matches the key we are looking for
                self.storage[bucket] = node.next                        #change pointer
                return 
            prev = node
            node = node.next
            while node:
                if node.key == key:
                    prev.next = node.next                               #shifting pointer to point to node.next.next
                    return 
                prev = prev.next
                node = node.next


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)