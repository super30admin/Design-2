'''
706. Design HashMap
'''

# Time Complexity : O(1) for put, get, and remove operations on average; O(n) in the worst case due to collisions
# Space Complexity : O(n) where n is the number of key-value pairs stored in the hashmap
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes, handling collisions efficiently was a challenge. Also, designing put and remove methods to update or delete key-value pairs required careful consideration of how to handle existing keys.

# Python program to implement a simple HashMap

class MyHashMap: # humne ek class MyHashMap banayi hai jo hashmap ko implement karegi (we are creating a class MyHashMap that will implement the hashmap and its methods)

    def __init__(self): # humne MyHashMap Class ka constructor banaya hai (we are creating the constructor of MyHashMap class)
        # Initialize the HashMap with a fixed size
        self.size = 1000 # humne hashmap ka size 1000 set kiya hai kyunki hum assume kar rahe hain ki keys 0 se 999 tak honge (we are setting the size of the hashmap to 1000 because we are assuming that keys will be from 0 to 999)
        self.map = [[] for _ in range(self.size)] # humne ek list banayi hai jo hashmap ke buckets ko represent karegi aur har bucket ek empty list se initialize ki gayi hai (we are creating a list that will represent the buckets of the hashmap and each bucket is initialized with an empty list)

    def hashfunction(self, key): # humne ek hash function banaya hai jo key ke liye index compute karega aur hashmap mein us index par value store karega (we are creating a hash function that will compute the index for the key and store the value at that index in the hashmap)
        # Hash function to compute the index for a given key
        return key % self.size # yahaan hum key ko size se modulo kar rahe hain taaki hume ek valid index mile (here we are taking the modulo of the key with the size to get a valid index)

    def put(self, key: int, value: int) -> None: # humne put method banaya hai jo key-value pair ko hashmap mein store karega (we are creating a put method that will store the key-value pair in the hashmap)
        index = self.hashfunction(key) # hum index compute kar rahe hain key ke liye jahaan humein value store karni hai (we are computing the index for the key where we want to store the value)
        # Check if the key already exists in the map
        for i, (k, v) in enumerate(self.map[index]): # hum hashmap ke corresponding bucket mein key ko search kar rahe hain (we are searching for the key in the corresponding bucket of the hashmap)
            if k == key: # akar kth index ka number key ke barabar hai (if the key at index k is equal to the key we are looking for)
                # Update the value if the key exists
                self.map[index][i] = (key, value) # hum value ko update kar rahe hain agar key exist karti hai (we are updating the value if the key exists)
                return # agar key exist karti hai to hum value ko update karte hain (if the key exists, we update the value)
        # If the key does not exist, append a new key-value pair
        self.map[index].append((key, value)) # agar key exist nahi karti hai to hum ek naya key-value pair append karte hain (if the key does not exist, we append a new key-value pair)
        return # humne put method ka end kiya (we have ended the put method)

    def get(self, key: int) -> int: # humne get method banaya hai jo key ke liye value return karega (we are creating a get method that will return the value for the key)
        index = self.hashfunction(key) # hum index compute kar rahe hain key ke liye (we are computing the index for the key)
        # Search for the key in the corresponding bucket
        for k, v in self.map[index]: # hum hashmap ke corresponding bucket mein key ko search kar rahe hain (we are searching for the key in the corresponding bucket of the hashmap)
            if k == key: # agar kth index ka number key ke barabar hai (if the key at index k is equal to the key we are looking for)
                return v # agar key exist karti hai to hum value return karte hain (if the key exists, we return the value)
        # Return -1 if the key does not exist
        return -1 # agar key exist nahi karti hai to hum -1 return karte hain (if the key does not exist, we return -1)

    def remove(self, key: int) -> None: # humne remove method banaya hai jo di gayi key aur uski value ko hashmap se remove karega (we are creating a remove method that will remove the given key and its value from the hashmap)
        index = self.hashfunction(key) # hum index compute kar rahe hain key ke liye (we are computing the index for the key)
        # Search for the key in the corresponding bucket
        for i, (k, v) in enumerate(self.map[index]): # hum hashmap ke corresponding bucket mein key ko search kar rahe hain (we are searching for the key in the corresponding bucket of the hashmap)
            if k == key: # agar kth index ka number key ke barabar hai (if the key at index k is equal to the key we are looking for)
                # Remove the key-value pair if found
                del self.map[index][i] # agar key exist karti hai to hum key-value pair ko remove karte hain (if the key exists, we remove the key-value pair)
                return # agar key exist karti hai to hum key-value pair ko remove karte hain (if the key exists, we remove the key-value pair)
        # If the key does not exist, do nothing
        return # agar key exist nahi karti hai to hum kuch nahi karte (if the key does not exist, we do nothing)


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)