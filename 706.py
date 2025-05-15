from collections import deque
class MyHashMap:

    def __init__(self):
        self.bucketSize = 1000
        self.buckets = [deque() for _ in range(self.bucketSize)]
    
    def getBucketIndex(self, key):
        return key % self.bucketSize
    
    def put(self, key: int, value: int) -> None:
        idx,i = self.getIndex(key)
        if i == -1:
            idx = self.getBucketIndex(key)
        else: # key exist in the map
            self.remove(key)
        self.buckets[idx].append((key,value))

    def getIndex(self,key):
        idx = self.getBucketIndex(key)
        i = 0
        for e in self.buckets[idx]:
            if e[0] == key:
                return (idx,i)
            i += 1
        return (-1,-1)
        
    def get(self, key: int) -> int:
        idx,i = self.getIndex(key)
        return -1 if i == -1 else self.buckets[idx][i][1]

    def remove(self, key: int) -> None:
        idx,i = self.getIndex(key)
        if i == -1: # key doesnt exist in the map
            return
        else:
            del self.buckets[idx][i]

