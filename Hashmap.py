# // Time Complexity :O(1)
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
#### Using linear chaining 
class Node:
    ## we make a node class here to use for linked list
    def __init__(self, key, val):
        self.key = key
        self.val = val
        self.next = None
class Hashmap:
    def __init__(self):
        ## we define an original primary storgae of length 10000 as opposed to 1000 in the array method
        ## this is because it is much more optimal to do it this way for a balanced storage
        self.storage = [None]* 10000

    ## this find helper function will be useful to iterate over the linked luist to see if we have found a key or not
    def find(self, head, key):
        curr = head
        prev = None

        while curr and curr.key != key:
            prev = curr
            curr = curr.next
        
        return prev
    ## we get the index of the storage using hashing functioj
    ## Then we check if there is any pointer to a linked list at that index, if not we create a Node
    ## if there is linked list , we find the node with the key and if the key exists we update the value else we create a new node with 
    ## key and val
    def put(self, key, val):
        primaryidx = key%10000

        if self.storage[primaryidx] == None:
            self.storage[primaryidx] = Node(-1,-1)
        
        prev = self.find(self.storage[primaryidx], key)

        if prev.next == None:
            prev.next = Node(key, val)
        else:
            prev.next.val = val
    
    ## we again use find to see if the node exists, if it does then we find the value and return it
    def get(self, key):
        primaryidx = key%10000

        if self.storage[primaryidx] == None:
            return -1
        
        prev = self.find(self.storage[primaryidx], key)
        if prev.next == None: 
            return -1
        return prev.next.val
    
    ## we use the find function to find if node exists, if it does then we delete that node
    def remove(self, key):
        primaryidx = key%10000

        if self.storage[primaryidx] == None:
            return -1
        
        prev = self.find(self.storage[primaryidx], key)

        if prev.next == None:
            return -1
        
        prev.next = prev.next.next



#### Using double hashing

class Hashmap_DH:
    def __init__(self):
        self.storage = [None]*1000
    
    def put(self, key, val):
        primaryidx = key%1000
        secondaryidx = key//1000

        if self.storage[primaryidx] == None:
            if primaryidx == 0:
                self.storage[primaryidx] = []*(1001)
            else:
                self.storage[primaryidx] = [None]*(1000)
        
        self.storage[primaryidx][secondaryidx] = val

    def get(self, key):
        primaryidx = key%1000
        secondaryidx = key//1000

        if self.storage[primaryidx] == None or self.storage[primaryidx][secondaryidx] == None:
            return -1
        
        return self.storage[primaryidx][secondaryidx]
    
    def remove(self, key):
        primaryidx = key%1000
        secondaryidx = key//1000

        if self.storage[primaryidx] == None:
            return -1
        
        self.storage[primaryidx][secondaryidx] = None








