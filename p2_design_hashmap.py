class MyHashMap:
    """
        Time Compleity:
            put: O(1)
            get: O(1)
            remove: O(1)
        
        Approach:
            - We will take an array the size of the square root of 1 Million (1000)
            To save on space
            - To avoid collision we will create a list of 1000 at a particular index
                - The list will have all the values having equal modulo value 
                    - For eg: At 0th index we will have 0, 1000, 2000, --- 1000000
                - For Oth index we will have an extra index since we will have 
                an extra value at oth index
    """

    def __init__(self):
        self.col = 1000
        self.map = [None] * self.col

    def put(self, key: int, value: int) -> None:
        ind = int(key % self.col)
        if not self.map[ind]:
            if ind % self.col == 0:
                self.map[ind] = [None] * (self.col + 1)
            else:
                self.map[ind] = [None] * self.col
        sub_ind = int(key / self.col)
        self.map[ind][sub_ind] = value

    def get(self, key: int) -> int:
        ind = int(key % self.col)
        sub_ind = int(key / self.col)
        if self.map[ind]:
            if self.map[ind][sub_ind] != None:
                return self.map[ind][sub_ind]
        return -1

    def remove(self, key: int) -> None:
        ind = int(key % self.col)
        sub_ind = int(key / self.col)
        if self.map[ind]:
            self.map[ind][sub_ind] = None


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)