# Time Complexity : 
#                 Worst Case => O(n)
#                 Average Case => O(k), where k is the max length of one box in self.list
#                 Best Case => O(1)
# Space Complexity : O(n)

class MyHashMap:

    def __init__(self):
        self.buckets = 1000
        self.bucketItems = 1000
        self.list = [[] for i in range(self.buckets)] 

    def hash_function1(self, key):
        return key % self.buckets

    def hash_function2(self, key):
        return int(key / self.bucketItems)

    def put(self, key: int, value: int) -> None:
        hash1 = self.hash_function1(key)
        hash2 = self.hash_function2(key)
        if self.list[hash1] == []:
            if hash1 == 0:
                self.list[hash1] = [None for i in range(self.bucketItems+1)]
            else:
                self.list[hash1] = [None for i in range(self.bucketItems)]
        self.list[hash1][hash2] = value       
        
    def get(self, key: int) -> int:
        hash1 = self.hash_function1(key)
        hash2 = self.hash_function2(key)
        if self.list[hash1] == [] or self.list[hash1][hash2] == None:
            return -1
        return self.list[hash1][hash2]

    def remove(self, key: int) -> None:
        hash1 = self.hash_function1(key)
        hash2 = self.hash_function2(key)
        if self.list[hash1] == []:
            return
        self.list[hash1][hash2] = None
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)