# Exercise_2: Design Hashmap
# Time Complexity: O(N) for put, O(1) for get and remove
# Space Complexity: O(N), where N is the number of elements in the array
# Successful Run on Leetcode: Yes (https://leetcode.com/problems/design-hashmap/)
# Challenges: None

# Coding Approach:
# An array is used to implement a hashmap. 
# Put: If the key is greater than the length of the array, append -1 to the array until the length is equal to the key. Then set the value at the key index to the value.
# Get: Return the value at the key index if the key is less than the length of the array. Else return -1.
# Remove: If the key is less than the length of the array, set the value at the key index to -1.

class MyHashMap:

    def __init__(self):
        self.map = []

    def put(self, key: int, value: int) -> None:
        while len(self.map) <= key:
            self.map.append(-1)
        self.map[key] = value

    def get(self, key: int) -> int:
        return self.map[key] if len(self.map) > key else -1

    def remove(self, key: int) -> None:
        if len(self.map) > key:
            self.map[key] = -1
        