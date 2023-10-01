# Time Complexity - O(1) for all the defined
# Space Complexity - O(1) for the all the functions defined
# Note to self - In the add function, a new list is created that is part of the data structure 
# not some extra auxiliary space used by the function. So, its not considered as extra consumption
# Approach - Used double hashing to store the values in the array and retrive the values in linear complexity

class MyHashMap:

    def __init__(self):
        self.buckets = 1000
        self.inner_buckets = 1000
        self.arr = [None for i in range(self.buckets)]
    
    def get_outer_hash(self, value:int)->int:
        return value % self.buckets
    
    def get_inner_hash(self, value:int)->int:
        return value // self.inner_buckets

    def put(self, key: int, value: int) -> None:
        outer_hash = self.get_outer_hash(key)
        inner_hash = self.get_inner_hash(key)
        if self.arr[outer_hash] == None:
            if outer_hash == 0: # Need to handle one extra number as the range is included
                self.arr[outer_hash] = [-1] * (self.inner_buckets+1)
            else:
                self.arr[outer_hash] = [-1] * (self.inner_buckets)

        self.arr[outer_hash][inner_hash] = value        

    def get(self, key: int) -> int:
        outer_hash = self.get_outer_hash(key)
        inner_hash = self.get_inner_hash(key)
        if self.arr[outer_hash] == None:
            return -1
        print(outer_hash, inner_hash)
        print(self.arr[outer_hash][inner_hash])
        return self.arr[outer_hash][inner_hash]

    def remove(self, key: int) -> None:
        outer_hash = self.get_outer_hash(key)
        inner_hash = self.get_inner_hash(key)
        if self.arr[outer_hash] == None:
            return
        self.arr[outer_hash][inner_hash] = -1

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)