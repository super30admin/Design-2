class MyHashMap:
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.size = 1000  # Choose a reasonably large prime number
        self.table = [[] for _ in range(self.size)]

    def _hash(self, key: int) -> int:
        """
        Hash function to map a key to an index in the table.
        """
        return key % self.size

    def put(self, key: int, value: int) -> None:
        """
        Insert a (key, value) pair into the HashMap. If the key already exists, update the value.
        """
        idx = self._hash(key)
        for i, (k, v) in enumerate(self.table[idx]):
            if k == key:
                self.table[idx][i] = (key, value)  # Update the value if key exists
                return
        self.table[idx].append((key, value))

    def get(self, key: int) -> int:
        """
        Return the value associated with a given key. If the key is not found, return -1.
        """
        idx = self._hash(key)
        for k, v in self.table[idx]:
            if k == key:
                return v
        return -1

    def remove(self, key: int) -> None:
        """
        Remove the key and its associated value from the HashMap. If the key is not found, do nothing.
        """
        idx = self._hash(key)
        for i, (k, v) in enumerate(self.table[idx]):
            if k == key:
                del self.table[idx][i]
                return

# Time Complexity:
# - For each operation (put, get, remove), the time complexity is O(1) on average.
#   This assumes that the hash function distributes keys uniformly across the table.
#   In the worst case, when there are hash collisions, the time complexity for these
#   operations can be O(N), where N is the number of keys in the table.

# Space Complexity:
# - The space complexity is O(N), where N is the number of unique keys inserted into the hashmap.
#   In the worst case, when there are many hash collisions, the space complexity can be O(K),
#   where K is the total number of keys inserted, as each bucket in the table can store multiple
#   (key, value) pairs.
