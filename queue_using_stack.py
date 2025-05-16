
# queue implementation with the help of two stacks.
# stack has been implemented using python deque collection


from collections import deque

class Q:
    def __init__(self):
        self.stk1 = deque()
        self.stk2 = deque()
        self.front = -1
    
    def push(self, num):
        while (len(self.stk1) != 0):
            element = self.stk1.pop()
            self.stk2.append(element)

        self.stk2.append(num)
        self.front = num

        while (len(self.stk2) != 0):
            element = self.stk2.pop()
            self.stk1.append(element)
        return
    
    def pop(self) -> int:
        if (len(self.stk1) <= 0):
            raise Exception("queue empty")
        element = self.stk1.pop()
        self.front = self.stk1[0]
        return element

    def peek(self) -> int:
        if len(self.stk1) == 0:
            raise Exception("queue empty")
        return self.stk1[0]
    
    def empty(self) -> bool:
        if len(self.stk1) == 0:
            return True
        return False

if __name__ == "__main__":
    q = Q()
    q.push(1)
    q.push(2)
    q.push(3)
    q.pop()
    q.push(4)
    print(q.peek())
