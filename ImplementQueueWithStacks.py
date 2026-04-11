# TimeComplexity 
## Push --> O(1), Pop --> O(N), Amortized O(1), Peek --> O(1), Empty --> O(1)
# Space Complexity
## O(N)

# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
## Utilizing 2 stacks, one to push all the inputs coming in and the other to pop out the 1st element

class MyQueue:

    def __init__(self):
        self.st1 = []
        self.st2 = []

    def push(self, x: int) -> None:
        self.st1.append(x)

    def pop(self) -> int:
        if len(self.st2)==0:
            for i in range(len(self.st1)):
                self.st2.append(self.st1.pop())
        return self.st2.pop()

    def peek(self) -> int:
        if len(self.st2)==0:
            for i in range(len(self.st1)):
                self.st2.append(self.st1.pop())
        return self.st2[-1]

    def empty(self) -> bool:
        if len(self.st1)==0 and len(self.st2)==0:
            return True
        return False
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()