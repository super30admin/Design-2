
#Did this code successfully run on Leetcode :Yes
#Any problem you faced while coding this : No
class MyHashSet(object):
    
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.m = 1000
        self.table = [[] for i in range(self.m)]
        

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        hashcode1 = key%self.m
        hashcode2 = key//self.m

        if not self.table[hashcode1]:
            if hashcode1==0:
                self.table[hashcode1]  = [False for i in range(1001)]
            else:
                self.table[hashcode1]  = [False for i in range(1000)]
                
        self.table[hashcode1][hashcode2]=True
       

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        hashcode1 = key%self.m
        hashcode2 = key//self.m
        print(key)
        if not self.table[hashcode1]:
            return
        else:
            self.table[hashcode1][hashcode2] = False

    def contains(self, key):
        """
        Returns true if this set contains the specified element
        :type key: int
        :rtype: bool
        """
        hashcode1 = key%self.m
        hashcode2 = key//self.m
        if not self.table[hashcode1]:
            return False
        else:
            return self.table[hashcode1][hashcode2]