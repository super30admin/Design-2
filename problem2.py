#approach -> double hashing
#t.c. -> o(1) for all ops
#s.c. -> o(n)
class MyHashMap:

    def __init__(self):
        #contraints = 0-10^6 use map space - 10^3
        self.map = [[] for i in range(1000)]
    
    def hashkey1(self, key):
        return key % (1000)
    
    def hashkey2(self, key):
        return key // (1000)

    def put(self, key: int, value: int) -> None:
        key1, key2 = self.hashkey1(key), self.hashkey2(key)
        if not self.map[key1]:
            if key1 == 0: #need extra 1 space for key = 0 -> 1000 = 1001 keys
                self.map[key1] = [[] for i in range(1001)]
            else:
                self.map[key1] = [[] for i in range(1000)]
        
        self.map[key1][key2] = [key, value]

    def get(self, key: int) -> int:
        key1, key2 = self.hashkey1(key), self.hashkey2(key)
        if not self.map[key1] or not self.map[key1][key2]:
            return -1
        return self.map[key1][key2][1]
    
    def remove(self, key: int) -> None:
        key1, key2 = self.hashkey1(key), self.hashkey2(key)
        if not self.map[key1]:
            return
        self.map[key1][key2] = []

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)