# https://leetcode.com/problems/design-hashmap/


# creating a hashmap to store key, value pair. get_hash method is used to find the bucket for the key and then created a get_prev method to find out the previous pointer of the key which about to insert or remove. Then connecting that pointer with new pair while inserting or next pair after the removed pair 

# creating a class MyHashMap
class MyHashMap:
    def __init__(self):
        # initialising the bucket and storage
        self.bucket = 1000
        self.storage = [None] * self.bucket

    class Nodes:
        # initialising the attribute of Nodes class
        def __init__(self, key, value):
                self.key = key
                self.value = value
                self.next = None 
        
    # method to find a bucket in a map to store the key and value
    def get_hash(self, key) -> int:
        return key % self.bucket 

    # we are using linkedlist in the bucket to store the key, value pair. prev pointer is useful to connect the nodes while adding and removing the key. this method finds previous node of the given key
    def get_prev(self, head, key):
        prev = None
        curr = head
        # we need to find the prev pointer of the given key so we are looping until we find the key
        while curr is not None and curr.key != key:
            # prev is the node before the newly added/removal key
            prev = curr
            # curr is the node for new key
            curr = curr.next
        return prev
        
    # method to insert the key and value pair
    def put(self, key: int, value: int) -> None:
        # find the bucket using the hash method
        index = self.get_hash(key)
        # if there is nothing in the bucket means we are adding for the first time
        if self.storage[index] is None:
            # denoting first element is (-1,-1) in hashmap because while adding or removing the key link could disrupt so dummy acts as a constant at first location 
            self.storage[index] = self.Nodes(-1, -1)
            # newly provided key value is added next to the node
            self.storage[index].next = self.Nodes(key, value)
            return
        # if the bucket is not empty add the time of insertion find the previous pointer of the current key, value pair
        prev = self.get_prev(self.storage[index], key)
        # if the next of the previous is none we can directly add key value pair
        if prev.next is None:
            prev.next = self.Nodes(key, value)
        # but if there is existing node then need to update the existing value with the new value and key remain unchanged
        else:
            prev.next.value = value

    # method to return the value of the key
    def get(self, key: int) -> int:
        index = self.get_hash(key)
        # if the bucket for that key is empty
        if self.storage[index] is None:
            return -1
        # call the prev method to find the previous pointer of the given key
        prev = self.get_prev(self.storage[index], key)
        # if the prev is the last node then there nothing at next so return -1
        if prev.next is None:
            return -1
        # If prev.next is not None, it points to the node containing the key.
        return prev.next.value       
            
    # method to remove the key and it's correspondent element
    def remove(self, key: int) -> None:
        index= self.get_hash(key)
        # if bucket is empty 
        if self.storage[index] is None:
            return -1
        # call the prev method to find the previous pointer of the given key
        prev = self.get_prev(self.storage[index], key)
        if prev.next is None:
            return -1
        # link the next node of previous(that is curr which we want to remove) with the next to next node(that is next of the curr)
        prev.next = prev.next.next
            

# Your MyHashMap object will be instantiated and called as such:
obj = MyHashMap()
obj.put(2,200)
print(obj.put(2,200))
param_2 = obj.get(2)
obj.remove(2)