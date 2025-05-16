# Intialising an array of size n and proceeding with hashing
# Keys are hashed using modulo and stored as [key, value] pairs in a fixed-size array of buckets.
# In each operation, searching if key already exists in the bucket, then performing operation accordingly; else, returning null or -1
class MyHashMap:

    def __init__(self):
        self.n = 10 ** 6
        self.map=[[] for _ in range(self.n)]

    def put(self, key: int, value: int) -> None:
        index = key % self.n
        for pair in self.map[index]:
            if pair[0] == key:
                pair[1] = value 
                return
        self.map[index].append([key, value]) 

    def get(self, key: int) -> int:
        index = key % self.n
        for pair in self.map[index]:
            if pair[0] == key:
                return pair[1]  
        return -1  # Key not found

    def remove(self, key: int) -> None:
        index = key % self.n
        for i, pair in enumerate(self.map[index]):
            if pair[0] == key:
                self.map[index].pop(i)  
                return


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)