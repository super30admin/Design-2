class Node:
    def __init__(self, key, nextnode = None):
        self.key = key
        self.next = nextnode
class Bucket:
    def __init__(self):
        self.head = Node(0)
        self.tail = self.head
        
    def insert(self, key):
        if not self.find(key):
            nxtnode = Node(key)
            self.tail.next = nxtnode
            self.tail = nxtnode

    def find(self, key):
        ptr = self.head.next
        while ptr:
            if ptr.key == key:
                return True
            ptr = ptr.next
        return False
    
    def delete(self,key):
        ptr = self.head
        while ptr.next != None:
            if ptr.next.key == key:
                tmp = ptr.next
                ptr.next = ptr.next.next
                tmp.next = None
                break
            ptr = ptr.next           

class MyHashSet:

    def __init__(self):
        self.base_modulo = 769
        self.keys_arr = [Bucket() for i in range(self.base_modulo)]
        

    def add(self, key: int) -> None:
        hash_key = key % self.base_modulo
        self.keys_arr[hash_key].insert(key)
        
    def remove(self, key: int) -> None:
        hash_key = key % self.base_modulo
        self.keys_arr[hash_key].delete (key)
        
    def contains(self, key: int) -> bool:
        hash_key = key % self.base_modulo
        return self.keys_arr[hash_key].find(key)
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)