class MyQueue(object):

    def __init__(self):
        self.stack= []
        self.q_stack= []


    def push(self, x):
        """
        Append X.
        :type x: int
        :rtype: None
        """
        self.stack.append(x)
       
        return 

    def pop(self):
        """
        :rtype: int
        """
        self.peek()
        return self.q_stack.pop()

    def peek(self): 
        """
        Return element at 0th index.
        :rtype: int
        """
        if not self.q_stack:     
            # If q_stack is empty append all the elements.
            while self.stack:   
                self.q_stack.append(self.stack.pop())
            # If q_stack has elements, then return the last element in q_stack.
        return self.q_stack[len(self.q_stack)-1]
        

    def empty(self): # O(1)
        """
        :rtype: bool
        """
        if not self.stack and not self.q_stack:
            return True
        return False

# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()