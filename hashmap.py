class MyHashMap(object):

    def __init__(self):
        self.size = 1000  # Choose a reasonable initial size for the array
        self.buckets = [None] * self.size

    def _hash(self, key):
        return key % self.size

    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: None
        """
    index = self._hash(key)
    if not self.buckets[index]:
        self.buckets[index] = []
        
        # Check if the key already exists in the linked list at the index
        for i, (k, v) in enumerate(self.buckets[index]):
            if k == key:
                self.buckets[index][i] = (key, value)
        return
        
        # If the key doesn't exist, append the (key, value) pair to the linked list
        self.buckets[index].append((key, value))

    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
    index = self._hash(key)
    if not self.buckets[index]:
            return -1
        
        # Search for the key in the linked list at the index
    for k, v in self.buckets[index]:
            if k == key:
                return v
        
            return -1
        

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        index = self._hash(key)
        if not self.buckets[index]:
            return
        
        # Find and remove the (key, value) pair from the linked list
        for i, (k, v) in enumerate(self.buckets[index]):
            if k == key:
                del self.buckets[index][i]
                return
        

myHashMap = MyHashMap()
myHashMap.put(1, 1)
myHashMap.put(2, 2)
print(myHashMap.get(1))  # Output: 1
print(myHashMap.get(3))  # Output: -1
myHashMap.put(2, 1)     # Update the existing key 2
print(myHashMap.get(2))  # Output: 1
myHashMap.remove(2)      # Remove the key 2
print(myHashMap.get(2))  # Output: -1
# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)