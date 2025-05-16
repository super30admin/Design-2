# hashmap implemented by taking array of items.
# depending upon the hash value, insertion/deletion/get is done in the individual 
# linked list's for that item.

import sys

class Node:
    def __init__(self, key=-sys.maxsize-1, val=0, next=None):
        self.key = key
        self.val = val
        self.next = next

class Bucket:
    def __init__(self):
        self.head = Node()

    def add(self, my_tuple) -> None:
        key, value = my_tuple
        update_done = False
        if (self.head.key == -sys.maxsize-1):
            self.head.key = key
            self.head.val = value
        else:
            tempNode = self.head
            if tempNode.next is None:
                if tempNode.key == key:
                    tempNode.val = value
            else:
                while (tempNode.next):
                    if tempNode.key == key:
                        tempNode.val = value
                        update_done = True
                        break
                    tempNode = tempNode.next
                if not update_done:
                    newNode = Node(key, value)    
                    tempNode.next = newNode

    def delete(self, num) -> None:
        if self.head.key == -sys.maxsize-1:
            return -1
        tempNode = self.head
        if tempNode.next is None:
            tempNode.key = 0
            tempNode.val = 0
        while (tempNode and tempNode.next):
            if tempNode.next.key == num:
                tempNode.next = tempNode.next.next

    def get(self, num) -> int:
        if self.head.key == -sys.maxsize-1:
            return -1
        tempNode = self.head
        if tempNode.next is None and tempNode.key != 0:
            return tempNode.val
        while tempNode.next:
            if tempNode.key == num:
                return tempNode.val
        return -1

class MyHashMap:

    def __init__(self):
        self._buckets = [Bucket() for i in range(1,100)]

    def hash_function(self, key) -> int:
        new_key = key % 100
        return new_key

    def put(self, key, value) -> None:
        new_key = self.hash_function(key)
        self._buckets[new_key].add((key, value))
        return
    
    def get(self, key) -> int:
        new_key = self.hash_function(key)
        return self._buckets[new_key].get(key)
    
    def remove(self, key) -> None:
        new_key = self.hash_function(key)
        self._buckets[new_key].delete(key)
        return

if __name__ == "__main__":
    myHashMap = MyHashMap()
    myHashMap.put(1,2)
    print(myHashMap.get(1))
    myHashMap.remove(1)
    print(myHashMap.get(1))
    myHashMap.put(2,3)
    myHashMap.put(2,5)
    myHashMap.put(2,8)
    print(myHashMap.get(2))
