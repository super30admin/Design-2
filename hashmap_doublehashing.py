class MyHashMap:

    def __init__(self):
        self.buckets=1000
        self.bucketSize = 1000
        self.stack = [None]*self.buckets
        
    def getOuterHash(self,key):
        return key%self.bucketSize
    
    def getInnerHash(self,key):
        return int(key/self.bucketSize)
    
    def put(self, key: int, value: int) -> None:
        outerhash = self.getOuterHash(key)
        if self.stack[outerhash]==None:
            if outerhash == 0:
                self.stack[outerhash] = [None]*(self.bucketSize+1)
            else:
                self.stack[outerhash] = [None]*(self.bucketSize)
                
        innerhash = self.getInnerHash(key)
        self.stack[outerhash][innerhash]=value

        

    def get(self, key: int) -> int:
        outerhash = self.getOuterHash(key)   
        if self.stack[outerhash]!=None:
            innerhash = self.getInnerHash(key)
            if self.stack[outerhash][innerhash] == None:
                print("Camehere")
                return -1
            else:
                return self.stack[outerhash][innerhash]
        
        return -1
            

        

    def remove(self, key: int) -> None:
        outerhash = self.getOuterHash(key)
        if self.stack[outerhash]!=None:
            innerhash = self.getInnerHash(key)
            self.stack[outerhash][innerhash]=None
            

        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)