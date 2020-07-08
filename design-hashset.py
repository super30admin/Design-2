class MyHashSet(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.buckets = 1000
        self.bucketItems = 1000
        self.bucketList = [False for i in range(1000)]
        self.bucketArr = [self.bucketList[:] for i in range(1000)]
    
    def getBucket(self, key):
        return key%self.buckets
    
    def getBucketItem(self, key):
        return key/self.bucketItems

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        bucket = self.getBucket(key)
        bucketItem = self.getBucketItem(key)
        self.bucketArr[bucket][bucketItem] = True
        
        

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        bucket = self.getBucket(key)
        bucketItem = self.getBucketItem(key)
        self.bucketArr[bucket][bucketItem] = False

    def contains(self, key):
        """
        Returns true if this set contains the specified element
        :type key: int
        :rtype: bool
        """
        bucket = self.getBucket(key)
        bucketItem = self.getBucketItem(key)
        return self.bucketArr[bucket][bucketItem] == True


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
