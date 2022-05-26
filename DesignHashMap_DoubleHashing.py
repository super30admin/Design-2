class MyHashMap(object):

    def __init__(self):
        self.bucket=1000
        self.bucketItems=1000
        self.table=[None]*self.bucket
       
    def hashFunction1(self,key):
        return key%self.bucket
    
    def hashFunction2(self,key):
        return key//self.bucketItems
    
    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: None
        """
        primaryListIndex=self.hashFunction1(key)
        secondaryListIndex=self.hashFunction2(key)
        if self.table[primaryListIndex] is not None:
            if self.table[primaryListIndex][secondaryListIndex] is not None:
                self.table[primaryListIndex][secondaryListIndex]=value
            else:
                self.table[primaryListIndex][secondaryListIndex]=value
        else:
            if primaryListIndex == 0:
                self.table[primaryListIndex]=[None]*(self.bucketItems+1)
                self.table[primaryListIndex][secondaryListIndex]=value
            else:
                self.table[primaryListIndex]=[None]*self.bucketItems
                self.table[primaryListIndex][secondaryListIndex]=value
        
            

    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        primaryListIndex=self.hashFunction1(key)
        secondaryListIndex=self.hashFunction2(key)
        if self.table[primaryListIndex] is None:
            return -1
        else:
            if self.table[primaryListIndex][secondaryListIndex] is not None:
                if self.table[primaryListIndex][secondaryListIndex] is not None :
                    return self.table[primaryListIndex][secondaryListIndex]
                else:
                    return -1
            else:
                return -1
        

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        primaryListIndex=self.hashFunction1(key)
        secondaryListIndex=self.hashFunction2(key)
        if self.table[primaryListIndex] is not None:
            if self.table[primaryListIndex][secondaryListIndex] is not None:
                self.table[primaryListIndex][secondaryListIndex]=None
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
