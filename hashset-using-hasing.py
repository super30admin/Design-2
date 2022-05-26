class MyHashSet:
    def __init__(self):
        self.arr=[None]*1000
    
    def hashfunction(self,key:int):
        return key%1000
    
    def add(self, key: int) -> None:
        
        hashkey= self.hashfunction(key)
        if self.arr[hashkey]==None:
            bucket_list=[key]
            self.arr[hashkey]=bucket_list
        else:
            for i in range(len(self.arr[hashkey])):
                 if self.arr[hashkey][i]==key:
                        return
            self.arr[hashkey].append(key)
        
    def remove(self, key: int) -> None:
        hashkey= self.hashfunction(key)
        if self.arr[hashkey]!=None:
            for i in range(len(self.arr[hashkey])):
                if self.arr[hashkey][i]==key:
                    self.arr[hashkey][i]=None       
                    return
                    


    def contains(self, key: int) -> bool:
        hashkey= self.hashfunction(key)
        if self.arr[hashkey]!=None:
            for i in range(len(self.arr[hashkey])):
                if self.arr[hashkey][i]==key:   
                    return True
        return False