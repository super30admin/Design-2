# Time Complexity - O(n) for initializing the array and O(1) for add, remove, contains function
# Space Complexity - O(1) for the operations and O(n) to store values when initiating array
# Approach - I have created a 2d array with a size of 1000 x 1000 and use two hash function one modulo and one divide
# the modulo operator will get us the location of row and divide will get us column in order to handle collision
# in put function i check first if hashset exists and if at the first hash val is there an array present if so add to the second hash val
# location self.hashmap[h1][h2] = value, now in hashset we used boolean because there were no values now we have values so we are storing 
# values. 
# This code was successfully run on Leetcode

class MyHashMap:
    def __init__(self):
        self.bucket = 1000
        self.bucketItems = 1000
        self.hashmap = None
    
    def hashfunc1(self, key):
        return key % self.bucket
    
    def hashfunc2(self, key):
        return key // self.bucketItems
    
    def put(self, key: int, val: int):
        h1, h2 = self.hashfunc1(key), self.hashfunc2(key)
        if self.hashmap is None:
            self.hashmap = [None] * self.bucket
        if self.hashmap[h1] is None:
            if h1 == 0:
                self.hashmap[h1] = [-1] * (self.bucketItems + 1)
            else:
                self.hashmap[h1] = [-1] * self.bucketItems
        self.hashmap[h1][h2] = val
        return
    
    def get(self, key: int):
        h1, h2 = self.hashfunc1(key), self.hashfunc2(key)
        if self.hashmap is None:
            return -1
        if self.hashmap[h1] is None:
            return -1
        return self.hashmap[h1][h2]
    
    def remove(self, key: int):
        h1, h2 = self.hashfunc1(key), self.hashfunc2(key)
        if self.hashmap is None:
            return
        if self.hashmap[h1] is None:
            return
        self.hashmap[h1][h2] = -1
    def show(self):
        return self.hashmap

dt = MyHashMap()
print(dt.put(1000000,1))
print(dt.put(2,2))
print(dt.get(1000000))
print(dt.get(3))
print(dt.put(2,1))
print(dt.get(2))
print(dt.remove(2))
print(dt.get(2))