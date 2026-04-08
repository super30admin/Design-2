#// Time Complexity : Amortised O(1), Worst case O(n)
#// Space Complexity : O(n)
#// Did this code successfully run on Leetcode : Yes
#// Any problem you faced while coding this : No


#// Your code here along with comments explaining your approach
# Use one in stock to push and other out stack to pop. 
# When pop or peek is called, check if out stack is empty.
# If it is empty then pop all elements from in stack and push to out stack. 

class MyQueue(object):

    def __init__(self):
        self.in_stack = []
        self.out_stack = []
        

    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        self.in_stack.append(x)

    def pop(self):
        """
        :rtype: int
        """
        self.peek()
        return self.out_stack.pop()

    def peek(self):
        """
        :rtype: int
        """
        if not self.out_stack:
            while self.in_stack:
                self.out_stack.append(self.in_stack.pop())
        return self.out_stack[-1]  

    def empty(self):
        """
        :rtype: bool
        """
        return not self.out_stack and not self.in_stack

# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()