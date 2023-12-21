# Time Complexity : O(K) where k represents the time for any bucket with largest amount of collisions otherwise assuming there are no collisions this would be O(1)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# This hashset implementation is utilizing seperate chaining where each bucket in the hashset is a dynamic list and can store any key value pair as a tupule, in any of our operations 
# we calculate the the bucket index first and then once this is determined we can execute the operation on the list in that given bucket

class MyHashMap:

    def __init__(self):
        self.size = 500
        self.buckets = [[] for x in range(self.size)]
    

    def put(self, key: int, value: int) -> None:
        index = key % self.size
        for i in range(len(self.buckets[index])):
            pair = self.bucket[index][i]
            if pair[0] == key:
                self.buckets[index][i] = (key, value)
                return
        self.buckets[index].append((key,value))

    def get(self, key: int) -> int:
        index = key % self.size
        for pair in self.buckets[index]:
            if pair[0] == key:
                return pair[1]
        return None

    def remove(self, key: int) -> None:
        index = key % self.size
        for i in range(len(self.buckets[index])):
            pair = self.bucket[index][i]
            if pair[0] == key:
                del self.buckets[index][i]
                return


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)