#Time Complexity : O(1)
#Space Complexity : O(n)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : syntax issues 

#Your code here along with comments explaining your approach
class Node:
    def __init__(self, key, value):    # initialize a Node
        self.key = key
        self.value = value
        self.next = None

class MyHashMap(object):

    def __init__(self):                
        self.buckets=10000             #number of buckets 
        self.storage=[None]*self.buckets #initialize the storage
    
    def _hash(self,key):
        return key % self.buckets      #get the index of the bucket
        
    def getPrev(self, head, key):
        prev=None                      #start with previous assigned to None
        curr=head                      # start from the head of the list
        while(curr!=None and curr.key!=key): #search for the key till the end 
            prev=curr                        #keep track of the prev pointer
            curr=curr.next                   #keep track of the next pointer 
        return prev                          # return the prev pointer

    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: None
        """
        index=self._hash(key)         #get the index
        if self.storage[index] is None: # if nothing is present
            self.storage[index]=Node(-1,-1) # assign a dummy node
            self.storage[index].next=Node(key,value) #attach the new Node to the dummy node
            return
        prev=self.getPrev(self.storage[index],key) # get the previous node
        if prev.next is None:                      # if it is at the end the attach the new node there
            prev.next=Node(key,value)
        else:
            prev.next.value=value                 # if it is not the end update the value
        

    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        index=self._hash(key)            #get the index
        if self.storage[index] is None:  # if nothing is present just return -1
            return -1
        prev=self.getPrev(self.storage[index],key)  # get the previous node
        if prev.next is None:     #if it is at the end the key is not there return -1
            return -1
        else:
            return prev.next.value   # if it is not the end return the value of the next node
        

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        index=self._hash(key)             #get the index
        if self.storage[index] is None:   # if nothing is present just return
            return
        prev=self.getPrev(self.storage[index],key)   # get the previous node
        if prev.next is None:             #if it is at the end the key is not there just return
            return
        else:                            # if it is not the end remove the node
            curr=prev.next
            prev.next=curr.next
            curr.next=None

        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)