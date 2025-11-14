"""
we create two stacks and call them in and out, the out will have elements popped from the instack
we will push the elements from instack to outstack so we find a FIFO operation easy
to pop in fifo fashion, we pop elements out of the outstack. and if outstack is empty then we pop elements from the in to out stack
to peek, we use the top element of the outstack, and if outstack is empty, we pop the element from instack to outstack and then return top of outstack
check if the out and in - both are empty, return true
TC is O(1) in avg case and SC is O(N)
"""

class MyQueue(object):

    def __init__(self):
        self.in_stack = []
        self.out_stack = []

        

    def push(self, x):
        """s
        :type x: int
        :rtype: None
        """
        self.in_stack.append(x)
    
        

    def pop(self):
        """
        :rtype: int
        """
       
        if self.empty():
            return -1
        self.peek() #if the outstack doesnt have elements in order i.e. it is empty, then this will fill in the instack
        return self.out_stack.pop()
        

    def peek(self):
        """
        :rtype: int
        """
        if not self.out_stack: #if the out stack is empty
            while self.in_stack: #if there are elements in the instack, then 
                self.out_stack.append((self.in_stack.pop())) #pop the elements from the instack and then append it to the outstack
        return self.out_stack[-1] #return the top of outstack
        

    def empty(self):
        """
        :rtype: bool
        """
        return not self.in_stack and not self.out_stack #checks if both the stacks are empty


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()