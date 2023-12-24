class MyHashMap:

    def __init__(self):
        self.hash_map = []

    def put(self, key: int, value: int) -> None:
        # first will check if key is already exist 
        for map_set in self.hash_map:
            if map_set[0] == key:
                map_set[1] = value
                return
        # insert key value if key is not already exist
        self.hash_map.append([key,value])
        
    def get(self, key: int) -> int:
        # return value of corresponding key if key exist in map
        for map_set in self.hash_map:
            if map_set[0] == key:
                return map_set[1]
        # return -1 if key does not exixt in map
        return -1
        
    def remove(self, key: int) -> None:
        # remove key value pair from map
        for map_set in self.hash_map:
            if map_set[0] == key:
                self.hash_map.remove(map_set)
                return


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)