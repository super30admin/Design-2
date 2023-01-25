#Explain your approach in **three sentences only** at top of your code
'''Used doublehash where the index is the key and the value is an int, 
rather than boolean.'''

# Time Complexity : O(1)
# Space Complexity : O(N), worst being O(N^2).
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : 
'''Fiddled with the value not being in the double array because the 
array of array didn't exist.  
'''


# Your code here along with comments explaining your approach

class MyHashMap:

    def __init__(self):
        self.hashmap = [None]*1000

    def put(self, key: int, value: int) -> None:
        #obtain the hash values.
        hash1 = key%1000
        hash2 = int(key/1000)
        #if hashmap array value is None, add an array of 1000 length. 
        if self.hashmap[hash1]==None:
            #first array value is 1001, to account for the extra value.
            if hash1==0:
                self.hashmap[hash1]=[None]*1001
            else:
                self.hashmap[hash1]=[None]*1000
            self.hashmap[hash1][hash2]=value
        else:
            self.hashmap[hash1][hash2]=value

    #similar to put. 
    def get(self, key: int) -> int:
        hash1 = key%1000
        hash2 = int(key/1000)
        if self.hashmap[hash1] is None:
            return -1
        elif self.hashmap[hash1][hash2] is None:
            return -1
        else:
            return self.hashmap[hash1][hash2]

    def remove(self, key: int) -> None:
        hash1 = key%1000
        hash2 = int(key/1000)
        # make sure value at key is None.
        if self.hashmap[hash1]!=None:
            self.hashmap[hash1][hash2]=None