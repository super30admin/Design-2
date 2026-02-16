class MyHashMap:

    def __init__(self):
        self.primaryArray = [None]*1001

    def put(self, key: int, value: int) -> None:
        primaryHash = self.primaryHash(key)
        if self.primaryArray[primaryHash] == None:
            # since we have to return -1 if key doesn't exist, creating the array initialized to -1
            # this will automatically return -1 for keys that are not present
            self.primaryArray[primaryHash] = [-1]*1000
        
        secondarHash = self.secondaryHash(key)
        self.primaryArray[primaryHash][secondarHash] = value

    def get(self, key: int) -> int:
        primaryHash = self.primaryHash(key)
        if self.primaryArray[primaryHash] == None:
            return -1
        else:
            secondaryHash = self.secondaryHash(key)
            return self.primaryArray[primaryHash][secondaryHash]

    def remove(self, key: int) -> None:
        primaryHash = self.primaryHash(key)
        if self.primaryArray[primaryHash] == None:
            return
        else:
            secondaryHash = self.secondaryHash(key)
            self.primaryArray[primaryHash][secondaryHash] = -1

    def primaryHash(self, key):
        return key//1000
    
    def secondaryHash(self,key):
        return key%1000
        
    


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)