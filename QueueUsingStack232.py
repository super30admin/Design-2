# Time Complexity :
# push: O(1) - keeping track of tail allows me to push to the end of a singly linked list in O(1)
# pop:  O(1) - popping from head in a linked list is O(1)
# peek: O(1)
# empty: O(1) - 
# Space Complexity :
# O(1) for all operations
# I use a sentinel node as head to simplify the code. The true head of the linked list is always head.next
# I got stumped by the edge case when popping from a list of size 1 ( need to update tail also if the head is the tail)
 

class MyQueue:

    def __init__(self):
        self.head = ListNode(None)
        self.tail = self.head.next

    def push(self, x: int) -> None:
        if not self.tail:
            self.tail = ListNode(x)
            self.head.next = self.tail
            return
        self.tail.next = ListNode(x)
        self.tail = self.tail.next

    def pop(self) -> int:
        node = self.head.next
        self.head.next = node.next
        if node == self.tail:
            self.tail = None
        return node.val

    def peek(self) -> int:
        return self.head.next.val

    def empty(self) -> bool:
        return self.head.next == None
        
class ListNode:
    def __init__(self, val):
        self.val = val
        self.next = None
