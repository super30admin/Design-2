"""
https://leetcode.com/problems/design-hashset/
Time Complexity: Searching O(1), in primary array we are finding the index and same we are doing in
secondary array
adding O(1)
removing-O(1)
contains-O(1)
Space Complexity:O(n)
Approach:
Here we will use double hashing so as to get rid of  collisions if any.
First hash function will be modulo 1000 and second we will chose divided by 1000 to avoid nested collisions. We will just append the values
Issue:I'm coding in python and my python skills are elementary, i'm trying hard but in some python operations i'm facing issue
The problem here is i'm not able to change the array size when dynamically when i want to add a nested array to a none element.
I'm supposing this is a syntax issue but i'm not able to figure out how to change my array size dynamically. Could you please help me correct
my python code. I'm facing list index out of range at  if self.storage[primaryIndex] is None: and this is because of
incorrect syntax or my lesser knowledge please help im stuck..
Ran on leetcode: no, index out of bound exception coz of lack of knowledge in python, could you please guide.
"""

class MyHashSet:
    def __init__(self):
        """
        Initialize your data structure here.
        :return: None
        """
        self.buckets=1000 ## this is the length of the primary array
        self.nestedItems=1000 ##these are the number of items in each array
        # for i in range(1000):

        self.storage=[[None]*self.buckets,[]] ## this is 2d array where elements will be stored, the 2nd array
        # self.storage = [None] * self.buckets
        ##will be initialized as empty and we will fill true/false as we encounter elements

    def hashfunctionBucket(self,key):
        ##this modulus function will give the primary index
        return key % self.buckets

    def hashfunctionnestedItems(self, key):
        ##the division function will give the secondary index where we will put the item
        return key // self.nestedItems


    def add(self, key: int) -> None:

        primaryIndex=self.hashfunctionBucket(key)
        secondaryIndex=self.hashfunctionnestedItems(key)
        ##python list declaring a 1 d array and changing it 2 do array im facing issue, kindly guide please,
        ##my python skills are elementary and i'm trying my best to learn them...i debugged this one last night but still facing issue
        if self.storage[primaryIndex] is None: ##checking if the primary index is null
            if primaryIndex is 0:
                """
                if we have encountered the extreme value 1000000
                since 1000000%1000=0 (index 0) and 1000000/1000=1000 so at the 0,1000 index will be out of bound
                since we will have 0-999(last index)
                """
                # self.storage[[primaryIndex],[]] = self.storage[[primaryIndex], [self.nestedItems+1]]
                # self.storage[[primaryIndex], []] = self.storage[[primaryIndex], [self.nestedItems + 1]]
                self.storage[primaryIndex] = self.storage[primaryIndex][self.nestedItems + 1]
            else:
                self.storage[primaryIndex] = self.storage[primaryIndex][self.nestedItems]
                ## if we are at any other position
        self.storage[primaryIndex][secondaryIndex] = True ##returning value true to the secondary index


    def remove(self, key: int) -> None:
        primaryIndex = self.hashfunctionBucket(key)
        secondaryIndex = self.hashfunctionnestedItems(key)
        if self.storage[primaryIndex] is None:
            return
        self.storage[primaryIndex][secondaryIndex] = False

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        primaryIndex = self.hashfunctionBucket(key)
        secondaryIndex = self.hashfunctionnestedItems(key)
        if self.storage[primaryIndex]==None:
            return False
        elif self.storage[primaryIndex][secondaryIndex]==key:
            return True

# Your MyHashSet object will be instantiated and called as such:
obj = MyHashSet()
obj.add(200)
obj.remove(1000)
param_3 = obj.contains(1000)

#

#
# bucket=[[] for i in range (5)]
# print(bucket)

