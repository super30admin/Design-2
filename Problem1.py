# Time Complexity : Amortized O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Stack:
    def __init__(self):
        self.arr = []
        self.arrsize  = 0
    
    def push(self,val: int) -> None:
        self.arr.append(val)
        self.arrsize += 1
        
    def pop(self):
        if self.isEmpty():
            return None
        self.arrsize -= 1
        return self.arr.pop()
    def size(self):
        return self.arrsize
    def isEmpty(self):
        if self.arrsize == 0:
            return True
        return False
    def top(self):
        if self.isEmpty():
            return None
        return self.arr[self.arrsize - 1]

class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.pushStack = Stack()
        self.popStack = Stack()
        self.top = None
        

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        if self.top == None:
            self.top = x
        if self.pushStack.size() == 0:
            if self.popStack.size() == 0:
                self.pushStack.push(x)
            else:
                while self.popStack.size() != 0:
                    self.pushStack.push(self.popStack.pop())
                self.pushStack.push(x)
        else:
            self.pushStack.push(x)
        

    def pop(self) -> int:
        if self.popStack.size() == 0:
            if self.pushStack.size() == 0:
                self.top = None
                return None
            else:
                while self.pushStack.size() != 0:
                    self.popStack.push(self.pushStack.pop())
                x = self.popStack.pop()
                self.top = self.popStack.top()
                return x
        else:
            x = self.popStack.pop()
            self.top = self.popStack.top()
            return x
        

    def peek(self) -> int:
        return self.top
        

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        if self.popStack.size() == 0 and self.pushStack.size() == 0:
            return True
        return False


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()