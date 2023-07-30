#Time complexity:O(1)
#Space complexity:-O(1)

class MyQueue:

    def __init__(self):
        # Initialize two empty stacks, instack for pushing elements and
        # outstack for popping elements.
        self.instack=[]
        self.outstack=[]

    def push(self, x: int) -> None:
        # Push the given element 'x' onto the instack.
        self.instack.append(x)
        

    def pop(self) -> int:
         # Ensure that the outstack contains the elements in the reversed order of instack.
         #  This is done by calling the peek method.
        self.peek()
        return self.outstack.pop()
        

    def peek(self) -> int:
        # If the outstack is empty, it means all elements in instack are not in the right order for popping (they are currently in LIFO order).
        # So, we transfer the elements from instack to outstack, effectively
        # reversing their order and making them ready for popping.
        if not self.outstack:
            while self.instack:
                self.outstack.append(self.instack.pop())
        # Return the top element from the outstack without popping it.
        return self.outstack[-1]
        

    def empty(self) -> bool:
        # The queue is considered empty if both the instack and outstack
        # are empty, as there are no elements to pop or peek.
        return not self.instack and not self.outstack
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()