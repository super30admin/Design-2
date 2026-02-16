# Queues using the stack

#Time complexity O(1) for each operation, SpaceComplexity O(n) where n is the number of elemnts present
# Used 2 stacks, when input is coming keep loadin in satck 1, when popnor peek is called it is removed from stack 2
# stack 2 is filled when it is empty, all the elemnts from the stack 1 is moved to stack to such that top element in
# stack 2 move to bottom on stack 1, giving us FIFO when removing elemnts from stack 2

class MyQueue:

    def __init__(self):
        self.enteringStack = []
        self.outgoingStack = []

    def push(self, x: int) -> None:
        self.enteringStack.append(x)

    def pop(self) -> int:
        self.readjustStacksIfNeeded()
        return self.outgoingStack.pop()

    def peek(self) -> int:
        self.readjustStacksIfNeeded()
        return self.outgoingStack[-1]

    def empty(self) -> bool:
        return (len(self.enteringStack) + len(self.outgoingStack)) == 0 

    def readjustStacksIfNeeded(self):
        #Because of the constraint pop and ppek are valid, no need to check if enteringStack is empty
        #reload the outgoingStack if enteringStack is not empty
        if len(self.outgoingStack) == 0:
            while len (self.enteringStack) > 0:
                self.outgoingStack.append(self.enteringStack.pop())


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()