class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.storage = [[False] * 1001] * 1000

    def buckets(self, key):
        return key // 1001

    def bucketitems(self, key):
        return key % 1000

    def add(self, key: int) -> None:
        keys_index = self.buckets(key)
        keys_bucket = self.bucketitems(key)
        self.storage[keys_index][keys_bucket] = True
        return None

    def remove(self, key: int) -> None:
        keys_index = self.buckets(key)
        keys_bucket = self.bucketitems(key)
        self.storage[keys_index][keys_bucket] = False
        return None

    def contains(self, key: int) -> bool:
        keys_index = self.buckets(key)
        keys_bucket = self.bucketitems(key)
        if self.storage[keys_index][keys_bucket]:
            return True
        else:
            return False

        # Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)