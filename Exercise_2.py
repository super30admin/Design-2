"""
Problem - 5

Time Complexity - 
hash1,hash2 - O(1)
get - O(1)
put - O(1)
remove - O(1)

Space Complexity - worst case - O(1000000)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Creating a main array of 1000, then performing double hashing as discussed in class
then creatimg nested arrays at locations to store value
this implementation gives constant time complexity for each operation

"""

class MyHashMap:

    def __init__(self):
        self.mainarr=[None for _ in range(1000)]
        self.maxnum=None

    def hash1(self,key):
        return key % 1000

    def hash2(self,key):
        return key // 1000

    def put(self, key, value):
        hash1key=self.hash1(key)
        hash2key=self.hash2(key)
        if key==1000000:
            self.maxnum=value
        else:
            if not self.mainarr[hash1key]:
                self.mainarr[hash1key]=[None for _ in range(1000)]
            self.mainarr[hash1key][hash2key]=value

    def get(self, key):
        hash1key=self.hash1(key)
        hash2key=self.hash2(key)
        if key==1000000:
            if self.maxnum!=None:
                return self.maxnum
            else:
                return -1
        elif self.mainarr[hash1key]:
            if self.mainarr[hash1key][hash2key]!=None:
                return self.mainarr[hash1key][hash2key]
        return -1

    def remove(self, key):
        hash1key=self.hash1(key)
        hash2key=self.hash2(key)
        if key==1000000:
            self.maxnum=None
        elif self.mainarr[hash1key]:
            if self.mainarr[hash1key][hash2key]!=None:
                self.mainarr[hash1key][hash2key]=None

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)