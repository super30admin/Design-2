#Time Complexity - O(1)
#Space Complexity - O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No


class MyHashMap:
    def __init__(self):
        self.hashmap = {}

    def put(self, key: int, value: int) -> None:
        self.hashmap[key] = value
        

    def get(self, key: int) -> int:
        if key not in self.hashmap:
            return -1
        else:
            return self.hashmap[key]
        

    def remove(self, key: int) -> None:
        if key in self.hashmap:
            self.hashmap.pop(key)


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)





