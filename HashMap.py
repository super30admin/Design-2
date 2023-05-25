class MyHashMap:

    def __init__(self):
        self.arr = [None] * 1000

    def put(self, key: int, value: int) -> None:
        firstHash = key % 1000
        secHash = key // 1000

        if self.arr[firstHash] is None:
            self.arr[firstHash] = [None] * 1001

        if self.arr[firstHash][secHash] is None:
            self.arr[firstHash][secHash] = []

        self.arr[firstHash][secHash] = value

    def get(self, key: int) -> int:
        firstHash = key % 1000
        secHash = key // 1000

        if self.arr[firstHash] is None or self.arr[firstHash][secHash] is None:
            return -1

        return self.arr[firstHash][secHash]

    def remove(self, key: int) -> None:
        firstHash = key % 1000
        secHash = key // 1000

        if self.arr[firstHash] is not None and self.arr[firstHash][secHash] is not None:
            self.arr[firstHash][secHash] = None



# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)