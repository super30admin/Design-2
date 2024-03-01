# Time Complexity : O(1) for all operations
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class MyHashMap:

    def __init__(self):
        self.size = 1000
        self.bucketlist = [[] for _ in range(self.size)]

    def hashfun(self, key):
        return key%self.size

    def put(self, key: int, value: int) -> None:
        hashval = self.hashfun(key)
        bucket = self.bucketlist[hashval]
        for idx,pair in enumerate(bucket):
            if pair[0]==key:
                bucket[idx]=(key,value)
                return 
        bucket.append((key, value))

    def get(self, key: int) -> int:
        hashval = self.hashfun(key)
        bucket = self.bucketlist[hashval]
        for pair in bucket:
            if pair[0]==key:
                return pair[1]
        return -1
        

    def remove(self, key: int) -> None:
        hashval = self.hashfun(key)
        bucket = self.bucketlist[hashval]
        for idx,pair in enumerate(bucket):
            if pair[0]==key:
                del bucket[idx]
                return
        

