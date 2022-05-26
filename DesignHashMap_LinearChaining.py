class Node:
    def __init__(self,key=None,value=None, next=None):
        self.key=key
        self.value=value
        self.next=None
        

class MyHashMap(object):

    def __init__(self):
        self.buckets=10000
        self.table=[None]*self.buckets
        
    def hashingFunction(self,key):
        return key%self.buckets

    def find(self, head, key):
        prevPointer=None
        currPointer=head
        while currPointer is not None and currPointer.key != key:
            prevPointer=currPointer
            currPointer=currPointer.next
        return prevPointer
        
    
    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: None
        """
        primaryIndex= self.hashingFunction(key)
        if self.table[primaryIndex] is None:
            self.table[primaryIndex]=Node(None,None)
        prevPointer=self.find(self.table[primaryIndex],key)
        if prevPointer.next is not None:
            prevPointer.next.value=value
        else:
            prevPointer.next=Node(key,value)
            
            

    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        primaryIndex= self.hashingFunction(key)
        if self.table[primaryIndex] is None:
            return -1
        else:
            prevPointer=self.find(self.table[primaryIndex],key)
            if prevPointer.next is not None:
                return prevPointer.next.value
            else:
                return -1
        

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        primaryIndex= self.hashingFunction(key)
        if self.table[primaryIndex] is not None:
            prevPointer=self.find(self.table[primaryIndex],key)
            if prevPointer.next is not None:
                prevPointer.next=prevPointer.next.next
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
