class MyHashSet:

    def __init__(self):
        self.size = 10000
        self.table = [None]*self.size

    def calc_hash_value(self, key):
        return key % self.size

    def add(self, key: int) -> None:
        hv = self.calc_hash_value(key)

        if self.table[hv] == None:
            self.table[hv] = [key]
        else:
            self.table[hv].append(key)

    def remove(self, key: int) -> None:
        hv = self.calc_hash_value(key)
        if self.table[hv] != None:
            while key in self.table[hv]:
                self.table[hv].remove(key)

    def contains(self, key: int) -> bool:

        hv = self.calc_hash_value(key)

        if self.table[hv] != None:
            return key in self.table[hv]
        return False
