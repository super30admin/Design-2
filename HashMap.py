# // Time Complexity : O(1)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode :YES
# // Any problem you faced while coding this :NO


# // Your code here along with comments explaining your approach

class MyHashMap:

    def __init__(self):
        self.n=pow(10,6)+1
        self.li=[-1]*self.n
    def hash(self,key):
        return key % self.n
    def put(self, key: int, value: int) -> None:
        self.li[self.hash(key)]=value
    def get(self, key: int) -> int:
        return self.li[self.hash(key)]
    def remove(self, key: int) -> None:
        self.li[self.hash(key)]=-1

        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)