# Time Complexity : O(1)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
# Your code here along with comments explaining your approach I used bucket approach in-case of the collisions.
# let's randomly define a length of the hashset (primenumber to avoid collisions)
# Here we used basic hash function that is modulo.
# hash-key function returns the value of the index where the key should be in the hashset.
# If 2 keys have the same index then there is a collision, so we make a list to every index and append every item in that key.

class MyHashSet:
    def __init__(self):
        self.hashsetlength = 199
        self.hashset = [[]] * self.hashsetlength

    def hashkey(self, key):
        return key % self.hashsetlength

    def add(self, key: int) -> None:
        index = self.hashkey(key)
        if not self.hashset[index]:
            self.hashset[index] = [key]
        else:
            self.hashset[index].append(key)

    def remove(self, key: int) -> None:
        index = self.hashkey(key)
        if key in self.hashset[index]:
            while key in self.hashset[index]:
                self.hashset[index].remove(key)

    def contains(self, key: int) -> bool:
        index = self.hashkey(key)
        return key in self.hashset[index]


# Your MyHashSet object will be instantiated and called as such:
obj = MyHashSet()
obj.add(1)
obj.add(2)
print(obj.contains(1))
print(obj.contains(3))
obj.add(2)
print(obj.contains(2))
obj.remove(2)
print(obj.contains(2))

