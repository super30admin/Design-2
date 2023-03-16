class MyHashMap:

    def __init__(self):
        self.map={}

    def put(self, key: int, value: int) -> None:
        self.map.update({key:value})
        

    def get(self, key: int) -> int:
        x=self.map.keys()
        if key in x:
            return self.map[key]
        else:
            return (-1)

    def remove(self, key: int) -> None:
        x=self.map.keys()
        if key in x:
            del self.map[key]


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)