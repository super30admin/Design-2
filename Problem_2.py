class MyHashMap:

    def __init__(self):
        self.buckets = 1000
        self.subbuckets = 1000
        self.my_map = [None] * self.buckets

    def _hash1(self, key):
        return key % self.buckets

    def _hash2(self, key):
        return key // self.subbuckets

    def put(self, key: int, value: int) -> None:
        currentBucket = self._hash1(key)
        if self.my_map[currentBucket] is None:
            if currentBucket == 0:
                self.my_map[currentBucket] = [-1] * (self.subbuckets + 1)
            else:
                self.my_map[currentBucket] = [-1] * (self.subbuckets)
        currentSubBucket = self._hash2(key)
        self.my_map[currentBucket][currentSubBucket] = value

    def get(self, key: int) -> int:
        currentBucket = self._hash1(key)
        if self.my_map[currentBucket] is None:
            return -1
        else:
            currentSubBucket = self._hash2(key)
            if self.my_map[currentBucket][currentSubBucket] != -1:
                return self.my_map[currentBucket][currentSubBucket]
        return -1

    def remove(self, key: int) -> None:
        currentBucket = self._hash1(key)
        if self.my_map[currentBucket] is None:
            return
        else:
            currentSubBucket = self._hash2(key)
            self.my_map[currentBucket][currentSubBucket] = -1


myHashMap = MyHashMap();
myHashMap.put(1, 1)
myHashMap.put(2, 2)
myHashMap.get(1)
myHashMap.get(3)
myHashMap.put(2, 1)
myHashMap.get(2)
myHashMap.remove(2)
myHashMap.get(2)