class MyHashMap:
    # Time Complexity: O(1) for put, get, and remove
    # Space Complexity: O(n)
    # Leetcode: Yes
    # Faced issues: No 

    def __init__(self):
        self.primaryBucket = 1000
        self.secondaryBucket = 1000
        self.storage = [None] * self.primaryBucket

    def _get_hashes(self, key):
        return key % self.primaryBucket, key // self.secondaryBucket

    def put(self, key: int, value: int) -> None:
        # Inserts value into the map by calculating indexes, allocating space if needed
        primaryHash, secondaryHash = self._get_hashes(key)
        if self.storage[primaryHash] is None:
            if primaryHash == 0:
                self.storage[primaryHash] = [-1] * (self.secondaryBucket + 1)
            else:
                self.storage[primaryHash] = [-1] * self.secondaryBucket
        self.storage[primaryHash][secondaryHash] = value

    def get(self, key: int) -> int:
        # Returns value associated with key, or -1 if no value
        primaryHash, secondaryHash = self._get_hashes(key)
        if self.storage[primaryHash] is None:
            return -1
        return self.storage[primaryHash][secondaryHash]

    def remove(self, key: int) -> None:
        # Removes key by setting its value to -1
        primaryHash, secondaryHash = self._get_hashes(key)
        if self.storage[primaryHash] is not None:
            self.storage[primaryHash][secondaryHash] = -1
