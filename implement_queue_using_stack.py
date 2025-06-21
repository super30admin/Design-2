# Time Complexity : push and empty O(1), peek and pop Amortized O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach in three sentences only


class MyQueue:

    def __init__(self):
        #Initialize 2 stacks, in_stack for push,out_stack for pop and peek
        self.in_stack = []
        self.out_stack = []

    def push(self, x: int) -> None:
        #Appending elements to in_stack
        self.in_stack.append(x)

    def pop(self) -> int:
        # calling peek function here to avoid code duplication
        self.peek()
        # popping first element from the out stack
        return self.out_stack.pop()

    def peek(self) -> int:
        #If out_stack is empty transferring elements from in_stack to out_stack (Elements will be reversed)
        if not self.out_stack:
            while self.in_stack:
                self.out_stack.append(self.in_stack.pop())
        # returning the top element from out_stack
        return self.out_stack[-1]

    def empty(self) -> bool:
        # check if in and out stacks are empty or not and return the bool value
        return not self.in_stack and not self.out_stack

# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()