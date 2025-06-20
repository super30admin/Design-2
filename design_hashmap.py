"""
# Time Complexity :

Put - O(1) amortized
Get  - O(1) amortized
Remove  - O(1) amortized


# Space Complexity :

O(N + M), where N is the number of buckets and M is the total number of elements present in the hashmap


# Did this code successfully run on Leetcode :
Yes

# Any problem you faced while coding this :
- had some difficulty drawing up the custom Node class and handling the None scenarios initially, had mistakenly made a list of nodes rather than relying on the node pointers themselves
- initially implemented the buckets internally using a hashmap which was working but not the goal of this exercise

"""

#Explanation (within 3 lines) - Hashmap implementation using linear chaining using linked list nodes to achieve amortized O(1) time complexity for put, get and remove operations. Used a dummy node to simplify logic within a separate, reusable find() method.


class Node:

    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.next = None
    

class MyHashMap:

    def __init__(self):
        self.buckets = 1000
        self.arr =  [None for _ in range(self.buckets)]

    def getBucket(self, key):
        return key % self.buckets

    def find(self, key, headNode):
        prev = None
        curr = headNode

        while curr != None:
            if curr.key == key:
                return prev, curr
            prev = curr
            curr = curr.next
        
        return prev,curr

        

    def put(self, key: int, value: int) -> None:
        bucket = self.getBucket(key)
        if self.arr[bucket] == None:
            dummyNode = Node(-1, -1)
            self.arr[bucket] = dummyNode
        
        prev, curr = self.find(key, self.arr[bucket])

        if curr is None:
            #did not find the key anywhere, curr is None now
            newNode = Node(key, value)
            prev.next = newNode
        else:
            curr.value = value
        return


    def get(self, key: int) -> int:
        bucket = self.getBucket(key)
        if self.arr[bucket] is None:
            return -1
        prev, curr = self.find(key, self.arr[bucket])
        if curr == None:
            return -1
        return curr.value
        

    def remove(self, key: int) -> None:
        bucket = self.getBucket(key)
        if self.arr[bucket] is None:
            return
        prev, curr = self.find(key, self.arr[bucket])
        if curr == None:
            return
        prev.next = curr.next
        return
        
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
