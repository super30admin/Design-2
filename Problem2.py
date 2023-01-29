# // Time Complexity : O(1)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


class Node:
    def __init__(self, key=None, value=None):
        self.key = key
        self.value = value
        self.next = None
#implementation of linked list 
class LinkedList:
    def __init__(self):
        self.head = None
  
    #add or update a node, return 0 if node is added and 1 if node is updated
    def put(self, key, value):
        node = Node(key, value) #create a node
        if self.head == None: #if list is empty insert a node at the start
            self.head = node
            return 0
        else:
            n = self.head
            #iterate through the list till last node is found or key already exists
            while n.next:            
                if n.key == key: #update value if key already exists
                    n.value = value
                    return 1
                else:
                    n = n.next 
     
            if n.key == key: #update value if key already exists
                n.value = value
                return 1
            n.next = node #adding a new node
            return 0
  
    #find a node with the key in the list or throw an error
    def find(self, key):
        n = self.head
        #iterate through the list
        while n:
            if n.key == key:
                return n.value
            else:
                n = n.next
    
        raise KeyError(f'Item key: {key} does not exist')
  
    #remove the node with the given key from the list or throw an error
    def remove(self, key):
        if self.head: #if the list is not empty
            if self.head.key == key: #if the node to be deleted is the first node
                value = self.head.value
                self.head = self.head.next
                return value
            else:
                n = self.head
                #iterate through the list
                while n.next:
                    if n.next.key == key:
                        value = n.next.value
                        n.next = n.next.next
                        return value
                    else:
                        n = n.next
        raise KeyError(f'Item key {key} does not exist')   
    
    def printlist(self):
        n = self.head
        while n:
            print(f"{n.key}\t{n.value}")
            n = n.next
            
class MyHashMap:
    def __init__(self):
        self.arrayRange = 10 #maximum size of the array of buckets
        self.length = 0 #length of inserted items
        self.primaryArray = [LinkedList() for i in range(0, self.arrayRange)]
  
  #get the length
    def len(self):
        return self.length
    def hash(self, key): #get the index into an array of buckets
        return hash(key)%self.arrayRange
  
    def put(self, key, value): #insert or update an item
        index = self.hash(key)
        add = self.primaryArray[index].put(key, value)
        if add == 0: #increase the length if new item is added
            self.length += 1
  
    def get(self, key): #find the value of the given item
        index = self.hash(key)
        return self.primaryArray[index].find(key)
  
    def remove(self, key): #remove the item and return its value
        index = self.hash(key)
        value = self.primaryArray[index].remove(key)
        if value:
            self.length -= 1
        return value
  
    def traverse(self): #print all the (key, value) pairs 
        for i in range(0, self.arrayRange):
            self.primaryArray[i].printlist()