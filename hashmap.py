#Time Complexity:-O(1)
#Spae Complexity:- O(N+M)

class MyHashMap:
    class Node:
        def __init__(self,key:int,value:int):
            self.key=key
            self.value=value
            self.next=None
    def find(self,key:int,head:Node)->Node:
         # Helper function to find the node with the given key in the linked list starting from the provided head node
        previous=head
        current=head.next
        while current !=None and current.key !=key:
            previous=current
            current=current.next
        return previous
        
    def getBucket(self,key:int)->int:
        # Helper function to compute the bucket index based on the hash value of the key.
        return hash(key)%self.buckets   


    def __init__(self):
         # Initialize the HashMap with 10,000 buckets and create an array of linked lists (chaining)
        self.buckets=10000
        self.storage=[None] * self.buckets
        

    def put(self, key: int, value: int) -> None:
        # Add or update the key-value pair in the HashMap
        bucket=self.getBucket(key)
        # If the bucket is empty, create a dummy node to serve as the head of the linked list
        if self.storage[bucket]== None:
            self.storage[bucket]=self.Node(-1,-1)
        # Find the node with the given key (or its previous node) in the linked list
        previous=self.find(key,self.storage[bucket])
        # If the key does not exist, create a new node and attach it to the previous node
        if previous.next==None:
            previous.next =self.Node(key, value)
        else:
            # If the key exists, update the value of the existing node
            previous.next.value=value
        

    def get(self, key: int) -> int:
        # Get the value associated with the given key from the HashMap
        bucket=self.getBucket(key)
        # If the bucket is empty, the key does not exist in the HashMap
        if self.storage[bucket]== None:
            return -1
        # Find the node with the given key in the linked list
        previous = self.find(key,self.storage[bucket])
        # If the node's next is None, the key does not exist in the HashMap
        if previous.next == None:
            return -1
        # Return the value of the node with the given key
        return previous.next.value
        

    def remove(self, key: int) -> None:
         # Remove the key-value pair with the given key from the HashMap
        bucket=self.getBucket(key)
        # If the bucket is empty, the key does not exist in the HashMap
        if self.storage[bucket]==None:
            return
         # Find the node with the given key in the linked list
        previous =self.find(key,self.storage[bucket])
        # If the node's next is None, the key does not exist in the HashMap
        if previous.next==None:
            return
        # Remove the node from the linked list
        previous.next=previous.next.next