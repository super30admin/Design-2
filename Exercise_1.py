# Time Complexity : O(1) for all operations amortized
# Space Complexity : O(n) where n is the number of elements in the queue
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : The implementation for the pop operation was confusing at first but got it right, used normal arrays instead of deque helped saved time on LC
class MyQueue:

    def __init__(self):
        self.inc = []
        self.out = []

    def push(self, x: int) -> None:
        # push new element to top of the inc stack
        self.inc.append(x)
        

    def pop(self) -> int:
        # if outgoing stack empty, then transfer all inc elements to out stack
        if len(self.out) == 0:
            while len(self.inc)!=0:
                self.out.append(self.inc.pop())
        # pop last element from out stack else none
        return self.out.pop() if len(self.out)>0 else None
        

    def peek(self) -> int:
        # if outgoing stack empty, then transfer all inc elements to out stack
        if len(self.out) == 0:
            while len(self.inc)!=0:
                self.out.append(self.inc.pop())
        # return last element from out stack else none
        return self.out[-1] if len(self.out)>0 else None
        

    def empty(self) -> bool:
        if len(self.inc) == 0 and len(self.out) == 0:
            return True
        return False
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()