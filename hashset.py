class Node():
    def __init__(self, val):
        self.data = val
        self.next = None    
        
class MyHashSet:
    #Implementation is fairly similar to a hashmap, difference here is there is no key only unique values
    #hashset is indexed by slots, each slot has a linkedlist with data val
    #we put, get and remove by looking up the key goes in which slot and then add/find/remove the Node with the value
    # Time Complexity : O(1) best case if chain is of size 1 else in worst case becomes O(n)
    # Space Complexity : O(n)
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.slots = 1000
        self.hashset = [None]*self.slots

    def add(self, key: int) -> None:
        index = key%self.slots
        
        if(self.hashset[index]==None):
            self.hashset[index] = Node(key)
        else:
            current_node = self.hashset[index]
            
            while(current_node.next and current_node.data!=key):
                current_node = current_node.next
            
            if(current_node.data!=key):
                current_node.next = Node(key)

    def remove(self, key: int) -> None:
        index = key%self.slots
        
        if(self.hashset[index]==None):
            return None
        elif(self.hashset[index].data==key):
            self.hashset[index] = self.hashset[index].next
        else:
            current_node = self.hashset[index]
            prev_node = self.hashset[index]
            
            while(current_node.next and current_node.data!=key):
                prev_node = current_node
                current_node = current_node.next
            
            if(current_node.data==key):
                prev_node.next = current_node.next
            else:
                return None
        

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        index = key%self.slots
        
        if(self.hashset[index]==None):
            return False
        else:
            current_node = self.hashset[index]
            
            while(current_node.next and current_node.data!=key):
                current_node = current_node.next
            
            if(current_node.data==key):
                return True 
            else:
                return False


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)