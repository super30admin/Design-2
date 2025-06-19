# Time Complexity :
    #push operation take constant O(1) time
    #pop / peek operation check if the outStack is empty and transfer the elements to the stack -> O(n)
    #and then checks for peeks or pops the element in O(1)
    #Due to this the average time complexity for this operation is O(1)
# Space Complexity : O(n) - maintaining each stack of size n
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
    #None
    #Good to learn and understand the concept of amortized time complexity

# Your code here along with comments explaining your approach


class MyQueue:

    #initializing two empty stacks
    def __init__(self):
        self.inStack = []
        self.outStack = []

    #push operation simply appends value in the inStack
    def push(self, x: int) -> None:
        self.inStack.append(x)

    #pop operation takes help of peek operation to check if the out stack is empty or not
    #if not uses peek operation to transfer all the elements to the out stack
    #once completed, pops the top element
    def pop(self) -> int:
        self.peek()
        return self.outStack.pop()
        

    #peek operation is first going to check if the elements are present in the out stack or not
    #if not we are going to transfer all the elements from the in stack to out stack
    #then return the first element
    #this peek function can also be used as an intermidiate step in pop operation
    def peek(self) -> int:
        if not self.outStack: #if this is empty
            while self.inStack:
                self.outStack.append(self.inStack.pop())        

        return self.outStack[-1]
        
    #need to check if both the stacks are empty
    def empty(self) -> bool:
        return not self.inStack and not self.outStack
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()