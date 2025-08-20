'''
# Time Complexity : 
    O(1) for push, get, remove  
# Space Complexity :
    O(N) , N = 10e6  
# Did this code successfully run on Leetcode :
    - yes
# Any problem you faced while coding this :
    - Yes
    - In get(), last return, I made mistake of checking with 0, when 
    I wrote return self.buckets[h1][h2] if self.buckets[h1][h2]  else -1
    instead of checking with None. 
    - Assumed, if self.buckets[h1][h2] return False only when it's None (forgot about int 0)

'''


class MyHashMap:

    def __init__(self):
        self.primitive_buckets = 1000  
        self.secondary_buckets = 1000
        self.buckets = [None]*(self.primitive_buckets + 1 ) # edge case - 10e6

    def __hashKey(self,key):
        # Double hashing
        return key//self.primitive_buckets, key%self.secondary_buckets

    def put(self, key: int, value: int) -> None:
        h1, h2 = self.__hashKey(key) # 0, 1
        if self.buckets[h1] is None:
            if h1==1000:
                self.buckets[h1] = value
            else:
                self.buckets[h1] = [None]*self.secondary_buckets # Initialize secondary DS - array
        
        if h1==1000:
            self.buckets[h1]=value
        else:
            self.buckets[h1][h2]=value

    def get(self, key: int) -> int:
        h1, h2 = self.__hashKey(key)
        if self.buckets[h1] is None:
            return -1
        else:
            if h1==1000:
                return self.buckets[h1]
            else:
                return self.buckets[h1][h2] if self.buckets[h1][h2] is not None else -1

    def remove(self, key: int) -> None:
        # check if key is present in the map
        if self.get(key)!=-1:
            h1, h2 = self.__hashKey(key)
            if h1==1000:
                self.buckets[h1]=None
            else:
                self.buckets[h1][h2]=None

        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)