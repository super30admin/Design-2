class MyHashMap:

    def __init__(self):
        self.hashmap = []

    def put(self, key: int, value: int) -> None:
        # Check if the key already exists in the hashmap
        for i, (k, v) in enumerate(self.hashmap):
            if k == key:
                # Update the value if the key exists
                self.hashmap[i] = (key, value)
                return
        # Append a new key-value pair if the key doesn't exist
        self.hashmap.append((key, value))

    def get(self, key: int) -> int:
        # Iterate through the hashmap to find the key
        for k, v in self.hashmap:
            if k == key:
                return v
        # Return -1 if the key doesn't exist
        return -1

    def remove(self, key: int) -> None:
        # Iterate through the hashmap to find the key
        for i, (k, v) in enumerate(self.hashmap):
            if k == key:
                # Remove the key-value pair if the key exists
                del self.hashmap[i]
                return



# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)