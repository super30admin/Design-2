# // Time Complexity : O(1)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : While implementing LinkedList. other than that, nothing. 


# // Your code here along with comments explaining your approach

# '''
# In this approach, a primary array is initialized, and then we implement linear chaining. The secondary data structure is linked list.
# '''

class MyHashMap:
    class ListNode:
        def __init__(self, key, val):
            self.key = key
            self.val = val
            self.next = None

    def __init__(self):
        self.array = [None] * 10000

    def hash_func(self, key):
        return key % 10000
      
    #Search funciton for linkedlist
    def search(self, head, key):
        prev_node = None
        cur_node = head
        while cur_node is not None and cur_node.key != key:
            prev_node = cur_node
            cur_node = cur_node.next
        return prev_node
    #Add the value
    def put(self, key: int, value: int) -> None:
        idx = self.hash_func(key)

        #Generates dummy node
        if self.array[idx] is None:
            self.array[idx] = self.ListNode(-1, -1) 

        prev_node = self.search(self.array[idx], key)
        #new node
        if prev_node.next is None:
            prev_node.next = self.ListNode(key, value)
        #update existing node
        else:
            prev_node.next.val = value

    #Get the value if it exists
    def get(self, key: int) -> int:
        idx = self.hash_func(key)

        if self.array[idx] is None: 
            return -1
        
        prev_node = self.search(self.array[idx], key)
        #new node
        if prev_node.next is None:
            return -1
        return prev_node.next.val   
    #remove the value
    def remove(self, key: int) -> None:
        idx = self.hash_func(key)

        if self.array[idx] is None: 
            return 
        
        prev_node = self.search(self.array[idx], key)
        #new node
        if prev_node.next is None:
            return 
        temp = prev_node.next
        prev_node.next = prev_node.next.next 
        temp.next = None


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
