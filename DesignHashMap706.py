# Time Complexity :
# put: O(1)
# get: O(1)
# remove: O(1)
# Space Complexity :
# put: O(1)
# get: O(1)
# remove: O(1


class MyHashMap:

    def __init__(self):
        self.buckets = 1000
        self.inner_bucket_size = 1000
        self.map = [None for _ in range(self.buckets)]
        self.hash_1 = lambda key : key % self.buckets
        self.hash_2 = lambda key : key // self.buckets

    def put(self, key: int, value: int) -> None:
        idx = self.hash_1(key)
        inner_idx = self.hash_2(key)
        if not self.map[idx]:
            size = self.inner_bucket_size
            if idx == 0:
                size += 1
            self.map[idx] = [None for _ in range(size)]
        
        self.map[idx][inner_idx] = value

    def get(self, key: int) -> int:
        idx = self.hash_1(key)
        inner_idx = self.hash_2(key)
        if self.map[idx] == None or self.map[idx][inner_idx] == None:
            return -1
        return self.map[idx][inner_idx]
        
    def remove(self, key: int) -> None:
        idx = self.hash_1(key)
        inner_idx = self.hash_2(key)
        if not self.map[idx]:
            return
        self.map[idx][inner_idx] = None
