class MyHashMap:

    def __init__(self):
        self.k = [False] * (10**6 +1)
        self.v = [None] * (10**6 +1)
    def put(self, key: int, value: int) -> None:
        self.k[key] = True 
        self.v[key] = value 
    def get(self, key: int) -> int:
        if self.k[key]: return self.v[key]
        return -1 
    def remove(self, key: int) -> None:
        self.k[key] = False 
        self.v[key] = None
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)