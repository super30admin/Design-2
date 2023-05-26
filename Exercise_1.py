# Time complexity: Amortized time complexity O(1) and Worst case O(n) for push and pop.
# Space complexity: O(1)
# Does it work on Leetcode: Yes
# Did you face any problems while doing this: No


# We use a push stack and a pop stack. 
# We only pop from the pop stack and push to the push stack
# If pop stack is empty, we move all elements from push stack into the pop stack for all future pops (until empty again)

class MyQueue:

    def __init__(self):
        self.pushstack = []
        self.popstack = []

    def push(self, x: int) -> None:
        self.pushstack.append(x)

    def pop(self) -> int:
        if not self.popstack:
            while self.pushstack:
                self.popstack.append(self.pushstack.pop())
        return self.popstack.pop()

    def peek(self) -> int:
        if self.popstack:
            return self.popstack[len(self.popstack)-1]
        if self.pushstack:
            return self.pushstack[0]
        

    def empty(self) -> bool:
        return not (self.popstack or self.pushstack)
        