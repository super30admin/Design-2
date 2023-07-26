'''
1. To avoid collision, two lists are used and key is hashed using two hash functions and prime numbers 163, 1049 are used to compute indices
2. For all operations, the indices for the key are calculated first. For put, if entry at index1 is None, create the second list and store the value at index2 calculated before.
3. Get operation is similar to put. We fetch if value exists or return -1. Remove reassings the value at index2 to None
'''
# Time Complexity : O(1) for put, O(1) for get, O(1) for remove
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes, initial approach took more time with two lists. Later, with double hashing also I had some test cases failing due to collision.

class MyHashMap:

    def __init__(self):
        self.values = [None for _ in range(163)]

    def get_hash1(self,key) -> int :
        return key % 163

    def get_hash2(self,key) -> int:
        return key % 1049
    
    def put(self, key: int, value: int) -> None:
        index1 = self.get_hash1(key)
        index2 = self.get_hash2(key)
        if self.values[index1] is None:
            self.values[index1] = [None for _ in range(1049)]
        print(index1,index2)
        self.values[index1][index2] = value 

    def get(self, key: int) -> int:
        index1 = self.get_hash1(key)
        index2 = self.get_hash2(key)
        if self.values[index1]:
            if self.values[index1][index2] is not None:
                return self.values[index1][index2]
        return -1

    def remove(self, key: int) -> None:
        index1 = self.get_hash1(key)
        index2 = self.get_hash2(key)
        if self.values[index1]:
            if self.values[index1][index2] is not None:
                self.values[index1][index2] = None
