# Time Complexity : O(1)
# Space Complexity : O(N) N=no of elements in the hashset
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No 


# Your code here along with comments explaining your approach

class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        
        self.k=997
        self.hash=[[] for _ in range(self.k)]   
        
    def getHashValue(self,key):
        
        return key%self.k

    def add(self, key: int) -> None:
        
        hashVal=self.getHashValue(key)
        
        if key not in self.hash[hashVal]:
            self.hash[hashVal].append(key)
        
    def remove(self, key: int) -> None:
        
        hashVal=self.getHashValue(key)
        
        for index,element in enumerate(self.hash[hashVal]):
            
            if element==key:
                self.hash[hashVal].remove(key)
                break
    
    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        
        hashVal=self.getHashValue(key)
        
        for index,element in enumerate(self.hash[hashVal]):
            
            if element==key:
                return True
        
        return False
        
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)