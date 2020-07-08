class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.list_HashSet=[]

    def add(self, key) :
        if key not in self.list_HashSet:
            self.list_HashSet.append(key)
            print("Element added in Hashset...Current HashSet")
            print(self.list_HashSet)

    def remove(self, key) :
        if not self.list_HashSet:
            print("HashSet Empty")
        elif key in self.list_HashSet:
            self.list_HashSet.remove(key)
            print("Element removed from Hashset...Current HashSet")
            print(self.list_HashSet)
        else:
            print("key not found")
            

    def contains(self, key) :
        """
        Returns true if this set contains the specified element
        """
        return key in self.list_HashSet
        


# Your MyHashSet object will be instantiated and called as such:
obj = MyHashSet()
obj.add(1)
obj.add(2)
obj.add(1)
obj.add(3)
pop_element=2
print("Element to be removed")
print(pop_element)
obj.remove(pop_element)
param_3 = obj.contains(3)
print("If element present in hashset??")
print(param_3)