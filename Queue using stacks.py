#Time complexity: push and pop O(1)-amortized, worstcase: pop is O(n)
#space complexity: O(n)
# Approach:
# have two stacks. whenever there is push, push the element into stack 1.
#when there is pop, check if stack is empty. if empty, pop all the elements from stack1 and push into stack2.
#pop top element of stack2 and return it.

class MyQueue:

    def __init__(self):
        self.stack_in = []
        self.stack_out = []
        

    def push(self, x: int) -> None:
        self.stack_in.append(x)
        

    def pop(self) -> int:
        self.peek()
        return self.stack_out.pop()
        

    def peek(self) -> int:
        if(not self.stack_out):
            while(self.stack_in):
                self.stack_out.append(self.stack_in.pop())
        return self.stack_out[-1]
        

    def empty(self) -> bool:
        return not self.stack_in and not self.stack_out
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()