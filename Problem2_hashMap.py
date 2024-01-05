# // Time Complexity : for get, put, remove worst case = O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

class Node:
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.next = None

class MyHashMap:

    def __init__(self):
        self.bucketSize = 10000
        self.buckets = [None for i in range(self.bucketSize)]
    
    def getHash(self, key):
        return key %  self.bucketSize
    
    def getPrev(self, key):
        index = self.getHash(key)
        if self.buckets[index] is None:
            return None
        prev = self.buckets[index]
        curr = prev.next
        while(curr!= None and curr.key!=key):
            prev = curr
            curr = curr.next
        return prev
        
    def put(self, key: int, value: int) -> None:
        prev = self.getPrev(key)
        #no entry in bucket
        if prev == None:
            index = self.getHash(key)
            self.buckets[index] = Node(-1,-1)
            prev = self.buckets[index]
            prev.next = Node(key,value)
        #no next key present
        elif prev.next == None:
            prev.next = Node(key,value)
        #there is a key
        else:
            prev.next.value = value

    def get(self, key: int) -> int:
        prev = self.getPrev(key)
        if prev == None or prev.next == None:
            return -1
        else:
            return prev.next.value
        
        
    def remove(self, key: int) -> None:
        prev = self.getPrev(key)
        if prev != None and prev.next != None:
            #point to next node if next node exists
                prev.next = prev.next.next
        else:
            return -1
    
                    
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)