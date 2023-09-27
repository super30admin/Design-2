class MyHashMap(object):

    def __init__(self):
        self.length = 1000
        self.hm = [None] * self.length

    def hashfunc(self, key):
        return key % self.length

    def second_hashfunc(self, key):
        return key // self.length

    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: None
        """
        fi = self.hashfunc(key)
        si = self.second_hashfunc(key)
        if not self.hm[fi]:
            self.hm[fi] = [None] * (self.length + 1)

        self.hm[fi][si] = (key, value)

    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        fi = self.hashfunc(key)
        if self.hm[fi]:
            si = self.second_hashfunc(key)
            if self.hm[fi][si]:
                return self.hm[fi][si][1]
        return -1

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        fi = self.hashfunc(key)
        if self.hm[fi]:
            si = self.second_hashfunc(key)
            self.hm[fi][si] = None

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)