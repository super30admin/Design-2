class MyHashMap:

    def __init__(self):
        self.size = 10000
        self.buckets = [[] for _ in range(self.size)]
    def hashvalue(self, key: int):
        return key % self.size

    def put(self, key: int, value: int) -> None:
        index = self.hashvalue(key)
        for i, (k,v) in enumerate(self.buckets[index]):
            if k==key: 
                self.buckets[index][i]=(key,value)
                return
        self.buckets[index].append((key,value))

    def get(self, key: int) -> int:
        index = self.hashvalue(key)
        for(k,v) in (self.buckets[index]):
            if k==key:
                return v
        return -1

    def remove(self, key: int) -> None:
        index = self.hashvalue(key)
        for i,(k,v) in enumerate(self.buckets[index]):
            if k ==key:
                del self.buckets[index][i]
                return
        


    
# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)