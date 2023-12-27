class quenod(object):
    def __init__(self,val):
        self.val = val
        self.next = None

class MyQueue:

    def __init__(self):
        self.head = None
        self.tail = None
    def push(self, x: int) -> None:
        nod = quenod(x)
        if not self.head:
            self.head = nod
            self.tail = nod
        else:
            self.tail.next = nod
            self.tail = nod 
    def pop(self) -> int:
        temp = self.head
        self.head = temp.next
        return temp.val

    def peek(self) -> int:
        return self.head.val

    def empty(self) -> bool:
        return self.head == None
