'''
Time Complexity : O(1) since we are using the double hashing alongwith primary and secondary lists to store values
Space Complexity : O(n) since we are using two lists to implement this function
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No issues faced

'''

class MyHashMap:
    def __init__(self):
        self.maps = [[-1] * 1001 for i in range(1001)]

    def hash(self,key):
        pri = key % len(self.maps)
        sec = key // len(self.maps)
        return [pri,sec]

    def put(self, key: int, value: int) -> None:
        keys = self.hash(key)
        self.maps[keys[0]][keys[1]] = value
        return

    def get(self, key: int) -> int:
        keys = self.hash(key)
        return self.maps[keys[0]][keys[1]]

    def remove(self, key: int) -> None:
        keys = self.hash(key)
        self.maps[keys[0]][keys[1]] = -1
        return


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)