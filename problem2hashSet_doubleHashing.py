'''
Leet Code : https://leetcode.com/problems/design-hashset/submissions/
'''
class MyHashSet:

    def __init__(self):
        
        # given constraint is key < 10^6
        # our list will be of size sqrt(10^6) = 1000
        
        self.list = [None] * 1000
        self.innerList = None
        
    def hashList(self,key):
        return key%1000
    
    def hashInnerList(self,key):
        return key//1000
    
    def add(self, key: int) -> None:
        
        # 1. Coumpute hashList
        indexList = self.hashList(key)
        
        # 2. Perform check if list[indexList] == None
        if self.list[indexList]== None:
            
            # Boundary case, insert 1,000,000 i.e. 10^6            
            if indexList == 0:
                self.innerList = [None] * (1000+1)
            else:    
                # 2.1 Allocate innerList inside the list[index]
                self.innerList = [None] * 1000
            
            self.list[indexList] =  self.innerList
            
        # 3 Compute the hashInnerList for the key
        indexInnerList = self.hashInnerList(key)
            
        # 2.3 Set list[indexList][indexInnerList] == True if the value is None
        if self.list[indexList][indexInnerList] == None:
            self.list[indexList][indexInnerList] = True
        
        return self.list[indexList][indexInnerList]
            
    def remove(self, key: int) -> None:
        
        # 1. Coumpute hashList
        indexList = self.hashList(key)
        
        if self.list[indexList] != None:
            # 2. Compute the hashInnerList for the key
            indexInnerList = self.hashInnerList(key)
            
            if self.list[indexList][indexInnerList] == True:
                self.list[indexList][indexInnerList] = None
        
    def contains(self, key: int) -> bool:
        # 1. Coumpute hashList
        indexList = self.hashList(key)
        
        if self.list[indexList] == None:
            return False
        
        # 2. Compute the hashInnerList for the key
        indexInnerList = self.hashInnerList(key)
        
        if self.list[indexList][indexInnerList] == True:
            return True
        
        else:
            return False

obj = MyHashSet()
obj.add(100)
print(obj.list)

'''
Let say we want to insert key as 1000000
indexList = 1000000%1000 = 0
indexInnerList = 1000000/1000 = 1000

To solve this case, your size of innerList should be "currentSize"+1
i.e. in this case it should be 1000+1 = 1001
---------------------------------------------------
Example 2:
insert key as 100
list size 10 therefore index from 0 to 9

indexList = 100%10 = 0
indexInnerList = 100/10 = 10

But we dont have cell list[0][10].
Again for such cases size of inner list at 0th index should be currentSize + 1
i.e 10 + 1 = 11
Now we will have index from 0 to 10 index and can store at location list[0][10]
------------------------------------------------------

Generalization:

maximum key = x
size = sqrt(x)

at 0th index
inner_list will be sqrt(x)+1 size

'''