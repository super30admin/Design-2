class MyHashMap:
    class Node:
        def __init__(self,key,val):
            self.key = key
            self.val = val
            self.next = None
        
    def __init__(self):
        self.buckets = 1000
        self.nodes = [None]*self.buckets
    def getbucket(self,key):
        return key%self.buckets
    def find(self,key,head):
        prev = head
        curr = head.next
        while(curr and curr.key !=key):
            prev = curr
            curr = curr.next
        return prev
    
    def put(self, key: int, value: int) -> None:
        index = self.getbucket(key)
        if(self.nodes[index]==None):
            self.nodes[index] = self.Node(-1,-1)
        prev = self.find(key,self.nodes[index])
        if(prev.next is None):
            prev.next = self.Node(key,value)
        else :
            prev.next.val = value
    

    def get(self, key: int) -> int:
        index = self.getbucket(key)
        if(self.nodes[index]==None):
            return -1
        prev = self.find(key,self.nodes[index])
        if(prev.next is None):
            return -1
        else :
            return prev.next.val

    def remove(self, key: int) -> None:
        index = self.getbucket(key)
        if(self.nodes[index]==None):
            return 
        prev = self.find(key,self.nodes[index])
        if(prev.next is None):
            return 
        else :
            prev.next = prev.next.next



# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)