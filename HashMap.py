class MyHashMap:
    def __init__(self):

        self.size = 1000
        self.secondarysize = 1000
        # self.hashtable = [self.size][self.secondarysize]
        self.array = [[None for i in range(self.size)]
                      for j in range(self.size)]

    def hv1(self, key):
        return key % self.size

    def hv2(self, key):
        return key // self.size

    def put(self, key: int, value: int):
        hash1 = self.hv1(key)
        hash2 = self.hv2(key)
        if (self.array[hash1][hash2]) is None:
            self.array[hash1][hash2] = value
        else:
            self.array[hash1][hash2] = value

    def get(self, key: int):
        hash1 = self.hv1(key)
        hash2 = self.hv2(key)
        if self.array[hash1][hash2] != None:
            return self.array[hash1][hash2]
        else:
            return -1

    def remove(self, key: int):
        hash1 = self.hv1(key)
        hash2 = self.hv2(key)
        if self.array[hash1][hash2] != None:
            self.array[hash1].pop(hash2)

