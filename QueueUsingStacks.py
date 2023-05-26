## Time complexity : O(1) for push operation, O(1) amotized for pop and peek operations and the worst case time complexity for pop and peek operations is O(n)
# Space complexity : O(n), where n is the number of elements in the stack
# The code ran on github

class MyQueue:

    def __init__(self):
        # Maintain 2 stacks
        self.inStack = []
        self.outStack = []

    def push(self, x: int) -> None:
        # Directly push elemets into the inStack
        self.inStack.append(x)

    def pop(self) -> int:
        # Return when both stacks are empty
        if self.inStack == [] and self.outStack == []:
            return
        # Pop element from the outStack if an element is present, which is the beginning of the queue
        elif self.outStack != []:
            return self.outStack.pop()
        # If outStack is empty and elements are present in inStack, push elements from inStack to outStack. The top element in outStack is the beginning of the queue
        else:
            while self.inStack:
                self.outStack.append(self.inStack.pop())
        return self.outStack.pop()

    def peek(self) -> int:
        # Same logic as pop operation. This time, the first element in the queue is not popped
        if self.inStack == [] and self.outStack == []:
            return 
        elif self.outStack != []:
            return self.outStack[-1]
        else:
            while self.inStack:
                popped = self.inStack.pop()
                self.outStack.append(popped)
            
        return self.outStack[-1]

    def empty(self) -> bool:
        if self.inStack == [] and self.outStack == []:
            return True
        return False


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()