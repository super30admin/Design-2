## Problem 2: Design Hashmap (https://leetcode.com/problems/design-hashmap/)
# // Time Complexity : All : O(n)
# // Space Complexity : O(1) : constant 
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : collisions logic
class MyHashMap:
    def __init__(self):
        self.space = 2069 # to avoid collisions
        self.hash = [[] for i in range(self.space)]
        # [0,1,...999][0]-->[]
        
    def put(self, key: int, value: int) -> None:
        bucket, index = self.getIndex(key) # check where to place, if present get index
        if index<0:
            bucket.append((key,value))
        else:
            bucket[index] = (key, value)
        
        
    def get(self, key: int) -> int:
        bucket, index = self.getIndex(key)
        if index < 0:
            return -1
        else:
            return bucket[index][1] # returning value
        

    def remove(self, key: int) -> None:
        bucket, index = self.getIndex(key)
        if index < 0:
            return
        else:
            bucket.remove(bucket[index])
            
    def getIndex(self, key):
        hashPosition = key % self.space
        bucket = self.hash[hashPosition]
        for i, (k, v) in enumerate(bucket):
            if k == key:
                return bucket, i # key found, so returning wiwth index
        return bucket, -1  # key not found, so returning -1

# previously tried, but not able to complete      
#     def __init__(self):
#         self.l = []

#     def put(self, key: int, value: int) -> None:
#         updated = 0
#         for i in range(len(self.l)):
#             if self.l[i][0]==key:
#                 self.l[i][1]=value
#                 updated = 1
#                 break
#         if not updated:
#             self.l.append([key, value])

#     def get(self, key: int) -> int:
#         for i in range(len(self.l)):
#             if self.l[i][0]==key:
#                 return self.l[i][1]
#         return -1

#     def remove(self, key: int) -> None:
#         for i in range(len(self.l)):
#             if self.l[i][0]==key:
#                 self.l.pop(i)


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)