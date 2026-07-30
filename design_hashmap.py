# Implemented hashmap using linear chaining of linked list
# TC -> O(N) where N is the number of elemets as we are traversing the linked list all the time
# SC -> O(N) where N is the number of elemets

class MyHashMap:
    class Node():
        def __init__(self, key, value):
            self.key = key
            self.value = value
            self.next = None

    def __init__(self):
        self.num_buckets = 1000
        self.storage = [None] * self.num_buckets

    def put(self, key: int, value: int) -> None:
        hash_val = self.hash_function(key)
        if not self.storage[hash_val]:
            self.storage[hash_val] = self.Node(-1,-1)
            self.storage[hash_val].next = self.Node(key, value)
        else:
            prev_node = self.prev_node(self.storage[hash_val], key)
            if prev_node.next:
                prev_node.next.value = value
            else:
                prev_node.next = self.Node(key, value)

    def get(self, key: int) -> int:
        hash_val = self.hash_function(key)
        if self.storage[hash_val] is not None:
            prev_node = self.prev_node(self.storage[hash_val], key)
            if prev_node.next:
                    return prev_node.next.value
        return -1
        
    def remove(self, key: int) -> None:
        hash_val = self.hash_function(key)
        if self.storage[hash_val] is not None:
            prev_node = self.prev_node(self.storage[hash_val], key)
            if prev_node.next is not None:
                prev_node.next = prev_node.next.next

    def prev_node(self, head, key: int) -> Node:
        temp = prev = head
        while temp is not None and temp.key != key:
            prev = temp
            temp = temp.next
        return prev

    def hash_function(self, key) -> int:
        return key % self.num_buckets

        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)