# HashMap with double hashing for collision handling
# TC = O(1) for all the methods
# SC = O(N) where N is the number of keys into the hasmap
class MyHashMap:

    def __init__(self):
        # initialize Data Structure
        self.size = 1000
        self.bucketItems = 1000
        self.hashMap = [None] * self.size

    def hashfunc1(self, key):  # to calculate the bucket index
        return key % self.size

    def hashfunc2(self, key):  # to get the position in the bucket
        return key // self.bucketItems

    def put(self, key, value):
        i = self.hashfunc1(key)
        j = self.hashfunc2(key)

        # Handle the edge case for key = 1000000
        if self.hashMap[i] is None:
            if i == 0:
                self.hashMap[i] = [None] * (self.bucketItems + 1)
            else:
                self.hashMap[i] = [None] * self.bucketItems

        self.hashMap[i][j] = value

    def get(self, key):
        i = self.hashfunc1(key)
        j = self.hashfunc2(key)

        if self.hashMap[i] is None or self.hashMap[i][j] is None:
            return -1
        return self.hashMap[i][j]

    def remove(self, key):
        i = self.hashfunc1(key)
        j = self.hashfunc2(key)

        if self.hashMap[i] is not None:
            self.hashMap[i][j] = None


# Example:
obj = MyHashMap()
obj.put(1, 10)
obj.put(2, 20)
param_1 = obj.get(1)
print(param_1)
param_2 = obj.get(3)
print(param_2)

obj.put(2, 30)
param_3 = obj.get(2)
print(param_3)

obj.remove(2)
param_4 = obj.get(2)
print(param_4)
