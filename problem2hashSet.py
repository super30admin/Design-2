'''
Leet Code : https://leetcode.com/problems/design-hashset/submissions/
'''

# Approach: Use doubly linked-list for chaining

class Node:
    
    def __init__(self,key,value):
        self.key = key
        self.value = value
        self.next = None
        self.previous = None

class doublyLinkedList:
    
    def __init__(self):
        self.head = None
        self.tail = None
        self.dll_length = 0
    
    def insert_dll(self,key,value):
        
        # Check if we have the key
        result = self.contains_dll(key)
        
        if result != True:
            # We dont' have this key
            # Create an object of class node        
            objNewNode = Node(key,value)
            
            if self.dll_length == 0:
                # No node is available
                self.head = objNewNode
                self.tail = self.head
            
            else:
                # We have a node
                self.tail.next = objNewNode
                objNewNode.previous = self.tail
                self.tail = objNewNode
            
            self.dll_length +=1
    
    def delete_dll(self,key):
        
        # Check if we have the key
        result = self.contains_dll(key)
        
        if result == True:
        
            # Boundary Cases
            # Case: We have only 1 node
            if self.dll_length == 1:
                # We have only 1 node
                self.head.value = False
                self.head = None
                self.tail = None
                
                #self.dll_length -=1
            
            # Case 1: Delete head node
            elif self.head.key == key:
                toDeleteNode = self.head
                
                self.head = self.head.next
                toDeleteNode.next = None
                
                toDeleteNode.value = False
                toDeleteNode = None
                
                #self.dll_length -=1
                
            # Case 2: Delete tail node
            elif self.tail.key == key:
                toDeleteNode = self.tail
                
                self.tail = self.tail.previous
                self.tail.next = None
                
                toDeleteNode.previous = None
                toDeleteNode.value = False
                toDeleteNode = None
                
                #self.dll_length -=1
            
            else:    
                # Create a rfr to head node
                toDeleteNode = self.head
                
                while toDeleteNode.key != key:
                    toDeleteNode = toDeleteNode.next
                    continue
                
                # We have got toDeleteNode
                previousNode = toDeleteNode.previous
                nextNode = toDeleteNode.next
                
                previousNode.next = nextNode
                nextNode.previous = previousNode
                
                toDeleteNode.next = None
                toDeleteNode.previous = None
                toDeleteNode.value = False
                toDeleteNode = None
                
            self.dll_length -=1
                
    
    def contains_dll(self,key):
        
        result = False
        
        currentNode = self.head
        
        while currentNode!= None:
            if currentNode.key == key:
                result = currentNode.value
                break
            
            currentNode = currentNode.next
            continue
        
        return result
        
    def print_dll(self):
        
        rtrList = []
        
        currentNode = self.head
        
        while currentNode!= None:
            rtrList.append(vars(currentNode))
            currentNode = currentNode.next
            continue
        
        return rtrList
        
    
class MyHashSet:

    def __init__(self):
        
        # Initialize a list of size 10
        self.length = 10
        self.hashList = [None] * self.length
        
    # Create a hash function to compute has
    def hash(self,key):
        return key%10
    
    def add(self, key: int) -> None:
        
        # 1. Cal hash
        index  = self.hash(key)
        
        # 2. Create a dll
        if self.hashList[index] == None:
            self.hashList[index] = doublyLinkedList()
            
        self.hashList[index].insert_dll(key,True)
        
    def remove(self, key: int) -> None:
        # 1. Cal hash
        index  = self.hash(key)
        
        # 2. Check the hashList
        if self.hashList[index] != None:
            self.hashList[index].delete_dll(key)

    def contains(self, key: int) -> bool:
        # 1. Cal hash
        index  = self.hash(key)
        
        # 2. Check the hashList
        if self.hashList[index] != None:
            return self.hashList[index].contains_dll(key)

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)

'''
# ["MyHashSet","add","add","contains","contains","add","contains","remove","contains"]
# [[],         [1],    [2],    [1],    [3],        [2],    [2],        [2],    [2]]
obj = MyHashSet()
obj.add(2)
print('1.\t',obj.hashList[2].print_dll())

obj.add(1)
print('2.\t',obj.hashList[1].print_dll())

print('3.\t',obj.contains(1))

print('4.\t',obj.contains(3))

obj.add(2)
print('5.\t',obj.hashList[2].print_dll())

print('6.\t',obj.contains(2))

obj.remove(2)
print('7.\t',obj.hashList[2].print_dll())

print('8.\t',obj.contains(2))
'''
