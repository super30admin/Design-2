# Time Complexity :
# Space Complexity :
# Did this code successfully run on Leetcode :
# Any problem you faced while coding this :

# Your code here along with comments explaining your approach
class MyHashSet(object):

    def __init__(self):
        self.bucketNum = 1000
        self.bucketArray = [False] * self.bucketNum

    def bucketIndexHashing(self, key):
        return key % self.bucketNum

    def nestedBucketIndexHashing(self, key):
        return key / self.bucketNum

    def add(self, key):
        bucketIdx = self.bucketIndexHashing(key)
        nestedBucketIdx = self.nestedBucketIndexHashing(key)

        if self.bucketArray[bucketIdx] == False:
            self.bucketArray[bucketIdx] = [False] * self.bucketNum

        self.bucketArray[bucketIdx][nestedBucketIdx] = True

    def remove(self, key):
        bucketIdx = self.bucketIndexHashing(key)
        nestedBucketIdx = self.nestedBucketIndexHashing(key)

        if self.bucketArray[bucketIdx]:
            self.bucketArray[bucketIdx][nestedBucketIdx] = False

    def contains(self, key):
        bucketIdx = self.bucketIndexHashing(key)
        nestedBucketIdx = self.nestedBucketIndexHashing(key)

        return self.bucketArray[bucketIdx] and self.bucketArray[bucketIdx][nestedBucketIdx]


# Your MyHashSet object will be instantiated and called as such:
hashSet = MyHashSet()
hashSet.add(6)
hashSet.remove(4)
hashSet.remove(6)
hashSet.add(17)
print hashSet.bucketArray
print hashSet.contains(14)
hashSet.add(14)
hashSet.remove(17)
hashSet.add(14)
hashSet.add(14)
hashSet.add(18)
hashSet.add(14)
