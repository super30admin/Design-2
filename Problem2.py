# Time Complexity  : O(1) for all operations
# Space Complexity : O(n) fixed size, at most 1000 * 1001 slots allocated but keeps gwoing whenever values are entered

# We create a storage list of 1000 slots, each slot starts as None and only builds  an inner list of 1001 values when a key needs it
# Every key maps to an exact position using key%1000 for outer index and key//1000 for inner index
# At that position, put stores the value, remove sets -1, get returns whatever is there (-1 naturally means not found)

class MyHashMap:
    def __init__(self):
        self.hash1 = 1000                               # size of outer storage array
        self.hash2 = 1000                               # size of inner bucket array
        self.storage = [None] * self.hash1              # outer array, all slots start as None

    def primary(self, key):
        return key % self.hash1                         # maps key to outer index (0-999)

    def secondary(self, key):
        return key // self.hash2                        # maps key to inner index (0-1000)

    def put(self, key, value):
        i = self.primary(key)                           # find outer index for this key
        if self.storage[i] is None:                     # if bucket doesnt exist yet, create it
            self.storage[i] = [-1] * (self.hash2 + 1)  # initialize inner array with -1 (empty), +1 handles key 1000000
        j = self.secondary(key)                         # find inner index for this key
        self.storage[i][j] = value                      # store the value at exact position

    def get(self, key):
        i = self.primary(key)                           # find outer index for this key
        if self.storage[i] is None:                     # if bucket never created, key doesnt exist
            return -1                                   # return -1 as per problem contract
        j = self.secondary(key)                         # find inner index for this key
        return self.storage[i][j]                       # return value (-1 naturally means not found)

    def remove(self, key):
        i = self.primary(key)                           # find outer index for this key
        if self.storage[i] is None:                     # if bucket never created, nothing to remove
            return                                      # exit early
        j = self.secondary(key)                         # find inner index for this key
        self.storage[i][j] = -1                         # reset to -1 (marks position as empty)
        