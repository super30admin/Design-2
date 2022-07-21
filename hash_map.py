
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach is almost the same as hash set, but replaced booleans with Values

class MyHashMap:

    def __init__(self, size: int = None):
        self._max = 1000 if size is None else size
        self._a = [None] * self._max

    def hash_function(self, key: int) -> (int, int):
        """
        Hashes the Given key and returns the hashing keys
        :param key:
        :return: tuple of two hashing keys
        """
        # Time Complexity : O(1)
        # Space Complexity : O(1)
        return key % self._max, key // self._max

    def put(self, key: int, value: int) -> None:
        """
        Add a key, value pair to the hash map
        :param key:
        :param value:
        :return: None
        """
        # Time Complexity : O(1)
        # Space Complexity : O(1)
        (hash1, hash2) = self.hash_function(key)
        if not self._a[hash1]:
            self._a[hash1] = [None] * (self._max + 1)
        self._a[hash1][hash2] = value
        return

    def get(self, key: int) -> int:
        """
        Check if the given key is in the HashMap
        :param key:
        :return: value for the key
        """
        # Time Complexity : O(1)
        # Space Complexity : O(1)
        (hash1, hash2) = self.hash_function(key)
        if self._a[hash1] is None:
            return -1
        if self._a[hash1][hash2] is None:
            return -1
        return self._a[hash1][hash2]

    def remove(self, key: int) -> None:
        """
        Remove a key, value pair from hash map(aka dict in python)
        :param key:
        :return:
        """
        # Time Complexity : O(1)
        # Space Complexity : O(1)
        (hash1, hash2) = self.hash_function(key)
        if self._a[hash1] is None:
            return
        if self._a[hash1][hash2] is None:
            return
        self._a[hash1][hash2] = None
        return
