
#Did this code successfully run on Leetcode :Yes
#Any problem you faced while coding this : No

class MyHashSet:
    
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.table = [False]*1000001  #since key value range is mentioned , assinging array with numbers

    def add(self, key: int) -> None:
        #Timecomplexity : O(1)
        self.table[key] = True   #Add means making that index to True
        

    def remove(self, key: int) -> None:
        #Timecomplexity : O(1)
        self.table[key]=False   
        

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        #Timecomplexity : O(1)
        return self.table[key]
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)