# Time Complexity: O(1)
# Space Complexity: O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Had minor bug when handling the condition
# for Value=0 and None, as at val=0 wasn't entering the condition which was meant for None

class MyHashMap:

    def __init__(self):
        self.size = 1000
        self.arr = [None]*self.size

    def hash1(self,key):
        return (key % self.size)

    def hash2(self,key):
        return (key // self.size)

    def put(self, key: int, value: int) -> None:
        main_idx = self.hash1(key)
        bucket_idx = self.hash2(key)
        if self.arr[main_idx] == None:
            if main_idx == 0:
                self.arr[main_idx] = [None]*(self.size + 1)
            else:
                self.arr[main_idx] = [None]*(self.size)
        self.arr[main_idx][bucket_idx] = value

    def get(self, key: int) -> int:
        main_idx = self.hash1(key)
        bucket_idx = self.hash2(key)
        if self.arr[main_idx]:
            if self.arr[main_idx][bucket_idx] != None:
                return self.arr[main_idx][bucket_idx]
        return -1

    def remove(self, key: int) -> None:
        main_idx = self.hash1(key)
        bucket_idx = self.hash2(key)
        if self.arr[main_idx]:
            self.arr[main_idx][bucket_idx] = None
            return
        else:
            return

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)