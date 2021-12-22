# Time Complexity : O(1) for push, peek, O(n) for pop operation
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : None

# Your code here along with comments explaining your approach : using 2 stacks I pop from stack 1 and add to stack 2 and check both the stacks for the output

# BruteForce 2
class MyQueue(object):

    def __init__(self):
        self.stack = []
        self.opp_stack = []

    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        self.stack.append(x)
        

    def pop(self):
        """
        :rtype: int
        """ 
        if self.opp_stack:
            return self.opp_stack.pop()
        while self.stack:
            self.opp_stack.append(self.stack.pop())
        temp = self.opp_stack.pop()
        # while self.opp_stack:
        #     self.stack.append(self.opp_stack.pop())
        return temp
        

    def peek(self):
        """
        :rtype: int
        """
        return self.stack[0] if bool(self.stack) else self.opp_stack[-1]

    def empty(self):
        """
        :rtype: bool
        """
        return not bool(self.stack) and not bool(self.opp_stack)


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()



# BruteForce
# class MyQueue(object):

#     def __init__(self):
#         self.stack = []
#         self.opp_stack = []

#     def push(self, x):
#         """
#         :type x: int
#         :rtype: None
#         """
#         self.stack.append(x)
        

#     def pop(self):
#         """
#         :rtype: int
#         """ 
#         if len(self.stack) == 0 and len(self.opp_stack) == 0:
#             return "Q is empty"
#         elif len(self.opp_stack) == 0:
#             while self.stack:
#                 self.opp_stack.append(self.stack.pop())
#             return self.opp_stack.pop()
#         else:
#             return self.opp_stack.pop()

#     def peek(self):
#         """
#         :rtype: int
#         """
#         return self.opp_stack[-1] if self.opp_stack else self.stack[0]

#     def empty(self):
#         """
#         :rtype: bool
#         """
#         return not bool(self.stack) and not bool(self.opp_stack)