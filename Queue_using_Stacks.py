#Time Complexity : O(1)
#Space Complexity : O(n)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : syntax issues 

#Your code here along with comments explaining your approach

class MyQueue(object):

    def __init__(self):
        self.inStack=[]          # define Stack to store the input elements
        self.outStack=[]         # define stack to store the elements to be poped 
        

    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        self.inStack.append(x)    #just append the element to the inStack
        

    def pop(self):
        """
        :rtype: int
        """
        if not self.outStack:      # check if the outward stack is empty
            while self.inStack:    # copy the elements from the instack to the outstack
                self.outStack.append(self.inStack.pop())
        return self.outStack.pop()  # return the element from the outstack

    def peek(self):
        """
        :rtype: int
        """
        if not self.outStack:       # check if the outward stack is empty
            while self.inStack:     # copy the elements from the instack to the outstack
                self.outStack.append(self.inStack.pop())
        return self.outStack[-1]    # display the element from the outstack
        

    def empty(self):
        """
        :rtype: bool
        """
        return not self.outStack and not self.inStack # both need to be empty
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()