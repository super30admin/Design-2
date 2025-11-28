# I solved this problem using double hashing based on the comments i received on hashset problem
# I initially wanted to use tuple for creating the key value pair but since tuple is immutable and i have to create a new one for update i went with the list
# I did not account for collision here as the input is a constant
class MyHashMap:

    def __init__(self):
        self.primary=1000
        self.secondary=1001
        self.storage = [None]*self.primary

    def getPrimaryHash(self,key):
        return key%self.primary

    def getSecondaryHash(self,key):
        return key//self.secondary


    def put(self, key: int, value: int) -> None:
        index = self.getPrimaryHash(key)
        if self.storage[index] is None:
            self.storage[index]=[None]*self.secondary
        
        index2=self.getSecondaryHash(key)
        if self.storage[index][index2]==None:
            self.storage[index][index2] = [key, value]
        else:
            self.storage[index][index2][1] = value

    def get(self, key: int) -> int:
        index = self.getPrimaryHash(key)
        if self.storage[index] is None:
            return -1

        index2 = self.getSecondaryHash(key)
        if self.storage[index][index2] is None:
            return -1
        if self.storage[index][index2][0] == key:
            return self.storage[index][index2][1]
        return -1
        

    def remove(self, key: int) -> None:
        index = self.getPrimaryHash(key)
        if self.storage[index] is None:
            return

        index2 = self.getSecondaryHash(key)
        if self.storage[index][index2] is not None and self.storage[index][index2][0] == key:
            self.storage[index][index2] = None
        