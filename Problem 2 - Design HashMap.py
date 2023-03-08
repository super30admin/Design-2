# Time Complexity : O(1) i.e. worst case O(100)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

class Node:
    def __init__(self,key,val):
        self.key = key
        self.val = val
        self.next = None


class MyHashMap:

    def __init__(self):
        self.hashmap = []
        for i in range(10000):
            self.hashmap.append(None)

    def hash(self,key):
        return key % 10000

    def search(self,head,key):
        prev = head
        cur = head.next
        while(prev.next != None and cur.key != key):
            prev = cur
            cur = cur.next
        return prev


    def put(self, key: int, value: int) -> None:
        idx = self.hash(key)
        if self.hashmap[idx] == None:
            self.hashmap[idx] = Node(-1,-1)

        prev = self.search(self.hashmap[idx],key)
        if prev.next == None:
            prev.next = Node(key,value)
        else:
            prev.next.val = value

    def get(self, key: int) -> int:
        idx = self.hash(key)
        if self.hashmap[idx] == None:
            return -1
        prev = self.search(self.hashmap[idx],key)
        if prev.next == None:
            return -1
        else:
            return prev.next.val
        

    def remove(self, key: int) -> None:
        idx = self.hash(key)
        if self.hashmap[idx] == None:
            return
        
        prev = self.search(self.hashmap[idx],key)
        if prev.next == None:
            return
        else:
            prev.next = prev.next.next



# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)