# // Time Complexity : worst case - if keys are added to a single bucket then O(n) for put, get remove, else O(1) armotized for all operations
# // Space Complexity : O(1) pe rnew key so total O(n), remove or get O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : had some trouble in setting the linked list way, watched the video again

class MyHashMap(object):
    # hashmap/ dictionary has 
    # key, value ( as we need key value pair the best is to use linked list under the hood so we can keep track of the head, vakue and thr next also)

    class Node:
        def __init__(self, key, value, next=None):
            self.key = key
            self.value = value
            self.next = next

    def __init__(self):
        self.size = 1000
        self.buckets = [None] * self.size

    def hash(self,key):
        return key%self.size

    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: None
        """
        index = self.hash(key) # get thast hash 
        if not self.buckets[index]: # not intialized yet, create the linked list, save the key value pair and return
             self.buckets[index] = self.Node(key,value) 
             return 
        
        curr = self.buckets[index] # if linked list ecist traverse through the linked list to update/put value
        while curr:
            if curr.key == key:
                curr.value = value  # step -1 once key found, updating the value
                return
            if not curr.next :
                break  # step-3 key not found, reached the end of the linked list, break the for loop
            curr = curr.next #  step -2 keep iterating to find the key in the current linked list 

        # step-4 Create a new node in the end and update the key value pair and return
        curr.next = self.Node(key, value) 

    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        index = self.hash(key) # found the hash where the linked list for the key has created
        curr = self.buckets[index]  
        while curr:
            if curr.key == key: # if the key is found in the linked list, return the value which gives the get of the key 
                return curr.value
            curr = curr.next
        return -1 # if the key is not found return -1

    # for remove we need the previous node 
    def prev(self,head,key):
        prev = None
        curr = head

        while curr and curr.key != key:
            prev = curr
            curr = curr.next # when the curr.key is key , the prev node will be the prev 

        return prev

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        index = self.hash(key)           # 1. Get bucket index
        if not self.buckets[index]:      # 2. If bucket empty, nothing to remove
            return

        prev = self.prev(self.buckets[index], key)  # 3. Get previous node
        if prev is None:
            # Key is at the head of the list
            self.buckets[index] = self.buckets[index].next
        elif prev.next:
            # Skip the key node, by moving the next node to next of next ( which skips the current node)
            prev.next = prev.next.next


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)