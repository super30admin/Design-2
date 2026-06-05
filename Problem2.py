# Time Complexity : all O(1)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

# Your code here along with comments explaining your approach
# Although we can do this with double hasung since i already implemented it i will use #linear chaining approach here 

# if i equal divide space for  priomary array and secondary array as in double hashing  i will have to iterate over 1000 items to remove , get calls to reduce this i will increase the primary array size to 10K with a hash func to find bucket like key % 10K and then use single link lnked list as secondary data structure at max one bucket or arr location can have 100 items at max worst case scenario 100 iters to find the element which on average is still O(1) comparef to n of 10M



class MyHashMap:

    class Node:
        def __init__(self,key,val,ptr=None):
            self.key=key
            self.val=val
            self.next=ptr

    def __init__(self):
        self.primSize = 10000
        self.arr = [None] * self.primSize
    
    def find(self,key,ptr) -> Node:
        prev=ptr
        while  prev.next and prev.next.key != key:
            prev = prev.next
        return prev

    def hash(self,key):
        return key % 10000

    def put(self, key: int, value: int) -> None:

        idx = self.hash(key)

        if not self.arr[idx]:
            dummy = self.Node(-1,-1)
            self.arr[idx] = dummy
        
        """important this i may make mitake i added dummy in if but both the path after that and if already a chain exists both end up here so i should call find here just after writinf if in the same mood of new chain with just dummy i can't just add to dummy"""

        prev = self.find(key,self.arr[idx])

        if prev.next:
            """if prev.next is not null means we found the key in the # chain since while loop runs till prev.next has the key or prev.next is null"""
            prev.next.val = value
            return
        
        # here prev.next is None means key not found add as a new node in the end
        prev.next = self.Node(key,value)
        return
        
    def get(self, key: int) -> int:
        idx = self.hash(key)
        if not self.arr[idx]:
            return -1
        prev = self.find(key,self.arr[idx])
        if not prev.next:
            return -1
        return prev.next.val
        

    def remove(self, key: int) -> None:
        idx = self.hash(key)
        if not self.arr[idx]:
            return
        prev = self.find(key,self.arr[idx])
        if not prev.next:
            return
        curr = prev.next
        prev.next = prev.next.next
        curr.next = None
        return
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
