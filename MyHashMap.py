class MyHashMap:

    # Did this code successfully run on Leetcode :Yes
    #Time Complexities - o(1)

    class Node:
        def __init__(self,key:int,val:int,nxt:'MyHashMap.Node'=None):
            self.key = key
            self.val = val
            self.nxt = nxt

    def __init__(self):
        self.bucket = 1000
        self.hashTb = [None]*self.bucket

    def hash(self,key)->int:

        return key%1000
        

    def put(self, key: int, value: int) -> None: 

        idx = self.hash(key)
        node = self.Node(key,value)
        if self.hashTb[idx]!=None:
            prev = self.hashTb[idx]
            current = prev.nxt
            while current:
                if current.key == key:
                    current.val = value
                    return
                current = current.nxt
                prev = prev.nxt
            prev.nxt = node
        else:
            self.hashTb[idx] = self.Node(-1,-1,self.Node(key,value))
        

    def get(self, key: int) -> int:
        idx = self.hash(key)
        if self.hashTb[idx] == None:
            return -1
        current = self.hashTb[idx]
        while current:
            if current.key == key:
                return current.val
            current = current.nxt

        return -1 

    def remove(self, key: int) -> None:
        idx = self.hash(key)
        if self.hashTb[idx] == None:
            return
        prev = self.hashTb[idx]
        current = prev.nxt

        while current:
            if current.key == key:
                prev.nxt = current.nxt
                current.nxt = None
                return 
            prev = current
            current = current.nxt
        return 
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)