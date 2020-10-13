
# // Time Complexity : O(1) - Amortized for add, remove and contains 
# // Space Complexity : O(n) Auxillary space used by array
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach:
# Using double hashing to resolve collisions

class MyHashSet(object):
    PRIME = 97
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.capacity = 100
        self.arr = [None] * self.capacity 
        self.size = 0
        self.threshold = 2.0 / 3

        
    # hash function 1
    def h1(self, x):
        return x % self.capacity
       
    # hash function 2
    def h2(self, x, i):
        return (self.h1(x) + i * (7 - x % 7)) % self.capacity
    
    def resize(self):
        """
        Double the capacity of underlying array when threshold is crossed
        """   
        self.capacity *= 2
        new_s = [None] * self.capacity
        for key in self.arr:
            if key is None or key == 'free':
                continue
            h, count = self.h1(key), 0
            while new_s[h] is not None:
                count += 1
                h = self.h2(key, count)
            new_s[h] = key
        self.arr = new_s

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        if float(self.size) / self.capacity >= self.threshold:
            self.resize()
        h, count = self.h1(key), 0
        while self.arr[h] is not None:
            if self.arr[h] == key or self.arr[h] == 'free':
                self.arr[h] = key
                return
            count += 1
            h = self.h2(key, count)
        self.arr[h] = key
        self.size += 1

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        h, count = self.h1(key), 0
        while self.arr[h] is not None:
            if self.arr[h] == key: # Mark deleted spaces as 'free'
                self.arr[h] = "free"
                self.size -= 1
                return
            count += 1
            h = self.h2(key, count)
        

    def contains(self, key):
        """
        Returns true if this set contains the specified element
        :type key: int
        :rtype: bool
        """
        h, count = self.h1(key), 0
        while self.arr[h] is not None:
            if self.arr[h] == key:
                return True
            count += 1
            h = self.h2(key, count)
        return False

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)