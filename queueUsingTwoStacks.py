#Time complexity:
#push:O(n+n)=O(2n)=O(n)
#pop:O(1)
#peek:O(1)
#empty:O(1)

#Space complexity: 2stacks=O(2n)=O(n): n is number of elements

# To push a new element,
# 1. Move all existing elements from stack1 to stack2
# 2. Push the new element to the now-empty stack1
# 3. Move all elements back from stack2 to stack1

class MyQueue:

    def __init__(self):
        self.s1 = []
        self.s2 = []

    def push(self, x: int) -> None:
        while self.s1:
            self.s2.append(self.s1.pop())
        self.s1.append(x)
        while self.s2:
            self.s1.append(self.s2.pop())

    def pop(self) -> int:
        if not self.s1:
            print("Stack is empty")
            return -1
        top = self.s1.pop()
        return top

    def peek(self) -> int:
        if not self.s1:
            print("Stack is empty")
            return -1
        bottom = self.s1[-1]
        return bottom

    def empty(self) -> bool:
        return not self.s1
    