class MyHashMap:

    def __init__(self):
        #1001* 1 + a1000*999  lisst oflist having hash function will map to exact position/index so insert delete get in O(1) time.
        self.hashmap = []
        for i in range(1000):
            if i == 0:
                self.hashmap.append([-1]*1001)
            else:
                self.hashmap.append([-1]*1000)

    def get_prim_index(self, key):
        return key%1000
    
    def get_sec_index(self, key):
        return key//1000

    def put(self, key: int, value: int) -> None:
        prim_index = self.get_prim_index(key)
        sec_index = self.get_sec_index(key)
        self.hashmap[prim_index][sec_index]=value                                                

    def get(self, key: int) -> int:
        prim_index = self.get_prim_index(key)
        sec_index = self.get_sec_index(key)
        return self.hashmap[prim_index][sec_index]

    def remove(self, key: int) -> None:
        prim_index = self.get_prim_index(key)
        sec_index = self.get_sec_index(key)
        self.hashmap[prim_index][sec_index]=-1


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
