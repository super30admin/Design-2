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

    # if the main array has none at the obtained location, intialize a new array with given size
    # now if it is in the 0th bucket we need to cover for the case where key=10^6 -> hash2= 1000
    # which would be out of index range, so just for that case we use size+1, otherwise
    # the bucket will have 0-999 i.e 1000 elements
    # if there already exists an array at the location just add/update the value at that index
    # O(1)
    def put(self, key: int, value: int) -> None:
        main_idx = self.hash1(key)
        bucket_idx = self.hash2(key)
        if self.arr[main_idx] == None:
            if main_idx == 0:
                self.arr[main_idx] = [None]*(self.size + 1)
            else:
                self.arr[main_idx] = [None]*(self.size)
        self.arr[main_idx][bucket_idx] = value

    # if arr[main_idx] is None -> location is empty, nothing to remove, then return -1
    # else return the value stored in the bucket
    def get(self, key: int) -> int:
        main_idx = self.hash1(key)
        bucket_idx = self.hash2(key)
        if self.arr[main_idx]:
            if self.arr[main_idx][bucket_idx] != None:
                return self.arr[main_idx][bucket_idx]
        return -1

    # if arr[main_idx] is None -> location is empty, nothing to remove, then return
    # else change the value variable at the bucket to None
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