# // Time Complexity :
# All operations O(1)
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach
# using 2d array when ever required for all unused palce it will be just 1d array
# https://leetcode.com/problems/design-hashmap/description/
class MyHashMap:

    def __init__(self):
        self.m=[None for _ in range(1001)]
    def put(self, key: int, value: int) -> None:
        h1=key%1000
        if self.m[h1] is None:
            self.m[h1]=[None]*1001     
        temp=[key,value]
        
        h2=temp[0]//1000
        self.m[h1][h2]=temp

    def get(self, key: int) -> int:
        
        if self.m[key%1000]==None:return -1
        if self.m[key%1000][key//1000] is not None:
            return self.m[key%1000][key//1000][1]
        return -1

        

    def remove(self, key: int) -> None:

        if self.m[key%1000] is not None and self.m[key%1000][key//1000] is not None:
            self.m[key%1000][key//1000]= None
        return None

        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
