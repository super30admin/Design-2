#Using double hashing approach.
#T: O(1) for put, get and remove operation


class MyHashMap:

    def __init__(self):
        self.bucket_size = 1000
        self.sub_bucket_size = 1001
        self.table = [None] * self.bucket_size

    def _hash1(self, key):
        return key % self.bucket_size

    def _hash2(self, key):
        return key // self.bucket_size

    def put(self, key: int, value: int) -> None:
        h1 = self._hash1(key)

        if self.table[h1] is None:
            self.table[h1] = [-1] * self.sub_bucket_size

        h2 = self._hash2(key)
        self.table[h1][h2] = value  

    def get(self, key: int) -> int:
        h1 = self._hash1(key)

        if self.table[h1] is None:
            return -1

        h2 = self._hash2(key)
        return self.table[h1][h2]

    def remove(self, key: int) -> None:
        h1 = self._hash1(key)

        if self.table[h1] is not None:
            h2 = self._hash2(key)
            self.table[h1][h2] = -1


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)