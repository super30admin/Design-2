class ListNode: 
    def __init__(self, key=None, val=None, next=None):
        self.key = key
        self.val = val
        self.next = None


class MyHashMap:

    def __init__(self):
        self.size = 1000
        self.buckets = [None] * self.size 

    def hashFunction(self, key: int) -> int:
        return key % self.size

        
        

    def put(self, key: int, value: int) -> None:
        index = self.hashFunction(key)
        currNode = self.buckets[index]

        if not currNode: 
            self.buckets[index] = ListNode(key,value)
        else: 
            while currNode: 
                if currNode.key == key: 
                    currNode.val = value 
                    return
                if not currNode.next:
                    break
                
                currNode = currNode.next
            currNode.next = ListNode(key,value)
                

    def get(self, key: int) -> int:
       index = self.hashFunction(key)
       currNode = self.buckets[index]
       while currNode: 
            if currNode.key == key: 
                return currNode.val
            currNode = currNode.next
       return -1 

        

    def remove(self, key: int) -> None:
        index = self.hashFunction(key)
        currNode = self.buckets[index] 
        if not currNode: 
            return 
        if currNode.key == key:
            self.buckets[index] = currNode.next
        prev = currNode
        currNode = currNode.next
        
        while currNode: 
            if currNode.key == key: 
                prev.next = currNode.next
                return 
            prev = currNode 
            currNode = currNode.next



        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)