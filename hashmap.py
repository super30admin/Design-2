'''
to avoid collision, use the linear chaining method, where in we use linkedlist as our data structue, create a helper funcion for getting a hash function to find the value of the no. of bucket out key would go in
then a fucntion that fetches prec element, so that it will be resued in further get and put methods as well. for put, we want to check if there alreadt exists a head, if not make a dummy head, 
then append the current value to be inserted now as the .next, if there exists a head, fetch its prev and see if there alreeady exisits a vale, if if does, update it to current value, else store the value in next element to the prev
more or less, similar logic for the get and remove method
TC is O(1) for avg case and SC is o(N)
'''

class MyHashMap(object):

    def __init__(self):
        self.buckets = 1000
        self.storage = [None] * self.buckets

    class Node:
        def __init__(self, key, value):
            self.key = key
            self.val = value
            self.next = None
        
    def hash_func(self, key):
        return key % self.buckets
    
    def find_prev(self, head, key): #helper function to get the prec node of the given key
        prev = None
        curr = head
        while curr and curr.key != key:
            prev = curr
            curr = curr.next
        return prev

    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: None
        """
        idx = self.hash_func(key)
        if self.storage[idx] is None:
            self.storage[idx] = self.Node(-1,-1) #create dummy node is the bucket is empty
            self.storage[idx].next = self.Node(key, value)
            return
        prev = self.find_prev(self.storage[idx], key)
        if prev.next is None: #its the last element
            prev.next = self.Node(key, value) #key not cound, so append the new node
        else:
            prev.next.value = value #key found, so update the value of it

        

    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        idx = self.hash_func(key)
        if self.storage[idx] is None:
            return -1 #its absent
        prev = self.find_prev(self.storage[idx], key)
        if prev.next is None: #its the last element
            return -1
        return prev.next.value #if not, return value of the next element of the prev we found

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        idx = self.hash_func(key)
        if self.storage[idx] is None:
            return  #its absent
        prev = self.find_prev(self.storage[idx], key)
        if prev.next is None:
            return
        prev.next = prev.next.next #remove the link


