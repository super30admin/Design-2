'''
We use an array of size 10**3 for the hashmap along with double hashing to store the key values in a 
tabular format.

The first hashfunction is // operation to get first 3 digits of the key.
Second hash function is % to get the last 3 digits of the key

The hashMap acts as a row, and we only create the column on demand to not occupy extra space
than what is required.
'''
class MyHashMap:

    def __init__(self):
        self.hashMap = [-1 for _ in range(1000+1)]

    def put(self, key: int, value: int) -> None:
        row = key // 1000
        col = key % 1000
        
        if self.hashMap[row] == -1:
            self.hashMap[row] = [-1 for _ in range(1000)]
        self.hashMap[row][col] = value

    def get(self, key: int) -> int:
        row = key // 1000
        col = key % 1000
        
        if self.hashMap[row] == -1:
            return self.hashMap[row]
        
        return self.hashMap[row][col]

    def remove(self, key: int) -> None:
        row = key // 1000
        col = key % 1000
        if self.hashMap[row] != -1:
            self.hashMap[row][col] = -1
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)