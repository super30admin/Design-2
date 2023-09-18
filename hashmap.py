class MyHashMap:

    def __init__(self):
        self.list = [None]*1000

    def bucket(self, key):
        return key % 1000
    def bucketItems(self, key):
        return key // 1000

    def put(self, key: int, value: int) -> None:
        bucket = self.bucket(key)
        bucketItem = self.bucketItems(key)
        if self.list[bucket] == None:
            if bucket == 0:
                self.list[bucket] = [-1]*1001
            else:
                self.list[bucket] = [-1]*1000
        self.list[bucket][bucketItem] = value


    def get(self, key: int) -> int:
        bucket = self.bucket(key)
        bucketItem = self.bucketItems(key)
        if self.list[bucket] == None:
            return -1
        return self.list[bucket][bucketItem]

    def remove(self, key: int) -> None:
        bucket = self.bucket(key)
        bucketItem = self.bucketItems(key)
        if self.list[bucket] != None:
            self.list[bucket][bucketItem] = -1
