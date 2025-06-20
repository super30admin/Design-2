# Time Complexity : O(l) where l is the length of Linked list in a bucket
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes

class Node:
    def __init__(self, key=None, value=None, next=None):
        self.key = key
        self.value = value
        self.next = next
    
class MyHashMap(object):

    def __init__(self):
        self.HashMap = [None]* 1001

    def get_bucket(self, key):
        return key % 1000
    
    def find(self, head, key):
        prev = head
        curr = head.next
        while curr and curr.key != key:
            prev = curr
            curr = curr.next
        return prev

    def put(self, key, value):
        bucket = self.get_bucket(key)
        if self.HashMap[bucket] is None:
            self.HashMap[bucket] = Node(-1, -1)
        dummy = self.HashMap[bucket]
        prev = self.find(dummy, key)
        if prev.next is None:
            prev.next = Node(key, value)
        else:
            prev.next.value = value
        return

    def get(self, key):
        bucket = self.get_bucket(key)
        if self.HashMap[bucket] is None:
            return -1
        dummy = self.HashMap[bucket]
        prev = self.find(dummy,key)
        if prev.next != None:
            return prev.next.value
        return -1

    def remove(self, key):
        bucket = self.get_bucket(key)
        if self.HashMap[bucket] is None:
            return
        dummy = self.HashMap[bucket]
        prev = self.find(dummy,key)
        if prev.next:
            prev.next = prev.next.next
        
obj = MyHashMap()
obj.put(1, 1)
obj.put(2, 2)
output1 = obj.get(1)
print("Value for key 1: ", output1)
output2 = obj.get(3)
print("Value for key 3: ", output2)
obj.put(2, 1)
output3 = obj.get(2)
print("Value for key 2: ", output3)
obj.remove(2)
obj.get(2)