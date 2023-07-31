# Time Complexity : O(1)
# Space Complexity : O(N + self.capacity) // self.capacity is constatnt here so O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class MyHashMap:

    class Node:
        def __init__(self, key:int, value:int):
            self.key = key
            self.value = value
            self.next = None

    def find(self, key: int, head: Node) -> Node:
        # function finds the node given key in the linked list from the head node
        prev = head
        curr = head.next
        while curr != None and curr.key != key:
            prev = curr
            curr = curr.next
        return prev

    def getBucket(self, key: int) -> int:
        # hash function to return index of the bucket
        return hash(key) % self.buckets

    def __init__(self):
        # Initialize HashMap and array of linkedLsit elements linked to and index of the bucket based on hash function 
        self.buckets = 10000
        self.storage = [None] * self.buckets

    def put(self, key: int, value: int) -> None:
        # get bucket index based on hash function
        bucket = self.getBucket(key)
        # if bucket is empty create a dummy node
        if self.storage[bucket] == None:
            self.storage[bucket] = self.Node(-1, -1)
        #  finds the node with the key in the linked list 
        prev = self.find(key, self.storage[bucket])
        # if key does not exist, create a new node and append it to the previous node else udpate the value of existing key 
        if prev.next == None:
            prev.next = self.Node(key, value)
        else:
            prev.next.value = value

    def get(self, key: int) -> int:
        #  get bucket index based on hash function
        bucket = self.getBucket(key)
        # if the bucket is empty, the key does not exist 
        if self.storage[bucket] == None:
           return -1
        # else find the node in the linked list using key 
        prev = self.find(key, self.storage[bucket])
        #if the node does not exist return -1 else return the value of the node 
        if not prev.next:
            return -1
        return prev.next.value 

    def remove(self, key: int) -> None:
        #  get bucket index based on hash function
        bucket = self.getBucket(key)
        # if the bucket is empty, the key does not exist, return 
        if self.storage[bucket] == None:
            return
        # else find the node in the linked list using key 
        prev = self.find(key, self.storage[bucket])
        #if the node does not exist return -1 else remove node 
        if prev.next == None:
            return -1
        prev.next.value


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)