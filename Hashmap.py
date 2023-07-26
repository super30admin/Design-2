class MyHashMap:

    '''init(self):Defining the size of my hash table to be 1000. The hash table, named 'table', is a list of empty lists (initially). This means the table has 1000 "buckets" that can each hold multiple items, which is a technique known as separate chaining for collision resolution. '''

    def __init__(self):
        self.size = 1000
        self.table = [[] for _ in range(self.size)]

    '''put(self, key: int, value: int): This method inserts a key-value pair into the HashMap. To determine where to place the key-value pair, I calculate a hash_key. This is simply the remainder of the key divided by the size of the hash table. If the calculated bucket is empty, I create a new list with a single entry [key, value]. If the bucket is not empty (meaning a collision has occurred), I iterate through the key-value pairs already in the bucket. If I find a key that matches the new key, I update the value. If no match is found, I append the new key-value pair to the bucket.'''

    def put(self, key: int, value: int) -> None:
        hash_key = key % self.size
        if not self.table[hash_key]:
            self.table[hash_key] = [[key,value]]
        else:
            for pair in self.table[hash_key]:
                if pair[0] == key:
                    pair[1] = value
                    return
            self.table[hash_key].append([key,value])

'''
get(self, key: int): This method retrieves a value based on a given key. I compute the hash_key in the same way as in the put method. If there are key-value pairs in the corresponding bucket, I iterate through them to find the desired key. If the key is found, I return its corresponding value. If the key is not found, I return -1.
'''
    
    def get(self, key: int) -> int:
        hash_key = key % self.size
        if self.table[hash_key]:
            for pair in self.table[hash_key]:
                if pair[0] == key:
                    return pair[1]
        return -1
  

'''remove(self, key: int): This method removes a key-value pair from the HashMap. I compute the hash_key as before, and if the bucket is not empty, I iterate through its key-value pairs. If I find a pair with the given key, I delete it from the bucket.
'''
    def remove(self, key: int) -> None:
        hash_key = key % self.size
        if self.table[hash_key]:
            for i, pair in enumerate(self.table[hash_key]):
                if pair[0] == key:
                    del self.table[hash_key][i]


