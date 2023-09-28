# Time Complexity : Ammortized - O(1) | Worst Case - O(n)
# Space Complexity : O(n), where n is the size of arr
# Did this code successfully run on Leetcode : Yes , LC 706
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
class MyHashMap:

    def __init__(self):
        self.size = 2069 #Prime Number
        self.arr = [[] for _ in range(2069)]

    def put(self, key: int, value: int) -> None:
        indx = key % (self.size)

        for item in self.arr[indx]:
            k,v = item
            if k == key:
                self.arr[indx].remove((k,v))
        self.arr[indx].append((key,value))

    def get(self, key: int) -> int:
        indx = key % (self.size)
        
        for k,v in self.arr[indx]:
            if k == key:
                return v
        return -1

    def remove(self, key: int) -> None:
        indx = key % (self.size)

        for items in self.arr[indx]:
            k, v = items
            if k == key:
                self.arr[indx].remove((k,v))

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)