class MyHashSet(object):

    def __init__(self):
        self.arr = [None] * 1001
        self.modulo = 1000

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        rem = key % self.modulo
        divis = key // self.modulo
        if self.arr[rem] == None:
            self.arr[rem] = [None] * 1001
        self.arr[rem][divis] = True

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        rem = key % self.modulo
        divis = key // self.modulo
        if self.arr[rem] == None: return
        self.arr[rem][divis] = None

    def contains(self, key):
        """
        :type key: int
        :rtype: bool
        """
        rem = key % self.modulo
        divis = key // self.modulo
        if self.arr[rem] == None:
            return False
        return self.arr[rem][divis] == True

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
