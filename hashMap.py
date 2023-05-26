# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA


# Approach is to create a list and find the key then use it for put, get, remove operations using the list.

class MyHashMap:

    def __init__(self):
        self.d=[]
        self.val=()

    def k_pres(self, key: int) -> int:
        ct=0
        for i in self.d:
            if (i[0] == key):
                return ct
            ct+=1
        return -1

    def put(self, key: int, value: int) -> None:
        if (len(self.d)==0):
            self.d.append((key,value))
        else:
            f=self.k_pres(key)
            if (f!=-1):
                self.d[f]=(key,value)
            else:
                self.d.append((key,value))

    def get(self, key: int) -> int:
        f=self.k_pres(key)
        if (f!=-1):
            return self.d[f][1]
        else:
            return -1

    def remove(self, key: int) -> None:
        f=self.k_pres(key)
        if (f!=-1):
            return self.d.pop(f)
        else:
            return -1



# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)