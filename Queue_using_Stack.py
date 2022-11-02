# Time Complexity: O(1) for push, O(1) for empty
#                  For peek and pop: O(1) average case, O(N) worst case(when out stack is empty and we need to copy elements)
# Space Complexity: O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class MyQueue:

    # we maintain 2 stack in & out
    # when we get a pop we copy the elements of in stack to out stack in a reverse manner
    # i.e top of in stack goes at the bottom of out stack till the in stack is empty
    # and pop from the top of the out stack
    def __init__(self):
        self.in_stack = list()
        self.out_stack = list()

    def push(self, x: int) -> None:
        self.in_stack.append(x)

    # the peek function will populate the out stack if it's empty
    # which might take O(N) ,if empty
    # else if the out stack is not empty, it will just pop the element O(1)
    def pop(self) -> int:
        self.peek()
        return self.out_stack.pop()

    # return top of the out stack
    # if the out stack is empty, we copy all elements from in stack to out stack in reverse
    # until in stack is empty and return top of the out stack
    def peek(self) -> int:
        if len(self.out_stack) == 0:
            while self.in_stack:
                self.out_stack.append(self.in_stack.pop())
        return self.out_stack[-1]

    # if both stacks are empty then return True
    def empty(self) -> bool:
        return not (self.in_stack or self.out_stack)



# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()