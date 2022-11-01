class MyHashMap:
    
    """
    put method - time complexity - O(n), space complexity - O(n)
    get method - time complexity - O(n), space complexity - O(n)
    remove method - time complexity - O(n), space complexity - O(n)
    
    """

    def __init__(self):
        self.list = [-1 for x in range(0,10000)]
        self.size = 1000
        

    def put(self, key: int, value: int) -> None:
        hash_index = self.get_hash(key)
        new_node = Node(key,value,None)
        if self.list[hash_index] == -1:
            self.list[hash_index] = new_node
        else:
            root = self.list[hash_index]
            # iterate over the node list to find the key if the key is already present.
            while(root!= None):
                prev = root
                if root.key == key:
                    root.value = value
                    return
                root = root.next
            #if key is not present, add the new node at the end of node list.
            prev.next = new_node
                
        

    def get(self, key: int) -> int:
        hash_index = self.get_hash(key)
        #if list is not created, key is not present
        if self.list[hash_index] == -1:
            return -1
        else:
            root = self.list[hash_index]
            # iterate over the node list to find the key.
            while(root != None):
                if root.key == key:
                    return root.value
                root = root.next
        return -1
        

    def remove(self, key: int) -> None:
        hash_index = self.get_hash(key)
        if self.list[hash_index] == -1:
            return
        else:
            root = self.list[hash_index]
            if root.key == key:
                self.list[hash_index] = root.next if root.next != None else -1
                return
            # as we have already checked the first node
            prev = root
            root = root.next
            # iterate over the node list to find the key.
            while root != None:
                if root.key == key:
                    prev.next = root.next
                    return
                prev = root
                root = root.next
            
        
        
    def get_hash(self, key):
        return key % self.size
        
        
class Node:
    
    def __init__(self, k, v, n):
        self.key = k
        self.value = v
        self.next = n
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)