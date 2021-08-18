# // Time Complexity :O(1)
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Not sure whether correct


class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        
        """
        self.hashs=[[]]*1000
        self.bucket=1000
        self.bucketItems=1000
        
        

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        
        
        hashed_key=key%self.bucket
       
        d_hashed_key=key//self.bucketItems
        
        if(self.hashs[hashed_key]==[]):
            if hashed_key==0:
                
                self.hashs[hashed_key]=[False]*1001
            else:
                self.hashs[hashed_key]=[False]*1000
        self.hashs[hashed_key][d_hashed_key]=[key,value]
        print(self.hashs[hashed_key][d_hashed_key])
            
            
        

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        hashed_key=key%self.bucket
        
        d_hashed_key=key//self.bucketItems
        if self.hashs[hashed_key]==[]:
            return -1
        if self.hashs[hashed_key][d_hashed_key]==False:
            return -1
        else:
            a=self.hashs[hashed_key][d_hashed_key]
            return a[1]

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        hashed_key=key%self.bucket
        
        d_hashed_key=key//self.bucketItems 
        if self.hashs[hashed_key]==[]:
            return
        self.hashs[hashed_key][d_hashed_key]=False
        
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
