# Time Complexity :O(1)
# Space Complexity :O(n) 
# Did this code successfully run on Leetcode :Yes       
# Any problem you faced while coding this :No

#Approach:- Double Hashing using Primary Hash Function as %length and Seconary as /Length .key is nothing but array index.



class MyHashMap(object):

    def __init__(self):
        self.Map=[-1 for i in range(1000)]
    
    def Hash_Fun_1(self,key):
        return(key%1000)

    def Hash_Fun_2(self,key):
        return(key//1000)
    
        

    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: None
        """
        Main=self.Hash_Fun_1(key)
        Sub=self.Hash_Fun_2(key)
        if(self.Map[Main]==-1 and Main!=0):
            self.Map[Main]=[-1 for i in range(1000)]
        elif(self.Map[Main]==-1):
            self.Map[Main]=[-1 for i in range(1001)]
        self.Map[Main][Sub]=value



    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        Main=self.Hash_Fun_1(key)
        Sub=self.Hash_Fun_2(key)
        if(self.Map[Main]==-1): 
            return -1
        return(self.Map[Main][Sub])

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        Main=self.Hash_Fun_1(key)
        Sub=self.Hash_Fun_2(key)
        if(self.Map[Main]==-1): 
            return
        self.Map[Main][Sub]=-1


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)