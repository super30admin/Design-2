# https://leetcode.com/problems/implement-queue-using-stacks/

# As we have to implement FIFO approach we can not use same stack for all operationss. Hence, created two stacks. When we have to apply pop and peek we'll update the second stack and for push we'll update first stack. For checking empty we need to use both stacks

class MyQueue:

    def __init__(self):
        # defining empty list becuase we are pushing elements in in_stack and poping and peeking from out_stack
        self.in_stack = []
        self.out_stack = []
        

    # method to append the element to the back of the queue
    def push(self, x: int) -> None:
        # appending an element into the stack
        self.in_stack.append(x)
        
    def pop(self) -> int:
        # if both stacks are empty it returns -1 (empty meethod declared in block 4)
        if self.empty():
            return -1
        # else call the peek method which returns first element in the list (peek method declared in block 3)
        self.peek()
        # once we get the first element pop it
        return self.out_stack.pop()
        
    
    def peek(self) -> int:
        # proceed if there are elements to look at in the in_stack and out_stack
        if not self.empty():
            # this condition searches if the out_stack is empty
            if not self.out_stack:
                # to get the elements from in_stack to out_stack one by one use while loop
                while self.in_stack:
                    # append the popped element from in_stack into the out_stack
                    self.out_stack.append(self.in_stack.pop())
            # show the last element from the out_stack (which is the first element of the in_stack)
            return self.out_stack[-1]
        # if there is nothing in both list return None
        return None
        

    def empty(self) -> bool:
        # return True if both stacks are empty else return False
        return not self.in_stack and not self.out_stack


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(2)
# obj.push(3)
# obj.push(4)
# param_2 = obj.pop()
# print(param_2)
# param_5 = obj.pop()
# print(param_5)
# param_3 = obj.peek()
# print("peek", param_3)
# param_6 = obj.pop()
# print(param_6)
# param_3 = obj.peek()
# print("peek", param_3)
# param_4 = obj.empty()
# print(param_4)
