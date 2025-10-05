# Time Complexity : o(n) in worst case
# Space Complexity :o(n) in worst case
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA


# Your code here along with comments explaining your approach
class MyHashSet:

    def __init__(self):
        
        self.buckets=1000
        self.primarybucket = [False]*self.buckets
        self.secondarybucket=[False]*self.buckets
    def primaryhash(self, key):
            return key%self.buckets
    def seconadaryhash(self, key):
            return key//self.buckets
    def add(self, key: int) -> None:
        
        primaryindex=self.primaryhash(key)
        if self.primarybucket[primaryindex] is False:
            if primaryindex ==0:
                self.primarybucket[primaryindex]=[False]*1001
            else:
                self.primarybucket[primaryindex]=[False]*1000
        secondaryindex=self.seconadaryhash(key)
        self.primarybucket[primaryindex][secondaryindex]= True
        

    def remove(self, key: int) -> None:
        primaryindex=self.primaryhash(key)
        secondaryindex=self.seconadaryhash(key)
        if self.primarybucket[primaryindex] is False:
            return False
        else:
            self.primarybucket[primaryindex][secondaryindex]= False

    def contains(self, key: int) -> bool:
        primaryindex=self.primaryhash(key)
        secondaryindex=self.seconadaryhash(key)
        if self.primarybucket[primaryindex] is False:
            return False
        return self.primarybucket[primaryindex][secondaryindex]
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)