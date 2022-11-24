#Time Complexity: push-O(1) pop-avg O(1) peek-ave O(1) empty-O(1)
#Space Complexity: O(N)
#Successfully ran on leetcode

class MyQueue:

    def __init__(self):
        self.inStack = []
        self.outStack = []

    def push(self, x: int) -> None:
        self.inStack.append(x)
        
    def pop(self) -> int:
        if len(self.outStack) == 0:
            for i in range(len(self.inStack)):
                self.outStack.append(self.inStack.pop())
            return self.outStack.pop()
        else:
            return self.outStack.pop()

    def peek(self) -> int:
        if len(self.outStack) == 0:
            for i in range(len(self.inStack)):
                self.outStack.append(self.inStack.pop())
            return self.outStack[-1]
        else:
            return self.outStack[-1]
        
    def empty(self) -> bool:
        if len(self.inStack) == 0 and len(self.outStack) == 0:
            return True


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()