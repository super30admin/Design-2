#Time Complexity: All operations takes O(n)
#Space Complexity: O(10^6)
#Successfully ran on leetcode
#Not working for key%10000(IndexError raise)

class MyHashMap:

    def __init__(self):
        self.map = [None]*1000000

    def put(self, key: int, value: int) -> None:
        index = self.hash1(key)
        if self.map[index] == None:
            self.map[index] = []
        if self.get(key) == -1:
            self.map[index].append([key,value])
        else:
            for i in range(len(self.map[index])):
                if self.map[index][i][0] == key:
                    self.map[index][i][1] = value
                

    def get(self, key: int) -> int:
        index = self.hash1(key)
        if self.map[index] == None:
            return -1
        else:
            for i in range(len(self.map[index])):
                if self.map[index][i][0] == key:
                    return self.map[index][i][1]
            return -1

    def remove(self, key: int) -> None:
        index = self.hash1(key)
        if self.map[index] != None:
            for i in range(len(self.map[index])):
                if self.map[index][i][0] == key:
                    self.map[index].pop(i)

    def hash1(self,key:int) -> int:
        return key%1000000
    
# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)