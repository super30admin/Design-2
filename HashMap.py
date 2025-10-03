# 706. Implement HashMap

class MyHashMap(object):
    def __init__(self):
        self.buckets = 1000
        self.bucketItems = 1000
        self.primaryArray = [None for i in range(self.buckets)]
    
    def hash1(self, inp):
        return inp%1000
    
    def hash2(self, inp):
        return inp//1000

    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: None
        """
        has1 = self.hash1(key)
        has2 = self.hash2(key)

        if self.primaryArray[has1] == None:
            if has1 == 0:
                self.primaryArray[has1] = [None for i in range(self.bucketItems + 1)]
            else:
                self.primaryArray[has1] = [None for i in range(self.bucketItems)]
        
        self.primaryArray[has1][has2] = value

    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        has1 = self.hash1(key)
        has2 = self.hash2(key)

        if self.primaryArray[has1] == None:
            return -1

        if self.primaryArray[has1][has2] == None:
            return -1
        
        return self.primaryArray[has1][has2]

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        has1 = self.hash1(key)
        has2 = self.hash2(key)

        if self.primaryArray[has1] != None:
            self.primaryArray[has1][has2] = None


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)