## Problem 2:
# Design Hashmap (https://leetcode.com/problems/design-hashmap/)

# Time Complexity : In design problems we consider time complexity for each function. It is amortized O(1) for put(), get() and remove() methods
# Space Complexity : O(N) -- In worst case when all the buckets and linkedlist are occupied
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# we are using linear chaining here. It gives amortized O(1) for put(), get() and remove() methods
# We have taken our primary array of size 10^4. This helps to reduce the number of collisions to 100. Thus our linkedlist size
# reduces to 100. 
# Our primary array stores the pointers to the dummy node of linkedlist. We initialize the secondary array only when we get the corresponding 
# hash1 value for that array
# We store the key and value for that key in our linkedlist. So we define our node accordingly

# Method-1
# Using Linear Chaining

class Node(object):
    def __init__(self, key, value):
        self.key = key
        self.val = value
        self.next = None

class MyHashMap(object):

    def __init__(self):
        self.bucketSize = 10000
        self.primaryBucket = [None] * self.bucketSize

    def __hash1(self, key):
        return (key % self.bucketSize)

    def __prevNode(self, head, key):
        prev = head
        curr = head.next
        while(curr):
            if(curr.key == key):
                break
            prev = curr
            curr = curr.next

        return prev

    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: None
        """
        bucket = self.__hash1(key)
        if(not self.primaryBucket[bucket]):
            self.primaryBucket[bucket] = Node(-1, -1)
        
        prev = self.__prevNode(self.primaryBucket[bucket], key)
        # check if key already exists
        if(prev.next):
            # key already exists
            # update the value
            prev.next.val = value
        else:
            # key does not exist
            # add the key value at the last
            prev.next = Node(key, value)
        

        

    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        bucket = self.__hash1(key)
        if(not self.primaryBucket[bucket]):
            return -1

        prev = self.__prevNode(self.primaryBucket[bucket], key)
        mapVal = -1
        # check if key exists
        if(prev.next):
            # key exists
            mapVal = prev.next.val

        return mapVal

        

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        bucket = self.__hash1(key)
        if(not self.primaryBucket[bucket]):
            return

        prev = self.__prevNode(self.primaryBucket[bucket], key)
        # check if key exists
        if(prev.next):
            # key exists
            # remove the key
            curr = prev.next
            prev.next = curr.next
            curr.next = None
        
print("Method-1: Linear Chaining")
myHashMap = MyHashMap()
myHashMap.put(1, 1)
myHashMap.put(2, 2)
print(myHashMap.get(1))
print(myHashMap.get(3))
myHashMap.put(2, 1)
print(myHashMap.get(2))
myHashMap.remove(2)
print(myHashMap.get(2))

myHashMap2 = MyHashMap()
print(myHashMap2.get(16))
print(myHashMap2.get(20))
myHashMap2.put(16, 20)
myHashMap2.put(20, 16)
myHashMap2.put(22, 15)
print(myHashMap2.get(16))
print(myHashMap2.get(20))
print(myHashMap2.get(22))
myHashMap2.put(11, 21)
myHashMap2.put(21, 11)
myHashMap2.put(22, 17)
print(myHashMap2.get(22))
myHashMap2.remove(22)
print(myHashMap2.get(22))

# Method-2
# Using Double Hashing

# Time Complexity : In design problems we consider time complexity for each function. It is perfect O(1) for put(), get() and remove() methods
# Space Complexity : O(N) -- In worst case when all the buckets are filled
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# we are using double hashing here as it gives perfect O(1) for put(), get() and remove() methods
# We have divided our primary and secondary array into size of 10^3 each ie underoot(10^6) to make more balanced
# Our primary array stores the pointers to the secondary array. We initialize the secondary array only when we get the corresponding 
# hash1 value for that array
# The index of the secondary array are used as keys and we are storing values at that particular index for the key

class MyHashMapDH(object):

    def __init__(self):
        self.bucketSize = 10000
        self.bucketItemSize = 1000
        self.primaryBucket = [None] * self.bucketSize

    def __hash1(self, key):
        return (key % self.bucketSize)

    def __hash2(self, key):
        return (key // self.bucketItemSize)

    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: None
        """
        bucket = self.__hash1(key)
        bucketItem = self.__hash2(key)
        if(not self.primaryBucket[bucket]):
            if(bucket == 0):
                self.primaryBucket[bucket] = [-1] * (self.bucketItemSize + 1)
            else:
                self.primaryBucket[bucket] = [-1] * (self.bucketItemSize)
        
        self.primaryBucket[bucket][bucketItem] = value
        

        

    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        bucket = self.__hash1(key)
        bucketItem = self.__hash2(key)
        if(not self.primaryBucket[bucket]):
            return -1
            

        return self.primaryBucket[bucket][bucketItem]

        

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        bucket = self.__hash1(key)
        bucketItem = self.__hash2(key)
        if(not self.primaryBucket[bucket]):
            return

        self.primaryBucket[bucket][bucketItem] = -1




print("Method-2: Double Hashing")
myHashMap = MyHashMapDH()
myHashMap.put(1, 1)
myHashMap.put(2, 2)
print(myHashMap.get(1))
print(myHashMap.get(3))
myHashMap.put(2, 1)
print(myHashMap.get(2))
myHashMap.remove(2)
print(myHashMap.get(2))

myHashMap2 = MyHashMap()
print(myHashMap2.get(16))
print(myHashMap2.get(20))
myHashMap2.put(16, 20)
myHashMap2.put(20, 16)
myHashMap2.put(22, 15)
print(myHashMap2.get(16))
print(myHashMap2.get(20))
print(myHashMap2.get(22))
myHashMap2.put(11, 21)
myHashMap2.put(21, 11)
myHashMap2.put(22, 17)
print(myHashMap2.get(22))
myHashMap2.remove(22)
print(myHashMap2.get(22))