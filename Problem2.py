'''
Time Complexity - 
put - O(n)
get - O(n)
remove - O(n)

Space Complexity - O(n) for all operations

The code is working on LeetCode
'''


class Node:
    def __init__(self, key, val): #Node Creation
        self.key = key
        self.val = val
        self.next = None

class MyHashMap:

    def __init__(self): #Create the primary data structure
        self.hashMap = [None] * 10000
    
    def hashFunction(self, key):# define the hash function
        return key%10000

    def search(self, key): 
        hash1 = self.hashFunction(key) #get hash for the key
        if self.hashMap[hash1] == None: #check if any key is present for the found hash
            return None #if no key present we return None
        else:
            ptr = self.hashMap[hash1] #else set ptr to point to Node at index hash
            while ptr.next!=None and ptr.next.key != key: #continue till ptr reaches the end or we find the key
                ptr=ptr.next
            return ptr
    
    def put(self, key: int, value: int) -> None:
        hash1 =self.hashFunction(key) #get hash for the key
        ptr = self.search(key) #get the ptr from the search function
        if ptr == None:
            newNode = Node(-1,-1) #create the dummy node if no key present for the hash
            self.hashMap[hash1] = newNode #store the newly created node at the index
            newNode.next = Node(key,value) #make the dummy node point to the newnode of the key 
        else:
            if ptr.next == None: 
                ptr.next = Node(key, value) #if we do not find the key, append at the end of the list
            else:
                ptr.next.val = value #if we find the key in the hashMap just replace the value

    def get(self, key: int) -> int:
        ptr = self.search(key) #search for the key
        if ptr == None or ptr.next == None: #if key is not found
            return -1 #return -1
        else:
            return ptr.next.val #return the value of the key
        

    def remove(self, key: int) -> None:
        ptr = self.search(key) #search for the key
        if ptr != None and ptr.next != None: #check if we found the key
            temp = ptr.next #store the node to be deleted in a temporary pointer 
            ptr.next = temp.next #if we find the key just make the previous node point to the next of the node to be deleted
            del temp #delete the node