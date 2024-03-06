#time complexity: put, get, remove : O(1) assuming- key-value pairs are well distributed across the buckets.
# space complexity: O(N)-worstcase 

#approach:
# create a list of nodes
# whenever there is put, do hashing of the key and find the index in the list.
# if the value at that index is None, initialise the dummy node.
# traverse the linkedlist of that index till we get the previous node of the key'prev'.
# if next node of prev is null, that means the key is not found, 
# hence prev.next would be new node of key and value
# else prev.next nodes value alone will be updated with new value.
# when there is get, follow same approach. except 
# return -1 if value at index is None or  next node of prev is null
# return value if prev.next is not null
# remove: follow the same procedure and make the prev.next = prev.next.next if prev.next is not null




class MyHashMap:
    class Node:
        def __init__(self, key:int, value:int, next = None):
            self.key = key
            self.value = value
            self.next = next
            

    def __init__(self):
        self.buckets = 1000
        self.nodes = [self.Node(None, None) for _ in range(self.buckets)]
        
    def get_bucket(self,key):
        return key % self.buckets
    
    
    def find(self, head, key:int):
        prev = head
        curr = head
        while(curr != None and curr.key != key):
            prev = curr
            curr = curr.next
        return prev
                

    def put(self, key: int, value: int) -> None:
        index = self.get_bucket(key)
        if self.nodes[index] == None:
            self.nodes[index]=self.Node(-1,-1)
        prev = self.find(self.nodes[index],key)
        if prev.next == None:
            prev.next = self.Node(key,value)
        else:
            prev.next.value = value
            

    def get(self, key: int) -> int:
        index = self.get_bucket(key)
        if self.nodes[index]== None:
            return -1
        else:
            prev = self.find(self.nodes[index], key)
            if prev.next == None:
                return -1
            else:
                return prev.next.value
        

    def remove(self, key: int) -> None:
        index = self.get_bucket(key)
        if self.nodes[index]== None:
            return 
        else:
            prev = self.find(self.nodes[index], key)
            if prev.next == None:
                return 
            else:
                prev.next = prev.next.next
        
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)