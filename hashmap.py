# // Time Complexity :
#  O(1) for put,get,remove and worst Case is O(N)
# // Space Complexity : O(n) where n is number of elements inserted
# // Did this code successfully run on Leetcode : yes 
# // Any problem you faced while coding this :No 

class MyHashMap:

    def __init__(self):
        self.size = 10000
        self.has_bucket = [[] for _ in range(self.size)]
    def _hash(self,key):
        return key%self.size

    def put(self, key: int, value: int) -> None:
        hash_index = self._hash(key)
        for pair in self.has_bucket[hash_index]:
            if pair[0] == key:
                pair[1] = value
                print("after update",self.has_bucket[hash_index])
                return
        self.has_bucket[hash_index].append([key,value])

    def get(self, key: int) -> int:
        hash_index = self._hash(key)
        for pair in self.has_bucket[hash_index]:
            if pair[0] == key:
                return pair[1]
        return -1

    def remove(self, key: int) -> None:
        hash_index = self._hash(key) 
        for pair in self.has_bucket[hash_index]:
            print("all pair",pair)
            if pair[0] == key:
                print(pair)
                self.has_bucket[hash_index].remove(pair)

        
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)