# // Time Complexity : O(1)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
class MyHashMap:

    def __init__(self):
        self.size = 1000
        self.hm = [[None for j in range(self.size)] for i in range(self.size)]
    
    def first_hash(self,key):
        fh = key % self.size
        return fh
    
    def second_hash(self,key):
        sh = key//self.size
        return sh

    def put(self, key: int, value: int) -> None:
        fh = self.first_hash(key)
        sh = self.second_hash(key)
        self.hm[fh][sh] = value
        

    def get(self, key: int) -> int:
        fh = self.first_hash(key)
        sh = self.second_hash(key)
        if self.hm[fh][sh]!=None:
            return self.hm[fh][sh]
        else:
            return -1

    # def remove(self, key: int) -> None:
    def remove(self, key: int) -> None:
        fh = self.first_hash(key)
        sh = self.second_hash(key)
        if self.hm[fh][sh]!=None:
            del self.hm[fh][sh]
        


# Your MyHashMap object will be instantiated and called as such:
obj = MyHashMap()
obj.put(13,2)
# print(obj.hm)
print(obj.get(13))
# param_2 = obj.get(key)
print(obj.remove(13))