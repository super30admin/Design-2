"""Explanation: Using the inbuilt dictionary DS, we can build a HashMap that can stire key,value pairs
amd can be retrieved using the key"""

class MyHashMap:

    def __init__(self):
        self.dict = {}

    def put(self, key: int, value: int) -> None:
        self.dict[key] = value

    def get(self, key: int) -> int:
        if key in self.dict:
            return self.dict[key]
        return -1

    def remove(self, key: int) -> None:
        if key in self.dict:
            self.dict.pop(key) 