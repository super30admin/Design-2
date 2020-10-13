class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.buckets = 1000
        self.bucketItems=1000
        self.storage=[None for i in range(self.buckets)] #initialize an array of size buckets

    def hash1(self,key):
        index1 = key%1000
        return index1

    def hash2(self,key):
        index2 = key//1000
        return index2

    def add(self, key: int) -> None:

        index1 = self.hash1(key)
        index2 = self.hash2(key)
        if self.storage[index1] is None:
            self.storage[index1]=[None]*self.bucketItems #double hashing to store secondary indexes

        self.storage[index1][index2]=True



    def remove(self, key: int) -> None:
        index1 = self.hash1(key)
        index2 = self.hash2(key)
        if self.storage[index1] is None:
            return
        self.storage[index1][index2]=False


    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        index1 = self.hash1(key)
        index2 = self.hash2(key)
        if self.storage[index1] is None:
            return False
        return self.storage[index1][index2]


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
