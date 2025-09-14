'''Problem 2:

Design Hashmap (https://leetcode.com/problems/design-hashmap/)
'''

class MyHashMap:

    class Node:
        def __init__(self, key = None, value = None, next = None):
            self.key = key
            self.value = value
            self.next = None

    def __init__(self):
        self.arr = [None] * 10000

    def find(self, head, key):
        prev = None
        curr = head
        while curr != None and curr.key != key:
            prev = curr
            curr = curr.next 
        return prev

    def hash_func(self, key):
        return key % 10000           

    def put(self, key: int, value: int) -> None:
        idx = self.hash_func(key)
        if self.arr[idx] == None:
            self.arr[idx] = self.Node(-1, -1) #dummy node

        #if key exist update value, if doesnt exist create new node
        prev = self.find(self.arr[idx], key)   
        if prev.next == None: #we were not able to find key
            prev.next = self.Node(key, value, None)

        else:
            prev.next.value = value     

    def get(self, key: int) -> int:
        idx = self.hash_func(key)
        if self.arr[idx] == None: #no linked list initiated
            return -1
        else:
            prev = self.find(self.arr[idx], key)
            if prev.next != None:#the node which we require exists in linked list
                return prev.next.value
            else:
                return -1 #key does not exists in linked list    

    def remove(self, key: int) -> None:
        idx = self.hash_func(key)
        if self.arr[idx] == None:
            return 
        else:
            prev = self.find(self.arr[idx], key)
            if prev.next == None:
                return
            else:
                prev.next = prev.next.next        
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)