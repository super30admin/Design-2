// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this : Stuck in the creating functions of add, remove, and contains.


// Your code here along with comments explaining your approach
/* Approach: By creating class MyHashSet, initialize table of fixed size
 and initialize with bucket with empty. Create function for calculate remainder.
 Create Functions for add , remove, and contains 


*/
//Python
class MyHashSet:
    def __init__(self):
        self.size = 1000 // Defined size of 1000 
        self.buckets = [None] * self.size // Initially array is none

    def hash_func(self, key):
        return key % self.size //return remainder

    def add(self, key):
        hash_val = self.hash_func(key)
        if key is not in self.buckets[hash_val]:
            self.buckets[hash_val].append(key) //adding value if not present in bucket