class MyHashSet:
    BUCKETS = 1000
    BUCKETITEMS = BUCKETS
    def __init__(self):
        self.set = [None] * MyHashSet.BUCKETS
        self.hashes = lambda key: (key % MyHashSet.BUCKETS, key // MyHashSet.BUCKETITEMS)

    def add(self, key: int) -> None:
        first, second = self.hashes(key)
        if self.set[first] is None:
            size = MyHashSet.BUCKETITEMS
            if first == 0: size += 1
            self.set[first] = [False] * size
        self.set[first][second] = True

    def remove(self, key: int) -> None:
        first, second = self.hashes(key)
        if not self.set[first]: return
        self.set[first][second] = False

    def contains(self, key: int) -> bool:
        first, second = self.hashes(key)
        if not self.set[first]: return False
        return self.set[first][second]
