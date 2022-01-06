class MyHashSet:

    def __init__(self):
        
        self.buckets=1000
        self.bucketItems=1000
        self.storage= [None]*1000
        
    def _bucket(self,key):
        return key% self.buckets
    
    def _bucketItem(self,key):
        return int(key/self.bucketItems)
    
        
    def add(self, key: int) -> None:
        bucket = self._bucket(key)
        bucketItem = self._bucketItem(key)
        
        if self.storage[bucket]==None:
            if bucket==0:
                self.storage[bucket] = [None]*(self.bucketItems+1)
            else:
                self.storage[bucket] = [None]*(self.bucketItems)
                    
        self.storage[bucket][bucketItem]=True
        

    def remove(self, key: int) -> None:
        bucket = self._bucket(key)
        bucketItem = self._bucketItem(key)
        
        if self.storage[bucket]==None:
            return
        else:
            self.storage[bucket][bucketItem]=False
        
        

    def contains(self, key: int) -> bool:
        bucket = self._bucket(key)
        bucketItem = self._bucketItem(key)
        
        if self.storage[bucket]==None:
            return False
        else:
            return self.storage[bucket][bucketItem]
        
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)