"""Using two stack approach"""

"""Getting wrong answer for peek
Your input
["MyQueue","push","push","peek","pop","empty"]
[[],[1],[2],[],[],[]]
Output
[null,null,null,None,1,false]
Expected
[null,null,null,1,1,false]"""

class MyQueue(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.push_stack = []
        self.pop_stack = []        
        

    def push(self, x):
        """
        Push element x to the back of queue.
        :type x: int
        :rtype: None
        """
        self.push_stack.append(x)        
        

    def pop(self):
        """
        Removes the element from in front of queue and returns that element.
        :rtype: int
        """
        while len(self.push_stack) != 0:
            self.pop_stack.append(self.push_stack.pop())
        return self.pop_stack.pop()
        

    def peek(self):
        """
        Get the front element.
        :rtype: int
        """
        if self.pop_stack != None and len(self.pop_stack) != 0:
            return self.pop_stack[-1]
        
        

    def empty(self):
        """
        Returns whether the queue is empty.
        :rtype: bool
        """
        if self.push_stack == None and self.pop_stack == None:
            return True
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()