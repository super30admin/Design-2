# Time Complexity: push O(1), pop amortised O(1), empty O(1), peek O(1)
# Space Complexity: push O(n), pop O(1), empty O(1), peek O(1)
# Did this code successfully run on leetcode: Yes
# Problems faced: None

# Approach:
# since stack is LIFO, 2 staks are needed to perform FIFO.
# pop: whenever the pop operation is called, if the 2nd stack is empty, 
# then pop elements from the 1st stack and push them in 2nd stack. and pop the top element from 2nd stack.
# push: push the elements onto the 1st stack at any time.
# empty: when both stacks are empty, then the queue is empty.
# peek: return top element of stack2. if its empty then return the 1st element pushed onto empty stack 1.

class MyQueue:

    def __init__(self):
        self.st1 = []
        self.st2 = []
        self.front = -1

    def push(self, x: int) -> None:
        if not self.st1:
            self.front = x
        self.st1.append(x) # O(1) time

    def pop(self) -> int:
        if not self.st2:
            while self.st1:
                self.st2.append(self.st1.pop())
        return self.st2.pop() # amortised O(1)

    def peek(self) -> int:
        if not self.st2:
            return self.front
        return self.st2[-1] #O(1)

    def empty(self) -> bool:
        return not self.st1 and not self.st2 #O(1)
             


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()