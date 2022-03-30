# Time Complexity : O(1) all operations
# Space Complexity : O(N) for N is the Max Key value 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class MyHashSet:

    def __init__(self):
        # given 0 <= key <= 10^6 So select max size 10^3 as an optimal value
        self.max = 1000
        # init primary array that will contain None initially,
        # and then refrence to the secondary array. 
        # Using Double Hash Function Method.
        self.arr = [None for _ in range(self.max)]
        
    
    # O(1)
    def add(self, key: int) -> None:
        hash_1 = key % self.max # First hash value
        hash_2 = int(key / self.max) # Second hash value
        if self.arr[hash_1] is None:
            # Spl case: if 10^6 % 1000 = 0, then 10^6/1000 = 1000. but last index is 999
            if hash_1 == 0:
                self.arr[hash_1] = [None for _ in range(self.max+1)]
            else:
                self.arr[hash_1] = [None for _ in range(self.max)]
        
        self.arr[hash_1][hash_2] = True

    # O(1)
    def remove(self, key: int) -> None:
        hash_1 = key % self.max # First hash value
        hash_2 = int(key / self.max) # Second hash value
        if self.arr[hash_1] is not None:
            self.arr[hash_1][hash_2] = False

    # O(1)
    def contains(self, key: int) -> bool:
        hash_1 = key % self.max # First hash value
        hash_2 = int(key / self.max) # Second hash value
        if not self.arr[hash_1]:
            return False
        if self.arr[hash_1][hash_2]:
            return True
        else:
            return False        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)