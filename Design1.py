# Time Complexity : O(1) Amortized
# Space Complexity : O(N) where N is the size of the array 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach:
# I am using 2 array 1D arrays. So I will use one array for the input stack and another for the output stack.When the value 
# has been in pushed it will be pushed into the input array. During pop operation I will first check if the output array is empty.
# If it is empty then I will pop all the elements from the input array and push them into the output array. Finally I will pop
# the element from the output array. Same way I will check the peek if output array is empty I will pop all the elements from
# the input array and push them into the output array. Finally I will return the element from the output array.And for the empty I will check if both input and output are empty.


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
        return not self.input and not self.output
        
