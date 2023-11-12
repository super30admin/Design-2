class MyHashSet:
    def __init__(self):
        """
        Initialize your data structure here.
        :return: None
        """
        self.buckets=1000 ## this is the length of the primary array
        self.nestedItems=1000 ##these are the number of items in each array
        # for i in range(1000):

        # self.storage=[[None]*self.buckets,[]] ## this is 2d array where elements will be stored, the 2nd array
        # self.storage = [None] * self.buckets
        ##will be initialized as empty and we will fill true/false as we encounter elements
        self.storage=[None for _ in range (self.buckets)]

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
        if self.storage[primaryIndex] == None: ##checking if the primary index is null
            if primaryIndex == 0:
                """
                if we have encountered the extreme value 1000000
                since 1000000%1000=0 (index 0) and 1000000/1000=1000 so at the 0,1000 index will be out of bound
                since we will have 0-999(last index)
                """
                # self.storage[[primaryIndex],[]] = self.storage[[primaryIndex], [self.nestedItems+1]]
                # self.storage[[primaryIndex], []] = self.storage[[primaryIndex], [self.nestedItems + 1]]
                # self.storage[primaryIndex] = self.storage[primaryIndex][self.nestedItems + 1]
                self.storage[primaryIndex] =  [None for i in range(self.nestedItems + 1)]
            else:
                self.storage[primaryIndex] = [None for i in range(self.nestedItems)]
                ## if we are at any other position
        self.storage[primaryIndex][secondaryIndex] = True


    def remove(self, key: int) -> None:
        primaryIndex = self.hashfunctionBucket(key)
        secondaryIndex = self.hashfunctionnestedItems(key)
        if self.storage[primaryIndex] == None:
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
        return self.storage[primaryIndex][secondaryIndex]