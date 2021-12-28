class MyHashSet(object):

    def __init__(self):
        # self.bucketSize = 1000 #main array column for 1000*1000 matrix
        # self.bucketItems = 1000 #sub array
        # self.storage = [[None for i in range(self.bucketSize)] for i in range(self.bucketItems)]
        # [[None] * self.bucketSize] * self.bucketItems 
        self.storage = [[] for _ in range(1000)]
        
    def bucketItem(self, key): return key % 1000
        
    # def bucketIte(self, key: int) -> int:
        # return key // self.bucketItems

    def add(self, key):
        # print(self.storage)
        if not self.contains(key):
            # print(2, self.contains(key))
            # print(3, self.storage[self.bucketItem(key)])
            # print(6, self.storage[self.bucketItem(key)])
            self.storage[self.bucketItem(key)].append(key)

    def remove(self, key):
        if self.contains(key):
            self.storage[self.bucketItem(key)].remove(key)
    
    def contains(self, key):
        # print(4, self.storage[self.bucketItem(key)])
        # print(5, key in self.storage[self.bucketItem(key)])
        return key in self.storage[self.bucketItem(key)]
        
        
        
        # bucket = self.bucket(key)
        # bucket_Item = self.bucketItem(key)
        # if not self.storage:
        #     if bucket == 0:
        #         self.storage[bucket] = [0]*(self.bucketItems + 1)
        #     else:
        #         self.storage[bucket] = [0] * self.bucketItems
        # self.storage[bucket][bucket_Item] = True
        
        """
        :type key: int
        :rtype: None
        """
        

    # def remove(self, key):
    #     """
    #     :type key: int
    #     :rtype: None
    #     """
        

    # def contains(self, key):
    #     """
    #     :type key: int
    #     :rtype: bool
    #     """
        


# Your MyHashSet object will be instantiated and called as such:
obj = MyHashSet()
for _ in range(100000): obj.add(_)
print(obj.storage)
print(obj.contains(5466))
# print(obj.contains(5465))
# print(obj.contains(5467))
# obj.remove(key)
# param_3 = obj.contains(key)