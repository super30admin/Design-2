## Time complexity : O(1) for all operations, since we just need to calculate the index in the original and nested arrays
# Space complexity : O(1)
# The code ran on github

class MyHashMap:

    def __init__(self):
        # Initialize an array of size 1000, all elements pointing to None
        self.bucket = 1000
        self.map = [None]*self.bucket

    def hash(self, key):
        # Get hash key in the original array
        return key%self.bucket
    
    def hashBucket(self, key):
        # Get hash key in the nested array
        return key//1000

    def put(self, key: int, value: int) -> None:
        # Calculate hash values 
        hash_key = self.hash(key)
        hash_key_bucket = self.hashBucket(key)
        # Initialize nested array with values [-1, -1], which will be updated later
        if self.map[hash_key] == None:
            if hash_key == 0:
                self.map[hash_key] = [[-1, -1]]*(self.bucket + 1)
            else:
                self.map[hash_key] = [[-1, -1]]*(self.bucket)
        # Update the key, value pair in the nested array
        self.map[hash_key][hash_key_bucket] = [key, value]

    def get(self, key: int) -> int:
        hash_key = self.hash(key)
        hash_key_bucket = self.hashBucket(key)
        # If nested array is empty or the corresponding position has value [-1, -1], key is not mapped to any value 
        if self.map[hash_key] == None or self.map[hash_key][hash_key_bucket] == [-1, -1]:
            return -1
        return self.map[hash_key][hash_key_bucket][-1]

    def remove(self, key: int) -> None:
        hash_key = self.hash(key)
        hash_key_bucket = self.hashBucket(key)
        if self.map[hash_key] == None or self.map[hash_key][hash_key_bucket] == [-1, -1]:
            return
        else:
            # If key has a corresponding value, it is set to -1. This is equivalent to removing the key, value pair from the nested arary
            self.map[hash_key][hash_key_bucket] = [-1, -1]



# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)