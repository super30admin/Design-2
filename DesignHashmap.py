'''
Time Complexity : All operations O(1)
Space Complexity : O(n+m), where n is size of primary DS and m is size of secondary DS
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
Your code here along with comments explaining your approach:
        primary  DS take as Array of 10000 length
        secondary DS is singly linked list
'''

class ListNode:
    def __init__(self, key = -1, val = -1, next = None):
        self.key = key
        self.val = val
        self.next = next

class MyHashMap:

    def __init__(self):
        self.map = [ListNode() for i in range(10000)]

    def hash(self, key):
        return key%10000

    def find(self, key):
        index = self.hash(key)
        prev = self.map[index]
        curr = self.map[index]

        while curr and curr.key!=key:
            prev = curr
            curr = curr.next
        
        return prev

    def put(self, key: int, value: int) -> None:
        prev = self.find(key)
        if prev.next == None:
            prev.next = ListNode(key, value)
        else:
            prev.next.val = value
        
    def get(self, key: int) -> int:
        prev = self.find(key)
        if prev.next == None:
            return -1
        else:
            return prev.next.val
        
    def remove(self, key: int) -> None:
        prev = self.find(key)
        if prev.next == None:
            return
        else:
            prev.next = prev.next.next


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)