# // Time Complexity : O(1) in amortized time for all functions. Peek and Pop might take more time once in a while to copy data from one stack to other
# // Space Complexity : O(n) since we are always saving max of n elements though we are using two stacks. We can consider it as O(2n) if we are using fixed length stack/list
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : None

# // Your code here along with comments explaining your approach
# Approach is to create two stacks, one for input and one for output. Pop all the values from input to output when Pop/Peek is called
# This makes sure all the values pushed so far are put in the reverse order to output, this giving us data in FIFO order in output
# Output is not empty, then there are still elements to be poped in order they came, before we have to copy the rest of the items from input,
# That is the reason behind copying from input to output only when output is empty

# Solution
class MyQueue:

    def __init__(self):
        self.input = []
        self.output = []
        

    def push(self, x: int) -> None:
        self.input.append(x)
        

    def pop(self) -> int:
        self.peek()
        return self.output.pop()
        

    def peek(self) -> int:
        if not self.output:
            while self.input:
                self.output.append(self.input.pop())
        
        return self.output[-1]
        

    def empty(self) -> bool:
        if not self.input and not self.output:
            return True