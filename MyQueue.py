"""
Approach:
1. Use 2 stacks - stack1 for push operations, stack2 for pop/peek operations.
   (Stack is LIFO, but reversing a stack's order using a second stack gives FIFO behavior - that's how queue is simulated.)
2. push(): just append to stack1 - O(1), no reordering needed yet.
3. pop()/peek(): if stack2 is empty, transfer all elements from stack1 into stack2 
   (this reverses their order, so the oldest element ends up on top of stack2).
   Then pop()/peek() from stack2 directly.

Dry run:
push(1), push(2), push(3), push(4):
stack1 = [1,2,3,4]   (4 is top/most recent)
stack2 = []

pop():
stack2 is empty -> transfer all from stack1 to stack2:
stack1 = []
stack2 = [4,3,2,1]   (1 is now on top - it was the FIRST pushed, now first to come out)
return stack2.pop() -> returns 1 (correct FIFO order - oldest element out first)

Next pop():
stack2 = [4,3,2] (already has elements, no transfer needed)
return stack2.pop() -> returns 2

empty():
return True only if BOTH stack1 and stack2 are empty

Time Complexity: 
  - push(): O(1) always
  - pop()/peek(): O(1) amortized
  - empty(): O(1)

Space Complexity: O(n) - both stacks combined hold at most n elements total (n = elements pushed)
"""
class MyQueue:

    def __init__(self):
        self.stack1 = []
        self.stack2 = []
        

    def push(self, x: int) -> None:
        self.stack1.append(x)
        

    def pop(self) -> int:
        if not self.stack2:
            while self.stack1:
                self.stack2.append(self.stack1.pop()) 
        return self.stack2.pop()
        

    def peek(self) -> int:
        if not self.stack2:
            while self.stack1:
                self.stack2.append(self.stack1.pop()) 
        return self.stack2[-1]
        

    def empty(self) -> bool:
        if len(self.stack1) == 0 and len(self.stack2) == 0:
            return True
        return False
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()