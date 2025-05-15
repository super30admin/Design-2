"""
An array of size 1000 is used, where each index holds a linked list.
put(), get(), and remove() move through the chain using a helper function to find or update nodes.
A dummy node is used for edge cases like inserting/removing at the head.
"""
"""
Time Complexity:
Average: O(1) for put, get, remove
Space Complexity:
O(n) —  n is the number of keys
"""
class Node:

    def __init__(self, key = -1, val = -1, next = None):
        self.key = key
        self.val = val
        self.next = next

class MyHashMap:

    def hashFunc(self,key):
        return key % self.buckets

    def __init__(self):

        self.buckets = 1000
        self.storage = [None] * self.buckets

    def helper(self,head,key):
       
        prev = head
        curr = head.next

        while(curr is not None and curr.key != key):
            prev = curr
            curr = curr.next

        return prev

    def put(self, key: int, value: int) -> None:

        idx1 = self.hashFunc(key)
        if self.storage[idx1] is None:
            self.storage[idx1] =  Node(-1)
        
        prev = self.helper(self.storage[idx1],key)

        if not prev.next:
            prev.next = Node(key,value)
        else:
            prev.next.val = value
                 

    def get(self, key: int) -> int:

        idx1 = self.hashFunc(key)
        if self.storage[idx1] is None:
            return -1
        
        prev = self.helper(self.storage[idx1],key)

        if not prev.next:
            return -1
        
        return prev.next.val
        

    def remove(self, key: int) -> None:

        idx1 = self.hashFunc(key)
        if self.storage[idx1] is None:
            return -1

        prev = self.helper(self.storage[idx1],key)

        if not prev.next:
            return
        
        temp = Node()
        temp = prev.next
        prev.next = prev.next.next
        temp.next = None


# Your MyHashMap object will be instantiated and called as such:


if __name__=="__main__":

    obj = MyHashMap()
    obj.put(2,4)
    obj.put(5,10)
    print(obj.get(2))
    obj.put(2,9)
    print(obj.get(2))
    obj.remove(2)
    print(obj.get(2))