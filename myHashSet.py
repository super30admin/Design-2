# Time Complexity : O(1)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : index bound issue with input 10^6. solved by adding an extra bucket

"""
we will be designing a hashset using double hashing. We select primary and secondary bucket with respect to key value range
here the key range is from 0 to 10^6. So deciding the bucket as 10^3 for both
now we can say we have 1000 primary buckets which holds 1000 boolean values.
the primary hash function tells which bucket to use and secondary identifies the exact position
we have initialized the primary buckets with null values
when we want to add: we will calculate the primary index. if that bucket is null, we allocate 1000 slots. with the help of secondaryindex we will set the value to true
while removing we change the value to false
for contains we do the same process and return its value
"""

class MyHashSet:

    def __init__(self):
        self.primaryBuckets = 1000
        self.secondaryBuckets = 1000
        self.storage = [None] * self.primaryBuckets

    def primaryHash(self,key):
        return key % self.primaryBuckets

    def secondaryHash(self,key):
        return key // self.secondaryBuckets
        
    def add(self, key: int) -> None:
        primaryIndex = self.primaryHash(key)
        size = self.secondaryBuckets
        if self.storage[primaryIndex] is None:
            if primaryIndex == 0: 
                size += 1 # Ensures storage for 10^6      
            self.storage[primaryIndex] = [False] * size
        secondaryIndex = self.secondaryHash(key)
        self.storage[primaryIndex][secondaryIndex] = True

    def remove(self, key: int) -> None:
        primaryIndex = self.primaryHash(key)
        if self.storage[primaryIndex] is None:
            return
        secondaryIndex = self.secondaryHash(key)
        self.storage[primaryIndex][secondaryIndex] = False
        
    def contains(self, key: int) -> bool:
        primaryIndex = self.primaryHash(key)
        if self.storage[primaryIndex] is None:
            return False
        secondaryIndex = self.secondaryHash(key)
        return self.storage[primaryIndex][secondaryIndex] 

"""        
Example 1:

Input
["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
[[], [1], [2], [1], [3], [2], [2], [2], [2]]
Output
[null, null, null, true, false, null, true, null, false]
"""
myHashSet = MyHashSet()
output = [None]
output.append(myHashSet.add(1))      # set = [1]
output.append(myHashSet.add(2))      # set = [1, 2]
output.append(myHashSet.contains(1)) # return True
output.append(myHashSet.contains(3)) # return False, (not found)
output.append(myHashSet.add(2))      # set = [1, 2]
output.append(myHashSet.contains(2)) # return True
output.append(myHashSet.remove(2))   # set = [1]
output.append(myHashSet.contains(2)) # return False, (already removed)

print(output)