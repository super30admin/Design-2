"""
Time Complexity
calculate_hash : O(1)
add : o(1)
remove : o(1)
contains: o(1)

Space Complexity
calculate_hash : o(1)
add: O(1)
remove: O(n)
contains: O(n)

"""
class MyHashSet:

    def __init__(self):
        self.size = 10
        self.table = [None]* self.size

    def calculate_hash(self,key):
        return key % self.size         

    def add(self, key) -> None:
        hv = self.calculate_hash(key)
        if self.table[hv] == None:
            self.table[hv] = [key]
        else:
            self.table[hv].append(key)
        

    def remove(self, key) -> None:
        hv = self.calculate_hash(key)
        if self.table[hv] != None:
            while key in self.table[hv]:
                self.table[hv].remove(key)
        

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        hv = self.calculate_hash(key)
        if self.table[hv] != None:
            if key in self.table[hv]:
                return True
            else:
                return False


# Your MyHashSet object will be instantiated and called as such:
hashSet = MyHashSet()
hashSet.add(1)
hashSet.add(2) 
hashSet.contains(1)
hashSet.contains(3)
hashSet.add(2) 
hashSet.contains(2)
hashSet.remove(2)
hashSet.contains(2)