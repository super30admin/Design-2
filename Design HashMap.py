class MyHashMap:

    def __init__(self):
        self.bucket=1000
        self.bucketItem=1000
        self.storage=[None]*self.bucket
    def hash1(self,key:int)->int:
        return key%1000
    def hash2(self,key:int)->int:
        return key//1000
    def put(self, key: int, value: int) -> None:
        bucket=self.hash1(key)
        bucketItem=self.hash2(key)
        if self.storage[bucket] is  None:
            if bucket==0:
                self.storage[bucket]=[None]*(self.bucketItem+1)
            else:
                self.storage[bucket]=[None]*(self.bucketItem)
        self.storage[bucket][bucketItem]=value
    def get(self, key: int) -> int:
        bucket=self.hash1(key)
        bucketItem=self.hash2(key)
        if self.storage[bucket]==None:
            return -1
        value=self.storage[bucket][bucketItem]
        if value is not None:
            return value
        else:
            return -1
    def remove(self, key: int) -> None:
        bucket=self.hash1(key)
        bucketItem=self.hash2(key)
        if self.storage[bucket]==None:
            return
        self.storage[bucket][bucketItem]=None
        