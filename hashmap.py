# Time Complexity : O(1)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode : Yes

class MyHashMap:

    def __init__(self):
        self.arr = [[] for _ in range(1001)]

    def _hash(self, key):
        primary_index = key % 1000
        secondary_index = key // 1000
        return primary_index, secondary_index

    def put(self, key: int, value: int) -> None:
        primary_key, secondary_key = self._hash(key)
        print(primary_key, secondary_key)
        if len(self.arr[primary_key]) == 0:
            self.arr[primary_key] = [[] for _ in range(1001)]
            self.arr[primary_key][secondary_key] = [key, value]
        else:
            self.arr[primary_key][secondary_key] = [key, value]

    def get(self, key: int) -> int:
        primary_key, secondary_key = self._hash(key)
        if len(self.arr[primary_key]) == 0:
            return -1
        elif len(self.arr[primary_key][secondary_key]) == 0:
            return -1
        else:
            return self.arr[primary_key][secondary_key][1]
        
    def remove(self, key: int) -> None:
        primary_key, secondary_key = self._hash(key)
        if len(self.arr[primary_key]) == 0:
            return
        elif len(self.arr[primary_key][secondary_key]) == 0:
            return
        else:
            self.arr[primary_key][secondary_key] = []