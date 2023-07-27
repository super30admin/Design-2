# Time Complexity : O(1) for push and empty, O(n) for pop and peek worst case because we need to transfer all the elements to the other stack
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Pop and peek both were taking O(n) time in the worst case, I was able to optimize the pop function to O(1) using Raj Sir's approach. 


# Your code here along with comments explaining your approach
# Impelementing queue using two stacks
# I will be using two stack, one for pushing elements and other for pop and peek operations. empty function will check if both the stacks are empty or not.
# For push operation, I will simply push the element to the inStack.
# For peek operation, I will first check if the outStack is empty, if yes then I will transfer all the elements from inStack to outStack and then return the top element of the outStack.
# For pop operation, I will call the peek operation to reuse the transfer logic and then pop the top element from OutStack and return it.
# For empty operation, I will check if both the stacks are empty or not.


class MyQueue:
    def __init__(self) -> None:
        self.inStack = [] # Stack for push operation
        self.outStack = [] # Stack for peep and pop and transfer logic

    
    def push(self, x):
        # Push the element in the instack
        self.inStack.append(x)

    
    def peek(self):
        
        # Check if the outStack is empty, if yes then transfer the instack elements to the outstack and return the top element

        if not self.outStack:

            # Loop to transfer the instack elements to the outstack
            while self.inStack:
                self.outStack.append(self.inStack.pop())


        # Return the top of self stack
        return self.outStack[-1]
    

    def pop(self):
        # Call peek to use the transfer logic

        self.peek()

        # Pop the top element
        return self.outStack.pop()
    