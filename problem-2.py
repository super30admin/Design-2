class MyHashMap:

    def __init__(self):
        self.hashmap = {}

    def put(self, key: int, value: int) -> None:
         self.hashmap[key]= value

    def get(self, key: int) -> int:

        return self.hashmap.get(key, 0)

    def remove(self, key: int) -> None:
        del self.hashmap[key]



#Your MyHashMap object will be instantiated and called as such:
obj = MyHashMap()
obj.put("Teja",1)
param_2 = obj.get("Teja")
print(param_2)
obj.remove("Teja")