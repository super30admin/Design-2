# ##https://leetcode.com/problems/design-hashset/
# ##designhashet

class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        :return: None
        """
        self.buckets=[[] for i in range (1000)]

    def hashFunction(self,key):
        """:return: hashindexvalue"""
        return key%1000

    def add(self, key: int) -> None:
        hashposition=self.hashFunction(key)
        self.buckets[hashposition].append(key)


    def remove(self, key: int) -> None:
        hashposition = self.hashFunction(key)
        self.buckets[hashposition].remove(key)

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        hashposition = self.hashFunction(key)
        if self.buckets[hashposition] is not None:
            return key in self.buckets[hashposition]
        return False


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)

#

#
# bucket=[[] for i in range (5)]
# print(bucket)

