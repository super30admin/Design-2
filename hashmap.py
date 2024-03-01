# Time complexity is o(1) and space complexity is O(N)
class ListNode:
    def __init__(self, key = -1, value = -1, next = None):
        self.key = key
        self.value = value
        self.next = next
        
class MyHashMap(object):

    def __init__(self):
        self.map = [ListNode() for i in range(1000)]

    def hash(self, key):
        return key%len(self.map)
    
    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: None
        """
        current = self.map[self.hash(key)]
        while current.next:
            if current.next.key == key:
                current.next.value = value
                return
            current = current.next
        current.next = ListNode(key, value)    

    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        current = self.map[self.hash(key)].next
        while current:
            if current.key == key:
                return current.value
            current = current.next
        return -1

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        current = self.map[self.hash(key)]
        while current and current.next:
            if current.next.key == key:
                current.next = current.next.next
                return
            current = current.next