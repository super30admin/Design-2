""" Explanation: The push method simply appends the element to the first stack
    The pop methods loops over the entire stack1 to pop the element from the stack2
    The peek method returns the first element at the beginning of stack 1, and if stack 2 has any elements, then returns the last element of stack 2
    empty method checks if the both the stacks are empty or not
    Time Complexcity: O(1) for push, peek and empty, O(n) for pop
    Space Complexcity: O(n)
"""


class MyQueue(object):
    
    def __init__(self):
        self.stack1 = []
        self.stack2 = []

    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        self.stack1.append(x)

    def pop(self):
        """
        :rtype: int
        """
        if(len(self.stack2)==0):
            while(len(self.stack1)):
                self.stack2.append(self.stack1.pop())
        return self.stack2.pop()

        
    def peek(self):
        """
        :rtype: int
        """
        if self.stack2:
            return self.stack2[-1]
        return self.stack1[0]

    def empty(self):
        """
        :rtype: bool
        """
        return len(self.stack1) == 0 and len(self.stack2) == 0
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()