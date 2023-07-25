class MyHashMap:

    def __init__(self):
        self.size = 1000
        self.table = [[] for _ in range(self.size)]

    def put(self, key: int, value: int) -> None:
        hash_key = key % self.size
        if not self.table[hash_key]:
            self.table[hash_key] = [[key,value]]
        else:
            for pair in self.table[hash_key]:
                if pair[0] == key:
                    pair[1] = value
                    return
            self.table[hash_key].append([key,value])

    def get(self, key: int) -> int:
        hash_key = key % self.size
        if self.table[hash_key]:
            for pair in self.table[hash_key]:
                if pair[0] == key:
                    return pair[1]
        return -1
  

    def remove(self, key: int) -> None:
        hash_key = key % self.size
        if self.table[hash_key]:
            for i, pair in enumerate(self.table[hash_key]):
                if pair[0] == key:
                    del self.table[hash_key][i]


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
