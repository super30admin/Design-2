class MyHashSet:
    def __init__(self):
        self.size = 10000
        self.buckets = [[] for _ in range(self.size)]

    def add(self, key):
        bucket, idx = self.getindex(key)
        if idx >= 0:
            return
        bucket.append(key)

    def remove(self, key):
        bucket, idx = self.getindex(key)
        if idx < 0:
            return
        bucket.remove(key)

    def contains(self, key):
        _, idx = self.getindex(key)
        return idx >= 0

    def hash(self, key):
        return key % self.size

    def getindex(self, key):
        hash = self.hash(key)
        bucket = self.buckets[hash]
        for i, k in enumerate(bucket):
            if k == key:
                return bucket, i
        return bucket, -1
