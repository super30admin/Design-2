# Time Complexity :
# Push, pop, top and getMin - O(N/10000)

# Space Complexity :
# O(N)

# Did this code successfully run on Leetcode :
#Yes

# Any problem you faced while coding this :
# No

class Node :
    #Linked list Node
    def __init__(self,key,value,next_pointer):
        self.key = key
        self.value = value
        self.next = next_pointer

class MyHashMap:
    def __init__(self):
        self.buckets = 10000
        self.data = [None] * self.buckets

    def hash(self,key):
        return key % self.buckets

    def find (self,head,key):
        #Go through the linked list and return the node previous to the 
        #element we are trying to find
        prev = head
        current = head.next
        while current != None:
            if current.key == key :
                return prev
            else :
                prev = current
                current = current.next   
        return prev

    def put(self, key: int, value: int) -> None:
        #Putting elements - 
        current_head = self.data[self.hash(key)]
        #if no value exists then create linked list and add
        if current_head == None :
            next_node = Node(key,value,None)
            current_head = Node(-1,-1,next_node)
            self.data[self.hash(key)] = current_head
            return 

        # If a linked list exists, check if the key exists in the list
        #If it does, udpate it, otherwise add a new node
        prev_node = self.find(current_head,key)
        if prev_node.next == None:
            prev_node.next = Node(key,value,None)
        else :
            prev_node.next.value = value

    def get(self, key: int) -> int:
        #if no value exists then key does not exist
        current_head = self.data[self.hash(key)]
        if current_head == None:
            return -1

        # If a linked list exists, check if the key exists in the list
        #If it does, return it, otherwise return -1
        prev_node = self.find(current_head,key)
        if prev_node.next != None:
            return prev_node.next.value
        else :
            return -1

    def remove(self, key: int) -> None:
        #if no value exists then key does not exist - nothing to remove
        current_head = self.data[self.hash(key)]
        if current_head == None:
            return -1
        # If a linked list exists, check if the key exists in the list
        #If it does, remove it, otherwise nothing to do
        prev_node = self.find(current_head,key)
        if prev_node.next != None:
            prev_node.next = prev_node.next.next
