
# Initialize an array-storage of size 10000 with empty Nodes poiting to null. Hash() - perfroms the modulo of the key. Find() will check the modulo of the key%10000 and check storage[hash]. It then iterates through the chain to check if the kep is found. In each iteration, it saves the previous referenaced node. If the match is found, it returns the previous node. Else it returns the current node.
# Find() is called in put, get and remove. 
# Put() - If the Found node.next has key that we are entering, the value is updated. If not and if found.next is null, we create a new node and point the found node to it.
# Get() - If the Found node.next has key that we are entering, the value is returned. If not return -1
# remove() - If the Found node.next has key that we are entering, found is made to point to found.next.next. 

# Time complexity : O(1) <= O(n)
# Space complexity : O(1) <= O(n)



class MyHashMap(object):

    class Node:
        def __init__(self, key, data):
            self.val = data
            self.key = key
            self.next=None    

    def __init__(self):

     
        self.storage = [self.Node(None, None) for i in range(10000)]

    def hash(self, key):
        return key%10000

    def find(self, start, key):
        prev=None
        current = start 
        while current.next!=None:
            prev=current
            current=current.next
            if current.key==key:
                return prev
        return current



    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: None
        """
        map1 = self.hash(key) 
        s_node= self.storage[map1]

        found = self.find(s_node, key)
        if found:
            if found.next!=None and found.next.key == key:
                found.next.val = value
            else:
                new_node = self.Node(key, value)
                found.next = new_node

        

    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        map1=self.hash(key)
        found = self.find(self.storage[map1],key)
        if found.next!=None and found.next.key == key:
            return found.next.val
        else:
            return -1
        
        

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        map1 = self.hash(key)
        s_node = self.storage[map1]
        found = self.find(s_node, key)
        if found.next!=None and found.next.key == key:
            found.next=found.next.next
    

        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)