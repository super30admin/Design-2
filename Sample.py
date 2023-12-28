# I have used a list to implement the functionalities of hashMap.
# Here list is a collection of key, value pair lists
# this approach takes time complexity of O(n) for every operation
class MyHashMap:

    def __init__(self):
        self.hash = []
        self.count = 0
        

    def put(self, key: int, value: int) -> None:
        for i in self.hash:
            if i[0] == key:
                i[1] = value
                return
        self.count += 1
        self.hash = self.hash + [[key, value]]

    def get(self, key: int) -> int:
        for i in self.hash:
            if i[0] == key:
                return i[1]
        return -1

    def remove(self, key: int) -> None:
        self.hash = [pair for pair in self.hash if pair[0] != key]
       


# Your MyHashMap object will be instantiated and called as such:
# myHashMap = MyHashMap()
# myHashMap.put(1, 1)
# myHashMap.put(2, 2)
# myHashMap.get(1)
# myHashMap.get(3)
# myHashMap.put(2, 1)
# myHashMap.get(2)
# myHashMap.remove(2)
# myHashMap.get(2)