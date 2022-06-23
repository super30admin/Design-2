class Node:
    def __init__(self,key,val):
        self.key = key
        self.val = val
        self.next = None

class MyHashMap:

    def __init__(self):
        self.hashmap = [None] * 10001
        
    def hashfn(self,key):
        return key % 10001
        

    def put(self, key: int, value: int) -> None:
        index = self.hashfn(key)
        new_node = Node(key,value)
        if(self.hashmap[index]==None):
            self.hashmap[index] = new_node
        else:
            curr = self.hashmap[index]
            prev = None
            while(curr is not None):
                if(curr.key == key):
                    curr.val = value
                    return
                prev = curr
                curr = curr.next
            prev.next = new_node
            
        

    def get(self, key: int) -> int:
        index = self.hashfn(key)
        curr = self.hashmap[index]
        while(curr is not None):
            if(curr.key == key):
                return curr.val
            curr = curr.next
        return -1

    def remove(self, key: int) -> None:
        index = self.hashfn(key)
        if(self.hashmap[index] is not None):
            curr = self.hashmap[index]
            prev = curr
            if(curr.key == key):
                self.hashmap[index] = curr.next
            curr = curr.next
            while(curr is not None):
                if(curr.key == key):
                    prev.next = curr.next
                    break
                curr = curr.next
                prev = prev.next
                
                
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)