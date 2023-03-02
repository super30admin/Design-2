class ListNode:
     def __init__(self,key,value):
         self.key = key
         self.value = value
         self.next = None
         
class MyHashMap:

    def __init__(self):
        self.first_array = [None for i in range(10000)]
   
    def hash(self,key):
        return key % len(self.first_array)   

    def find(self,head,key):
        prev = head
        curr = head.next
        while(curr != None and curr.key != key):
            prev = curr
            curr = curr.next
        return prev

    def put(self, key: int, value: int) -> None:
        idx = hash(key)
        if self.first_array[idx] == None:
            self.first_array[idx]= ListNode(-1,-1)
        # if head already exists
        prev = self.find(self.first_array[idx],key)
        if(prev.next is None):
            newNode = ListNode(key,value)
            prev.next = newNode
        else:
            prev.next.value = value   

    def get(self, key: int) -> int:
        idx = hash(key)   
        if self.first_array[idx] == None: return -1
        prev = self.find(self.first_array[idx],key)
        if(prev.next == None): return -1
        return prev.next.value

    def remove(self, key: int) -> None:
        idx = hash(key)
        if (self.first_array[idx] == None): return
        prev = self.find(self.first_array[idx],key)
        if(prev.next == None): return
        prev.next = prev.next.next
        
        

# Your MyHashMap object will be instantiated and called as such:
obj = MyHashMap()
obj.remove(25)
param_2 = obj.get(26)
obj.put(1,1)
obj.put(2,3)
print(param_2)