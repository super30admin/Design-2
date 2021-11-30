class Node:
    def __init__(self,key,value, next_ele = None):
        self.key = key
        self.value = value
        self.next_ele  = None
class MyHashMap:
    """
    Approach:
    1. Declare a class Node, which will have key, value and next pointer
    2. Declare a list of type Node, initialize that with Null
    3. Create a hashing functions, which will return index of node array
    4. In put function check if index at which we are looking for key is null or not.
    5. If it is null then create a linked list at that point with dummy node [-1,-1]
    6. Dummy node is used to make life easier when the only one node is present in the              linked list
    7. Traverse through the link and find if key is present in linked list or not.
       If present then then update the value associated with that key
       Otherwise create a new node
    8. To satisfy the requirement of point 7, write a function named find, which should            return a previous node of the key specified
    9. When remove function called, find the key and remove it
    
    Time Complexity : O(n)
    Space Complexity : O(1)
    """    
    def __init__(self):
        self.buckets = 1000
        self.nodes = [Node(None,None) for i in range(self.buckets)]
        
    def get_hash(self, key):
        return key % self.buckets
    
    def find(self,node, key):
        prev = node
        curr = node.next_ele
        while(curr != None and prev.next_ele.key != key ):
            prev = curr
            curr = prev.next_ele
        return prev
    
    def put(self, key: int, value: int) -> None:
        bucket_index = self.get_hash(key)
        if self.nodes[bucket_index] == None:
            self.nodes[bucket_index] = Node(-1,-1)
            
        prev = self.find(self.nodes[bucket_index], key)
        if prev.next_ele == None:
            prev.next_ele = Node(key,value)
        else:
            prev.next_ele.value = value

    def get(self, key: int) -> int:
        bucket_index = self.get_hash(key)
        if self.nodes[bucket_index] == None:
            return -1
        
        prev = self.find(self.nodes[bucket_index] ,key)
        if prev.next_ele == None:
            return -1
        else:
            return prev.next_ele.value

    def remove(self, key: int) -> None:
        bucket_index = self.get_hash(key)
        if self.nodes[bucket_index] == None:
            return
        prev = self.find(self.nodes[bucket_index],key)
        if prev.next_ele == None:
            return
        else:
            prev.next_ele = prev.next_ele.next_ele