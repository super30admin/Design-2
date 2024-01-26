'''
TC: put: O(1), get: O(1), remove: O(1)
SC: O(n) - n is the number of input keys

Using Double hashing, keeping primary and nested secondary buckets as arrays
and computing the operations individually!
'''

#Double Hashing
class MyHashMap:
    def __init__(self):
        self.primary = [None for i in range(1000)]
        self.secondary = [None for i in range(1000)]       
    
    def hash1(self, key):
        return key%1000

    def hash2(self, key):
        return key//1000

    def put(self, key: int, value: int) -> None:
        primaryIndex = self.hash1(key)
        secondaryIndex = self.hash2(key)      
        if not self.primary[primaryIndex]:
            if primaryIndex == 0:
                arr = self.secondary.copy()
                arr.extend([None])
                self.primary[primaryIndex] = arr
            else:
                self.primary[primaryIndex] = self.secondary.copy()
        self.primary[primaryIndex][secondaryIndex] = (key, value)

    def get(self, key: int) -> int:
        primaryIndex = self.hash1(key)
        secondaryIndex = self.hash2(key)
        if not self.primary[primaryIndex]:
            return -1
        if self.primary[primaryIndex][secondaryIndex] != None:
            return self.primary[primaryIndex][secondaryIndex][1]
        else:
            return -1
                
    def remove(self, key: int) -> None:
        primaryIndex = self.hash1(key)
        secondaryIndex = self.hash2(key)
        if not self.primary[primaryIndex]:
            return None
        if self.primary[primaryIndex][secondaryIndex] != None:
            self.primary[primaryIndex][secondaryIndex] = None
        else:
            return None
        
# Your MyHashMap object will be instantiated and called as such:
obj = MyHashMap()
obj.put(1,1)
param_2 = obj.get(1)
print(f"The key 1 have value: {param_2}")
obj.remove(1)
param_2 = obj.get(1)
print(f"The key 1 have value: {param_2}")
obj.put(1,1)
param_2 = obj.get(1)
print(f"The key 1 have value: {param_2}")
obj.put(1,2)
param_2 = obj.get(1)
print(f"The key 1 have value: {param_2}")